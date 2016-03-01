package com.learning.examples.views;

import io.dropwizard.views.View;


public class ReportView extends View {

  private final String name;
  private final Integer age;
  private final String address;



  public ReportView() {
    super("home.ftl");
    this.name = "Ahmad";
    this.age = 1;
    this.address = "Delhi";
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
}