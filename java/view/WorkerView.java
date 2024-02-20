/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.WorkerController;
import java.text.ParseException;
import java.util.Scanner;
import model.Worker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.SalaryHistory;
public class WorkerView {
    private WorkerController workerController;

    public WorkerView(WorkerController workerController) {
        this.workerController = workerController;
    }

    public void displayMenu() {
        System.out.println("=====Worker Management=====");
        System.out.println("1. Add a Worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display information salary");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    public void addWorker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ------add worker----- ");
        System.out.print("Enter Code: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        

        Worker worker = new Worker(id, name, age, salary);
        workerController.addWorker(worker);

        System.out.println("successfully.");
    }

    public void increaseSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ------up salary----- ");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter salary: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Date (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            date = new Date();
            System.out.println("Invalid date format. Using current date instead.");
        }

        workerController.increaseSalary(id, amount, date);

        System.out.println("successfully.");
    }

    public void decreaseSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ------down salary----- ");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter salary: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Date (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            date = new Date();
            System.out.println("Invalid date format. Using current date instead.");
        }

        workerController.decreaseSalary(id, amount, date);

        System.out.println("successfully.");
    }

    public void showAdjustedSalaryWorkerInfo() {
    List<Worker> workers = workerController.getAllWorkers();

    System.out.println("----------Display Information Salary----------");
    System.out.println("Code\tName\tAge\tSalary\tStatus\tDate");

    for (Worker worker : workers) {
        List<SalaryHistory> salaryHistory = worker.getSalaryHistory();
        for (SalaryHistory history : salaryHistory) {
            System.out.println(
                "W " + worker.getId() + "\t" +
                worker.getName() + "\t" +
                worker.getAge() + "\t" +
                worker.getSalary() + "\t" +
                history.getStatus() + "\t" +
                formatDate(history.getDate())
            );
        }
    }
}

private String formatDate(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return dateFormat.format(date);
}
}