package hospital;

// Binary Search Tree for storing patients, keyed by Patient ID
public class PatientBST {
    private PatientNode root;

    public PatientBST() {
        root = null;
    }

    // ---------- INSERT ----------
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private PatientNode insertRec(PatientNode node, Patient patient) {
        if (node == null) {
            return new PatientNode(patient);
        }
        if (patient.getPatientId() < node.data.getPatientId()) {
            node.left = insertRec(node.left, patient);
        } else if (patient.getPatientId() > node.data.getPatientId()) {
            node.right = insertRec(node.right, patient);
        } else {
            System.out.println("A patient with ID " + patient.getPatientId() + " already exists. Not inserted.");
        }
        return node;
    }

    // ---------- SEARCH ----------
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(PatientNode node, int patientId) {
        if (node == null) {
            return null;
        }
        if (patientId == node.data.getPatientId()) {
            return node.data;
        } else if (patientId < node.data.getPatientId()) {
            return searchRec(node.left, patientId);
        } else {
            return searchRec(node.right, patientId);
        }
    }

    // ---------- DELETE ----------
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private PatientNode deleteRec(PatientNode node, int patientId) {
        if (node == null) {
            System.out.println("Patient with ID " + patientId + " not found. Nothing deleted.");
            return null;
        }

        if (patientId < node.data.getPatientId()) {
            node.left = deleteRec(node.left, patientId);
        } else if (patientId > node.data.getPatientId()) {
            node.right = deleteRec(node.right, patientId);
        } else {
            // Found the node to delete

            // Case 1: no children
            if (node.left == null && node.right == null) {
                return null;
            }
            // Case 2: one child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // Case 3: two children -> replace with smallest value in right subtree
            Patient smallestInRight = findMin(node.right);
            node.data = smallestInRight;
            node.right = deleteRec(node.right, smallestInRight.getPatientId());
        }
        return node;
    }

    private Patient findMin(PatientNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // ---------- IN-ORDER TRAVERSAL (ascending order by ID) ----------
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients in the system.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(PatientNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
}
