package hospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PatientBST patientBst = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        VisitLinkedList visitList = new VisitLinkedList();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println(" Hospital Emergency Management System");
        System.out.println("     CIT300 - Data Structures Assignment");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n=========================================");
            System.out.println("            SYSTEM MAIN MENU");
            System.out.println("=========================================");
            System.out.println("1. Patient Records Management (BST)");
            System.out.println("2. Emergency Patient Queue (Queue)");
            System.out.println("3. Treatment History Management (Stack)");
            System.out.println("4. Patient Visit History (Singly Linked List)");
            System.out.println("5. Exit System");
            System.out.print("Enter your choice (1-5): ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    patientBstMenu(scanner, patientBst);
                    break;
                case 2:
                    emergencyQueueMenu(scanner, patientBst, emergencyQueue);
                    break;
                case 3:
                    treatmentStackMenu(scanner, patientBst, treatmentStack);
                    break;
                case 4:
                    visitLinkedListMenu(scanner, patientBst, visitList);
                    break;
                case 5:
                    running = false;
                    System.out.println("\nThank you for using Hospital Emergency Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }

    // =========================================================================
    // 1. PATIENT RECORDS MENU (BST)
    // =========================================================================
    private static void patientBstMenu(Scanner scanner, PatientBST bst) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Patient Records Submenu (Binary Search Tree) ---");
            System.out.println("1. Add a new patient record");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Delete patient by ID");
            System.out.println("4. Display all patients (In-order traversal)");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter option (1-5): ");

            int option = readInt(scanner);
            switch (option) {
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
                    System.out.println("\n--- All Patient Records (Sorted by ID) ---");
                    bst.displayInOrder();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Enter a number between 1 and 5.");
                    break;
            }
        }
    }

    // =========================================================================
    // 2. EMERGENCY QUEUE MENU (Queue)
    // =========================================================================
    private static void emergencyQueueMenu(Scanner scanner, PatientBST bst, EmergencyQueue queue) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Emergency Queue Submenu (Custom FIFO Queue) ---");
            System.out.println("1. Enqueue patient for emergency treatment");
            System.out.println("2. Treat / Dequeue next emergency patient");
            System.out.println("3. Peek next patient in emergency queue");
            System.out.println("4. Display emergency queue status");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter option (1-5): ");

            int option = readInt(scanner);
            switch (option) {
                case 1:
                    System.out.print("\nEnter Patient ID for emergency queue: ");
                    int id = readInt(scanner);
                    Patient p = bst.search(id);
                    if (p == null) {
                        System.out.println("Patient ID " + id + " not found in main records. Please register patient first.");
                        System.out.print("Would you like to register this patient now? (y/n): ");
                        String resp = scanner.nextLine().trim();
                        if (resp.equalsIgnoreCase("y")) {
                            p = createPatientWithId(scanner, id);
                            bst.insert(p);
                            queue.enqueue(p);
                        } else {
                            System.out.println("Patient not added to queue.");
                        }
                    } else {
                        queue.enqueue(p);
                    }
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    Patient peeked = queue.peek();
                    if (peeked != null) {
                        System.out.println("Next Patient in Line: " + peeked);
                    }
                    break;
                case 4:
                    queue.displayQueue();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Enter a number between 1 and 5.");
                    break;
            }
        }
    }

    // =========================================================================
    // 3. TREATMENT STACK MENU (Stack)
    // =========================================================================
    private static void treatmentStackMenu(Scanner scanner, PatientBST bst, TreatmentStack stack) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Treatment History Submenu (Custom LIFO Stack) ---");
            System.out.println("1. Record new treatment action (Push)");
            System.out.println("2. Undo / Remove last treatment action (Pop)");
            System.out.println("3. View most recent treatment (Peek)");
            System.out.println("4. Display complete treatment history log");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter option (1-5): ");

            int option = readInt(scanner);
            switch (option) {
                case 1:
                    System.out.print("\nEnter Treatment ID: ");
                    int treatmentId = readInt(scanner);

                    System.out.print("Enter Patient ID: ");
                    int patientId = readInt(scanner);

                    String doctor = readString(scanner, "Enter Attending Doctor Name: ");
                    String details = readString(scanner, "Enter Treatment Action Details: ");
                    String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    Treatment treatment = new Treatment(treatmentId, patientId, doctor, details, time);
                    stack.push(treatment);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Treatment topTreatment = stack.peek();
                    if (topTreatment != null) {
                        System.out.println("Most Recent Treatment: " + topTreatment);
                    }
                    break;
                case 4:
                    stack.displayStack();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Enter a number between 1 and 5.");
                    break;
            }
        }
    }

    // =========================================================================
    // 4. VISIT LINKED LIST MENU (Singly Linked List)
    // =========================================================================
    private static void visitLinkedListMenu(Scanner scanner, PatientBST bst, VisitLinkedList visitList) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Patient Visit History Submenu (Singly Linked List) ---");
            System.out.println("1. Log new patient visit");
            System.out.println("2. Search visit history by Patient ID");
            System.out.println("3. Display all recorded visit history");
            System.out.println("4. Delete a visit record by Visit ID");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter option (1-5): ");

            int option = readInt(scanner);
            switch (option) {
                case 1:
                    System.out.print("\nEnter Visit ID: ");
                    int visitId = readInt(scanner);

                    System.out.print("Enter Patient ID: ");
                    int pId = readInt(scanner);

                    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.print("Visit Date (default: " + date + ", press Enter to use default or type date): ");
                    String inputDate = scanner.nextLine().trim();
                    if (!inputDate.isEmpty()) {
                        date = inputDate;
                    }

                    String doc = readString(scanner, "Enter Doctor Name: ");
                    String diag = readString(scanner, "Enter Diagnosis / Purpose of Visit: ");

                    Visit visit = new Visit(visitId, pId, date, doc, diag);
                    visitList.addVisit(visit);
                    break;
                case 2:
                    System.out.print("\nEnter Patient ID to search visit records: ");
                    int searchId = readInt(scanner);
                    visitList.displayVisitsByPatientId(searchId);
                    break;
                case 3:
                    visitList.displayAllVisits();
                    break;
                case 4:
                    System.out.print("\nEnter Visit ID to delete: ");
                    int delId = readInt(scanner);
                    visitList.deleteVisit(delId);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Enter a number between 1 and 5.");
                    break;
            }
        }
    }

    // =========================================================================
    // HELPER METHODS FOR INPUT & PATIENT CREATION
    // =========================================================================
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

        if (bst.search(id) != null) {
            System.out.println("A patient with ID " + id + " already exists in the BST!");
            return;
        }

        Patient newPatient = createPatientWithId(scanner, id);
        bst.insert(newPatient);
        System.out.println("Patient record inserted into Binary Search Tree successfully.");
    }

    private static Patient createPatientWithId(Scanner scanner, int id) {
        String name = readString(scanner, "Enter Name: ");
        System.out.print("Enter Age: ");
        int age = readInt(scanner);
        String contact = readString(scanner, "Enter Contact Number: ");
        String condition = readString(scanner, "Enter Medical Condition: ");
        return new Patient(id, name, age, contact, condition);
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
