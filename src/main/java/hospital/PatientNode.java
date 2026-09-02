package hospital;

// One node in the Binary Search Tree
public class PatientNode {
    Patient data;
    PatientNode left;
    PatientNode right;

    public PatientNode(Patient data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
