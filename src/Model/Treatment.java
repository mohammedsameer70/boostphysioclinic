package Model;

public class Treatment {
    private String treatmentName;

    public Treatment(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentName='" + treatmentName + '\'' +
                '}';
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }
}
