package hospital;

// Represents a node in the custom Treatment Stack
public class StackNode {
    Treatment data;
    StackNode next;

    public StackNode(Treatment data) {
        this.data = data;
        this.next = null;
    }
}
