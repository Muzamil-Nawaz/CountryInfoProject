/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geeks.connection;
import java.util.*;
import java.sql.*;
/**
 *
 * @author samee
 */
public class DbConnection {
  private DbConnection(){}
  static Connection con = null;
  public static Connection makeConnection(){
    if (con == null) {
      try {
        Class.forName("com.mysql.jdbc.Driver");				
      }
      catch(ClassNotFoundException ex) {
        System.out.println(ex.getMessage());
        System.out.println("Driver Not Loading");
      }

      try {
        String url = "jdbc:mysql://localhost:3306/centre_work";
        String uname = "root";
        String pwd = "";
        con = DriverManager.getConnection(url, uname, pwd);
        System.out.println("connection created");				
      }
      catch(SQLException e) {
        System.out.println(e.getMessage());       
      }
    }
    return con;
  } 
  public static void main(String[] args) throws Exception {
    System.out.println(DbConnection.makeConnection());
  }
}
