/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Entities.Moniteur;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakotomalala Cédric
 */
public class CtrlMoniteur {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CtrlMoniteur() {
    cnx = ConnexionBDD.getCnx();
    }
    public ArrayList<Moniteur> GetAllMoniteur(){
         ArrayList<Moniteur>LesMoniteurs = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("Select CodeMoniteur,nom,prenom,Sexe,DateDeNaissance,Adresse,CodePostal,Ville,Telephone from moniteur");
            rs= ps.executeQuery();
            while(rs.next()){
                Moniteur unMoniteur= new Moniteur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                LesMoniteurs.add(unMoniteur);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LesMoniteurs;
    }
    public int getIdMoniteurByName(String nomM){
        int idMoni=0;
        try {
            ps=cnx.prepareStatement("SELECT CodeMoniteur \n" +
                    "FROM `moniteur`\n" +
                    "WHERE nom =?;");
            ps.setString(1, nomM);
            rs=ps.executeQuery();
            while(rs.next()){
                idMoni=rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
     return idMoni;   
    }
    
    public String getNomMoniteurById(int codeMoniteur){
        String nomMoni="";
        try {
            ps=cnx.prepareStatement("SELECT nom\n" +
                    "FROM `moniteur`\n" +
                    "WHERE CodeMoniteur=?;");
            ps.setInt(1, codeMoniteur);
            rs=ps.executeQuery();
            while(rs.next()){
                nomMoni=rs.getString(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
     return nomMoni;  
    }
    public boolean trouverLicenceMoniteur(int numMoni,int codeCate){
        boolean trouver = false;
        try {
            ps=cnx.prepareStatement("Select CodeCategorie from licence where CodeMoniteur= ? ");
            ps.setInt(1, numMoni);
            rs=ps.executeQuery();
            while(rs.next() && !trouver){
                if(rs.getInt(1)== codeCate){
                    trouver = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trouver;
    }
    public int recupDernierIdLicence() {
        int derNumLicence=0;
        try {
            ps=cnx.prepareStatement("Select CodeLicence\n" +
                    "FROM licence\n" +
                    "ORDER by CodeLicence DESC \n" +
                    "limit 1");
            rs = ps.executeQuery();
            rs.next();
            derNumLicence= rs.getInt(1);
            ps.close();
            rs.close();
            
            derNumLicence = derNumLicence + 1;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    return derNumLicence;
    }
    
       public void modifierMoniteur(int numMoniteur,String nom,String prenom,String dateDeNaiss,String Adresse,int CodePostal,String Ville,String Telephone){
    try{
        ps=cnx.prepareStatement("UPDATE moniteur set nom = ?, prenom=?,dateDeNaissance= ?, Adresse = ?,CodePostal=?,Ville=?,telephone=? where codeMoniteur= ?");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, dateDeNaiss);
            ps.setString(4, Adresse);
            ps.setInt(5, CodePostal);
            ps.setString(6, Ville);
            ps.setString(7, Telephone);
            ps.setInt(8, numMoniteur);
            ps.executeUpdate();
            ps.close();
    } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void ajoutLicenceMoniteur(int numLicence, int numMoniteur, int numCategorie, String dateObtention) {
        try {
            ps = cnx.prepareStatement("Insert into licence Values(?,?,?,?)");
            ps.setObject(1, numLicence);
            ps.setInt(2, numMoniteur);
            ps.setInt(3, numCategorie);
            ps.setString(4, dateObtention);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public Moniteur verifMoniteur(String login , String mdp){
    Moniteur moiMoniteur=null;
    try{
        ps=cnx.prepareStatement("SELECT CodeMoniteur,NOM,Prenom,Sexe,DateDeNaissance,Adresse,CodePostal,Ville,Telephone\n" +
        "FROM `moniteur`\n" +
        "WHERE Login=? and Password =? ;");
        ps.setString(1, login);
        ps.setString(2, mdp);
        rs= ps.executeQuery();
        if(rs.next()){
            moiMoniteur= new Moniteur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9) );
        }
        ps.close();
        rs.close();
         } catch (SQLException ex) {
            Logger.getLogger(CtrlEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    return moiMoniteur;
}
    public float GetChiffreDAffaireMoni(String date1,String date2,int numMoni){
        float CATotal=0;
        try {
            ps=cnx.prepareStatement("SELECT SUM(categorie.prix) AS moniteurCA \n" +
                    "FROM lecon \n" +
                    "JOIN vehicule ON vehicule.Immatriculation = lecon.Immatriculation \n" +
                    "JOIN categorie ON categorie.CodeCategorie = vehicule.CodeCategorie \n" +
                    "WHERE lecon.Reglee = 1 AND CodeMoniteur = ? AND DATE BETWEEN ? AND ?;");
            ps.setInt(1, numMoni);
            ps.setString(2, date1);
            ps.setString(3,date2);
            rs=ps.executeQuery();
            rs.next();
            CATotal= rs.getFloat(1);
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
            return CATotal;
    }
}
