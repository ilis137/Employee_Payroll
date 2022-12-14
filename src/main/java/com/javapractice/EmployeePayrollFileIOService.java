package com.javapractice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
  public static String PAYROLL_FILE_NAME = "E:\\brglabz\\RFP\\day-27\\employee_payroll\\src\\main\\resources\\payroll-file.txt";

  public void write(List<Payroll> employeePayrollList) {
    StringBuffer empBuffer = new StringBuffer();
    employeePayrollList.forEach(employee -> {
      String empDataString = employee.toString().concat("\n");
      empBuffer.append(empDataString);
    });
    try {
      Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
    } catch (IOException x) {
      x.printStackTrace();
    }
  }

  public long countEntries() {
    long entries = 0;
    try {
      entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath())
          .count();
     
    } catch (IOException x) {
      x.printStackTrace();
    }
    System.out.println("no. of entries: "+entries);
    return entries;
  }

  public void printData() {
    try {
      Files.lines(new File(PAYROLL_FILE_NAME).toPath())
          .forEach(System.out::println);
    } catch (IOException x) {
      x.printStackTrace();
    }
  }
}
