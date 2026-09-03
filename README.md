# Mini Hospital Emergency Management System

## Overview
A Java console application built for CIT300 - Data Structures and Algorithms (Individual Mid Assignment). The system simulates hospital operations including patient registration, emergency queue management, treatment history tracking, and patient visit history — each implemented using a specific data structure built from scratch (no built-in Java collection classes for these core parts).

## Data Structures Used
| Feature | Data Structure | Status |
| :--- | :--- | :--- |
| **Patient Records** | Binary Search Tree (`PatientBST`) | ✅ Completed |
| **Emergency Patient Queue** | Custom Queue (`EmergencyQueue`) | ✅ Completed |
| **Treatment History** | Custom Stack (`TreatmentStack`) | ✅ Completed |
| **Patient Visit History** | Custom Singly Linked List (`VisitLinkedList`) | ✅ Completed |

## Project Structure
```
CIT300-Hospital-EMS/
│
├── bin/                       # Compiled .class files
└── src/main/java/hospital/
    ├── Main.java              # Main interactive console driver & submenus
    ├── Patient.java           # Patient entity
    ├── PatientNode.java       # Node for Patient BST
    ├── PatientBST.java        # Binary Search Tree implementation
    ├── QueueNode.java         # Node for Emergency Queue
    ├── EmergencyQueue.java    # Custom FIFO Queue implementation
    ├── Treatment.java         # Treatment entity
    ├── StackNode.java         # Node for Treatment Stack
    ├── TreatmentStack.java    # Custom LIFO Stack implementation
    ├── Visit.java             # Visit record entity
    ├── VisitNode.java         # Node for Visit Linked List
    └── VisitLinkedList.java   # Custom Singly Linked List implementation
```

## Core Features & Functionalities

### 1. Patient Records (Binary Search Tree - `PatientBST`)
- **Insert Patient**: Keyed by unique Patient ID.
- **Search Patient**: Efficient binary search by Patient ID.
- **Delete Patient**: Handles leaf nodes, single child, and double child deletion.
- **In-Order Traversal**: Displays all patients sorted in ascending order by ID.

### 2. Emergency Patient Queue (Custom FIFO Queue - `EmergencyQueue`)
- **Enqueue Emergency Patient**: Add patient to emergency waiting queue (FIFO).
- **Treat / Dequeue Patient**: Remove and process next emergency patient.
- **Peek Next Patient**: View patient currently at front of queue.
- **Display Queue Status**: Show all queued emergency patients in sequence.

### 3. Treatment History (Custom LIFO Stack - `TreatmentStack`)
- **Log Treatment Action (Push)**: Record medical actions performed on patients.
- **Undo Treatment Action (Pop)**: Remove most recent treatment record.
- **Peek Latest Treatment**: View most recent treatment log.
- **Display Stack**: View all treatment actions (most recent first).

### 4. Patient Visit History (Custom Singly Linked List - `VisitLinkedList`)
- **Log Patient Visit (Append)**: Register a consultation/visit record.
- **Search Visit History**: Retrieve all visit records for a specific Patient ID.
- **Display All Visits**: View all patient visits sequentially.
- **Delete Visit Record**: Delete a specific visit record by Visit ID.

## Compilation & Execution Instructions

### Compile
```powershell
javac -d bin src/main/java/hospital/*.java
```

### Run
```powershell
java -cp bin hospital.Main
```

## Author
A.Dilukshan  
23DA2-0601  
CIT300 - Data Structures and Algorithms