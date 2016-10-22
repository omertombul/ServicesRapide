package com.mathieu.baseD;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    // class Vars
    Connection conn = null;
    Statement stmt = null;
    String SQL = null;
    ResultSet rs = null;
    
    // vars for test
    String utilisateur = "utilisateur"; // c'est la table de la DB to select from.
    String idUsager = ""; // remplacer par userObj.idUsager
    
    /**
     * constructeur String s n'est pas utilise pour le moment
     */
    public DbConnection(String SQL) { 
        this.SQL = SQL;
        //idUsagerAtrouver = usagerAtrouver; // will be replaced by primary key eventually
        Connection conn = makeConnection();
        Statement stmt = makeStatement();
    }

    private Connection makeConnection() {
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
            conn
                    = DriverManager.getConnection(url, usr, psw);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("Made Connection");
        return conn;
    }

    private Statement makeStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex + "Error making DB statement");
        }
        return stmt;
    }

    private void insertToDB() {
        System.out.println("Start Insert data into DB");
        try {
            System.out.println("SQL string is: " + SQL);
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            System.out.println(ex + "    Error Putting new Data into DB");
        }
        System.out.println("End Insert data into DB");
    }

    public ResultSet readFromDataBase() {
        System.out.println("Start get RS");
        try {
            System.out.println("SQL string is: " + SQL);
            stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            System.out.println(ex + "    Error Getting Data: rs");
        }
        System.out.println("End get RS");
        return rs;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex + "Error Closing Connection");
        }
        System.out.println("Connection closed");
    }
}