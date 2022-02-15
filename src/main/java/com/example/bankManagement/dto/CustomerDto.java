package com.example.bankManagement.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CustomerDto {
  int id;

  String customerName;

  String identityCardNo;

  String email;

  LocalDateTime createdAt;
}
