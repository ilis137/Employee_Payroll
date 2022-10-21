package com.javapractice;

public class Payroll {
  private int id;
  private String name;
  private double salary;

  public Payroll(int id, String name, Double salary) {
      this.id = id;
      this.name = name;
      this.salary = salary;
  }

  @Override
  public String toString() {
      return "id:" + id +
              " name: " + name +
              " salary: " + salary ;
  }
}
