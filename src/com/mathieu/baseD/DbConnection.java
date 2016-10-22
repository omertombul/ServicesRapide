package com.mathieu.baseD;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    // class Vars
    String idUsagerAtrouver = ""; // id a obtenir
    Connection conn = null;
    // vars for test
    String utilisateur = "utilisateur"; // c'est la table de la DB to select from.
    String idUsager = ""; // remplacer par userObj.idUsager
    ResultSet rs = null; // objet qui contient le(s) resultat(s) ou NULL;
    String SQL = null;
    
    /**
     * constructeur
     * String s n'est pas utilise pour le moment
     */
    public DbConnection(String usagerAtrouver, String SQL){  // Remplacer paremetre par ObjUtilisateur U selon besoins
        this.SQL = SQL;
        //idUsagerAtrouver = usagerAtrouver; // will be replaced by primary key eventually
        Connection conn = makeConnection();
        //insertData( conn );
        //rs = getDataFromDb(conn);
        //closeConnection(conn);
    }

    private Connection makeConnection(){

        String url = "jdbc:mysql://localhost:8889/services";
        String usr = "root";
        String psw = "root";
        // register MySQL Connector/J with the DriverManager
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error Connecting.");
        }
        // once the driver is registered, make connection
        try {
            conn =
            DriverManager.getConnection(url, usr, psw);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("Made Connection");
        return conn;
    }
    
    
    private void insertData(Connection conn){
        System.out.println("Start Update");
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
        } catch (SQLException ex){
            System.out.println("Error Getting Data: stmt");
        }
        try{
            System.out.println("SQL string is: " + SQL);
           
              stmt.executeUpdate(SQL);
        } catch (SQLException ex){
            
            System.out.println(ex +  "    Error Getting Data: update");
        }
        System.out.println("End Update");
    
    }

    private ResultSet getDataFromDb(Connection conn){
        System.out.println("Start get RS");
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
        } catch (SQLException ex){
            System.out.println("Error Getting Data: stmt");
        }
        try{
            System.out.println("SQL string is: " + SQL);
            //rs = stmt.executeQuery(SQL);
              stmt.executeQuery(SQL);
        } catch (SQLException ex){
            System.out.println("    Error Getting Data: rs");
        }
        System.out.println("End get RS");
        return rs;
    }

    public void closeConnection(){
        try{
            conn.close();
        } catch (SQLException ex){
            System.out.println("Error Closing Connection");
        }
        System.out.println("");
    }

    public ResultSet getResultSet(){
        return this.rs;
    }
}

