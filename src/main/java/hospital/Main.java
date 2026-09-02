package hospital;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("========================================");
        System.out.println(" Welcome to Hospital Management System");
        System.out.println("========================================");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new patient");
            System.out.println("2. Search for a patient by ID");
            System.out.println("3. Delete a patient by ID");
            System.out.println("4. Display all patients (in-order)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    addPatient(scanner, bst);
                    break;
                case 2:
                    searchPatient(scanner, bst);
                    break;
                case 3:
                    deletePatient(scanner, bst);
                    break;
                case 4:
                    System.out.println("\n--- All Patients (In-Order) ---");
                    bst.displayInOrder();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }

    private static String readString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static void addPatient(Scanner scanner, PatientBST bst) {
        System.out.println("\n--- Add New Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = readInt(scanner);

        String name = readString(scanner, "Enter Name: ");

        System.out.print("Enter Age: ");
        int age = readInt(scanner);

        String contact = readString(scanner, "Enter Contact Number: ");
        String condition = readString(scanner, "Enter Medical Condition: ");

        Patient newPatient = new Patient(id, name, age, contact, condition);
        bst.insert(newPatient);
        System.out.println("Patient record processed successfully.");
    }

    private static void searchPatient(Scanner scanner, PatientBST bst) {
        System.out.println("\n--- Search Patient ---");
        System.out.print("Enter Patient ID to search: ");
        int id = readInt(scanner);

        Patient found = bst.search(id);
        if (found != null) {
            System.out.println("Patient Found: " + found);
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private static void deletePatient(Scanner scanner, PatientBST bst) {
        System.out.println("\n--- Delete Patient ---");
        System.out.print("Enter Patient ID to delete: ");
        int id = readInt(scanner);

        bst.delete(id);
    }
}

