package com.javapractice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayrollDBService {
  String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll?useSSl=false";
  String userBane = "root";
  String password = "root";
  Connection connection;

  public void loadDrivers() {
    try { // Loading the driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver Loaded");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("Cannot find the driver in the classpath!", e);
    }
  }

  public void listDrivers() {
    Enumeration<Driver> driverList = DriverManager.getDrivers();
    while (driverList.hasMoreElements()) {
      Driver driverClass = driverList.nextElement();
      System.out.println("  " + driverClass.getClass().getName());
    }
  }

  public void connectDatabase() {
    try { // Connecting to database, DriverManager is the interface
      System.out.println("Connecting to database: " + jdbcURL);
      connection = DriverManager.getConnection(jdbcURL, userBane, password);
      System.out.println("Connection is succesful!!" + connection);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public static void main(String[] args) {
    EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();
    employeePayrollDBService.loadDrivers();
    employeePayrollDBService.listDrivers();
    employeePayrollDBService.connectDatabase();
  }
}
