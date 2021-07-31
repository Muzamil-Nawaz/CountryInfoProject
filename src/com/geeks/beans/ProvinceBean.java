/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geeks.beans;

/**
 *
 * @author samee
 */
public class ProvinceBean {
  
  private Integer provinceId;
  private String name;
  private CountryBean countryBean;

  public Integer getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(Integer provinceId) {
    this.provinceId = provinceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CountryBean getCountryBean() {
    return countryBean;
  }

  public void setCountryBean(CountryBean countryBean) {
    this.countryBean = countryBean;
  }
  
  
}
