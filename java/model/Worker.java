/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookpro
 */
public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private List<SalaryHistory> salaryHistory;

    public Worker(String id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.salaryHistory = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<SalaryHistory> getSalaryHistory() {
        return salaryHistory;
    }

    public void addSalaryHistory(SalaryHistory history) {
        salaryHistory.add(history);
    }
}