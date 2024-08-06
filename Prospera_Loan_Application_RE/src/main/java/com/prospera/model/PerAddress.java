package com.prospera.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PerAddress 
{
  private String areaName;
  private String cityName;
  private String district;
  private int pincode;
  private String state;
  private String country;
}
