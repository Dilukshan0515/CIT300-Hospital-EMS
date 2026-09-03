package hospital;

// Represents a node in the custom Singly Linked List for Patient Visits
public class VisitNode {
    Visit data;
    VisitNode next;

    public VisitNode(Visit data) {
        this.data = data;
        this.next = null;
    }
}
