/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author macbookpro
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SalaryHistory;
import model.Worker;

public class WorkerController {
    private List<Worker> workers;

    public WorkerController() {
        workers = new ArrayList<>();
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public List<Worker> getAllWorkers() {
        return workers;
    }

    public Worker getWorkerById(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

    public void increaseSalary(String id, double amount, Date date) {
        Worker worker = getWorkerById(id);
        if (worker != null) {
            double currentSalary = worker.getSalary();
            worker.setSalary(currentSalary + amount);
            SalaryHistory salaryHistory = new SalaryHistory(amount, "UP", date);
            worker.addSalaryHistory(salaryHistory);
        }
    }

    public void decreaseSalary(String id, double amount, Date date) {
        Worker worker = getWorkerById(id);
        if (worker != null) {
            double currentSalary = worker.getSalary();
            worker.setSalary(currentSalary - amount);
            SalaryHistory salaryHistory = new SalaryHistory(amount, "DOWN", date);
            worker.addSalaryHistory(salaryHistory);
        }
    }

}
