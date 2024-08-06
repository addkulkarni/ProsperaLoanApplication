package com.prospera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Bank 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bid;
  private String bankName;
  private String branch;
  private String ifscCode;
  private long accNo;
  private String accType;
  
}
