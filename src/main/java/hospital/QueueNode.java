package hospital;

// Represents a node in the custom Emergency Queue
public class QueueNode {
    Patient data;
    QueueNode next;

    public QueueNode(Patient data) {
        this.data = data;
        this.next = null;
    }
}
