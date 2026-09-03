package hospital;

// Represents a treatment record administered to a patient
public class Treatment {
    private int treatmentId;
    private int patientId;
    private String doctorName;
    private String treatmentDetails;
    private String timestamp;

    public Treatment(int treatmentId, int patientId, String doctorName, String treatmentDetails, String timestamp) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.treatmentDetails = treatmentDetails;
        this.timestamp = timestamp;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId +
               " | Patient ID: " + patientId +
               " | Doctor: " + doctorName +
               " | Action: " + treatmentDetails +
               " | Date/Time: " + timestamp;
    }
}
