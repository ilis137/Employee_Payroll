package com.javapractice;

import java.time.LocalDate;

public class Payroll {
  private int id;
  private String name;
  private double salary;
  private LocalDate startDate;
  public Payroll(int id, String name, Double salary) {
      this.id = id;
      this.name = name;
      this.salary = salary;
  }

  public Payroll(int id, String name, double salary, LocalDate startDate) {
    this(id, name,salary);
    this.startDate = startDate;
  }

  @Override
  public String toString() {
      return "id:" + id +
              " name: " + name +
              " salary: " + salary ;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
}
