/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geeks.daoImpl;

import com.geeks.beans.ProvinceBean;
import com.geeks.dao.ProvinceDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.geeks.connection.DbConnection;

/**
 *
 * @author samee
 */
public class ProvinceDAOImpl implements ProvinceDAO{

  
   DbConnection connection;
  @Override
  public List<ProvinceBean> getAllProvinces() {
    
    
      List<ProvinceBean> provinceBeans=new ArrayList<>();
      
    try
    {  
      Connection con=connection.makeConnection();
      PreparedStatement stmt=con.prepareStatement("select * from province");
      ResultSet rst=stmt.executeQuery();
      
      while(rst.next()){
       ProvinceBean pb= new ProvinceBean();
        pb.setProvinceId(rst.getInt(1));
        pb.setName(rst.getString(2));
        provinceBeans.add(pb);
      }
    }
    catch(Exception exe){
      exe.printStackTrace();
    }
    return provinceBeans;
  
  
  }

  @Override
  public ProvinceBean getProvinceById(Integer provinceId) 
  {
     return null;
  
  
  
  }

  @Override
  public List<ProvinceBean> getAllProvicesByCountry(Integer countryId) {
    List<ProvinceBean> provinces= new ArrayList<>();
    try
      {
        Connection con=DbConnection.makeConnection();
        PreparedStatement pst=con.prepareStatement("select * from province where country_id=?");
        pst.setInt(1, countryId);
        ResultSet rst=pst.executeQuery();
        while(rst.next())
        {
          ProvinceBean pb= new ProvinceBean();
          pb.setProvinceId(rst.getInt(1));
          pb.setName(rst.getString(2));
          provinces.add(pb);
        }          
      }
      catch(Exception exe){
        exe.printStackTrace();
      }
    return provinces;
  }
  
  
  
}
