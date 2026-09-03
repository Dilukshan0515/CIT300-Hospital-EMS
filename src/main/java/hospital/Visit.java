package hospital;

// Represents a visit record for a patient
public class Visit {
    private int visitId;
    private int patientId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;

    public Visit(int visitId, int patientId, String visitDate, String doctorName, String diagnosis) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
    }

    public int getVisitId() {
        return visitId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Visit ID: " + visitId +
               " | Patient ID: " + patientId +
               " | Date: " + visitDate +
               " | Doctor: " + doctorName +
               " | Diagnosis: " + diagnosis;
    }
}
