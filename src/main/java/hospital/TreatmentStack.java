package hospital;

// Custom Stack implementation (LIFO) for Treatment History built from scratch
public class TreatmentStack {
    private StackNode top;
    private int size;

    public TreatmentStack() {
        this.top = null;
        this.size = 0;
    }

    // ---------- PUSH ----------
    public void push(Treatment treatment) {
        StackNode newNode = new StackNode(treatment);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment ID " + treatment.getTreatmentId() + " logged for Patient ID " + treatment.getPatientId());
    }

    // ---------- POP ----------
    public Treatment pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty. No record to undo/remove.");
            return null;
        }
        Treatment removedTreatment = top.data;
        top = top.next;
        size--;
        System.out.println("Removed most recent treatment record (ID: " + removedTreatment.getTreatmentId() + ")");
        return removedTreatment;
    }

    // ---------- PEEK ----------
    public Treatment peek() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }
        return top.data;
    }

    // ---------- DISPLAY STACK ----------
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment history logged.");
            return;
        }

        System.out.println("\n--- Treatment History (Most Recent First) ---");
        StackNode current = top;
        int level = 1;
        while (current != null) {
            System.out.println("[" + level + "] " + current.data);
            current = current.next;
            level++;
        }
        System.out.println("Total treatment records: " + size);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}
