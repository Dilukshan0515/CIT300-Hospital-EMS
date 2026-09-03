package hospital;

// Custom Queue implementation (FIFO) for Emergency Patients built from scratch
public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // ---------- ENQUEUE ----------
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient ID " + patient.getPatientId() + " (" + patient.getName() + ") added to emergency queue.");
    }

    // ---------- DEQUEUE ----------
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patient to treat.");
            return null;
        }
        Patient patientToTreat = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Patient ID " + patientToTreat.getPatientId() + " (" + patientToTreat.getName() + ") called for emergency treatment.");
        return patientToTreat;
    }

    // ---------- PEEK ----------
    public Patient peek() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }
        return front.data;
    }

    // ---------- DISPLAY QUEUE ----------
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No emergency patients in the queue.");
            return;
        }

        System.out.println("\n--- Emergency Patient Queue (Front to Rear) ---");
        QueueNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println("Pos " + position + ": " + current.data);
            current = current.next;
            position++;
        }
        System.out.println("Total waiting emergency patients: " + size);
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }
}
