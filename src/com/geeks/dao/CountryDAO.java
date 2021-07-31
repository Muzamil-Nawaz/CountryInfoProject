/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geeks.dao;

import com.geeks.beans.CountryBean;
import java.util.List;
import java.sql.*;

/**
 *
 * @author samee
 */
public interface CountryDAO {
  
  public List<CountryBean> getAllCountries();
  public ResultSet getAllCountriesRS();
  public CountryBean getCountryById(Integer countryId);
  public CountryBean getCountryByName(String name);
  public Integer addCountry(String name);
  public Integer updateCountry(String name, Integer countryId);
  
  
}
