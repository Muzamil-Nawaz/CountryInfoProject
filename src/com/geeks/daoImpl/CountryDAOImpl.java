/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geeks.daoImpl;

import com.geeks.beans.CountryBean;
import com.geeks.beans.ProvinceBean;
import com.geeks.connection.DbConnection;
import com.geeks.dao.CountryDAO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author samee
 */
public class CountryDAOImpl implements CountryDAO{

  DbConnection connection;
  @Override
  public List<CountryBean> getAllCountries() {
    List<CountryBean> countryBeans=new ArrayList<>();
    try
    {  
      Connection con=connection.makeConnection();
      PreparedStatement stmt=con.prepareStatement("select * from country");
      ResultSet rst=stmt.executeQuery();
      
      while(rst.next()){
       CountryBean cb= new CountryBean();
        cb.setCountryId(rst.getInt(1));
        cb.setName(rst.getString(2));
        countryBeans.add(cb);
      }
    }
    catch(Exception exe){
      exe.printStackTrace();
    }
    return countryBeans;
  }

  @Override
  public CountryBean getCountryById(Integer countryId)
  {
    CountryBean cb= new CountryBean();
    try
   {
       Connection con =connection.makeConnection();
       PreparedStatement stmt=con.prepareStatement("select * from country where country_id= ?");
       stmt.setInt(1, countryId);
       ResultSet rst=stmt.executeQuery();
      
         while(rst.next())
         {
         
          cb.setCountryId(rst.getInt(1));
          cb.setName(rst.getString(2));
        
         }

   }
   catch(Exception e)
   {
     
     e.getStackTrace();
   }
    return cb;
  
  }

  @Override
  public CountryBean getCountryByName(String name) {
   CountryBean cb= new CountryBean();
    try
   {
       Connection con =connection.makeConnection();
       PreparedStatement stmt=con.prepareStatement("select * from country where name= ?");
       stmt.setString(1, name);
       ResultSet rst=stmt.executeQuery();
      
         while(rst.next())
         {
         
          cb.setCountryId(rst.getInt(1));
          cb.setName(rst.getString(2));
        
         }

   }
   catch(Exception e)
   {
     
     e.getStackTrace();
   }
    return cb;
  }

  @Override
  public Integer addCountry(String name) {
    Integer row=0; 
    try
     {
       Connection con=DbConnection.makeConnection();
       PreparedStatement pst=con.prepareStatement("insert into country(name) values(?)");
       pst.setString(1, name);
       row=pst.executeUpdate();
     }
     catch(Exception exe){
     
     }
    return row;
  }

  @Override
  public ResultSet getAllCountriesRS() {
 ResultSet rst=null;
    try
    {  
      Connection con=connection.makeConnection();
      PreparedStatement stmt=con.prepareStatement("select * from country");
      rst=stmt.executeQuery();
      
    }
    catch(Exception exe){
      exe.printStackTrace();
    } 
    return rst;
  }

  @Override
  public Integer updateCountry(String name, Integer countryId) {
   Integer row=0;
   System.out.println(name+"   "+countryId);
    try
    {  
      Connection con=connection.makeConnection();
      PreparedStatement stmt=con.prepareStatement("update country set "
              + "name=? where country_id=?");
      stmt.setString(1, name);
      stmt.setInt(2,countryId);
      row=stmt.executeUpdate();
    }
    catch(Exception exe){
      exe.printStackTrace();
    } 
     return row;
  }
  
}
