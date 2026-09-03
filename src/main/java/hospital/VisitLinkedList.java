package hospital;

// Custom Singly Linked List for managing Patient Visit History built from scratch
public class VisitLinkedList {
    private VisitNode head;
    private int size;

    public VisitLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // ---------- ADD VISIT (Append) ----------
    public void addVisit(Visit visit) {
        VisitNode newNode = new VisitNode(visit);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Visit ID " + visit.getVisitId() + " recorded for Patient ID " + visit.getPatientId());
    }

    // ---------- SEARCH VISITS BY PATIENT ID ----------
    public void displayVisitsByPatientId(int patientId) {
        if (isEmpty()) {
            System.out.println("No visit records found in system.");
            return;
        }

        System.out.println("\n--- Visit Records for Patient ID: " + patientId + " ---");
        VisitNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.data.getPatientId() == patientId) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No visit records found for Patient ID " + patientId);
        }
    }

    // ---------- DISPLAY ALL VISITS ----------
    public void displayAllVisits() {
        if (isEmpty()) {
            System.out.println("No visit records registered.");
            return;
        }

        System.out.println("\n--- All Patient Visit Records ---");
        VisitNode current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.data);
            current = current.next;
            count++;
        }
        System.out.println("Total visit records: " + size);
    }

    // ---------- DELETE VISIT BY VISIT ID ----------
    public boolean deleteVisit(int visitId) {
        if (isEmpty()) {
            System.out.println("Visit history is empty. Nothing deleted.");
            return false;
        }

        if (head.data.getVisitId() == visitId) {
            head = head.next;
            size--;
            System.out.println("Visit record ID " + visitId + " deleted successfully.");
            return true;
        }

        VisitNode current = head;
        while (current.next != null && current.next.data.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            System.out.println("Visit record ID " + visitId + " deleted successfully.");
            return true;
        }

        System.out.println("Visit record ID " + visitId + " not found.");
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}
