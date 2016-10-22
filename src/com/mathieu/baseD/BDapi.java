package com.mathieu.baseD;

import com.francis.utilisateur.utilisateur.*;
import com.francis.*;
import java.sql.ResultSet;

// test libraries
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Write a description of class BDapi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BDapi{
    //DbReadFromUsager db;
    //ResultSet rs;
    
    public BDapi(){
        System.out.println("Constructeur Api");
    }
    
    public void addUser(Utilisateur U){
        System.out.println("Debut requete");
        String SQL;
        SQL = "INSERT INTO utilisateur VALUES('";
        SQL += U.identifiant.nomUtilisateur + "', '";
        SQL += U.identifiant.motDePasse + "', '";
        SQL += U.profile.nom + "', '";
        SQL += U.profile.prenom + "', '";
        SQL += U.profile.adresseCourriel + "', '1";
        SQL += "', '1"; // disponibilite
        SQL += "', '1"; // cote
        SQL += "');"; // GEOLOC
        
        System.out.println(SQL);
        
        //String SQL = "INSERT INTO utilisateur VALUES('usager1', 'abcd1234', 'StPierre', 'Georges', 'gsp@test.com', '1', '99', '45.5017');";
        DbConnection db = new DbConnection(U.identifiant.nomUtilisateur, SQL);
        
        //ResultSet rs = db.getResultSet();
    }
    
    /**
     * constructeur
     */
//    public void getUserInfoFromDB(Utilisateur U){
//        String SQL = "SELECT * FROM utilisateur WHERE idUsager = '" + U.idUsager + "'";
//        DbReadFromUsager db = new DbReadFromUsager(U.idUsager, SQL);
//        ResultSet rs = db.getResultSet();
//
//        try{
//            rs.beforeFirst();
//            while(rs.next()){
//                U.motDePasse = rs.getString("motDePasse");
//                U.nom = rs.getString("nom");
//                U.preNom = rs.getString("prenom");
//                U.courriel = rs.getString("courriel");
//            }
//        } catch (Exception ex){
//            System.out.println("Could not get RS.");
//        }
//        db.closeConnection();
//    }
    
//    private String makeSqlString(String table, String searchKey){
//        String SQL = "SELECT * FROM " + table + " WHERE idUsager = '" + searchKey + "'";
//        return SQL;
//    }
}