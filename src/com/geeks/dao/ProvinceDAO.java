/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geeks.dao;

import com.geeks.beans.ProvinceBean;
import java.util.List;

/**
 *
 * @author samee
 */
public interface ProvinceDAO {
  
  public List<ProvinceBean> getAllProvinces();
  public ProvinceBean getProvinceById(Integer provinceId);
  public List<ProvinceBean> getAllProvicesByCountry(Integer countryId);
  
}
