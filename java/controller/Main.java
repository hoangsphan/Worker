/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import view.WorkerView;
import java.util.Scanner;
/**
 *
 * @author macbookpro
 */
public class Main {
    private WorkerController workerController;
    private WorkerView workerView;

    public Main() {
        workerController = new WorkerController();
        workerView = new WorkerView(workerController);
    }

    public void start() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            workerView.displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    workerView.addWorker();
                    break;
                case 2:
                    workerView.increaseSalary();
                    break;
                case 3:
                    workerView.decreaseSalary();
                    break;
                case 4:
                    workerView.showAdjustedSalaryWorkerInfo();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }

        System.out.println("Successfully.");
    }

    public static void main(String[] args) {
        Main system = new Main();
        system.start();
    }
}
