package Model;

import java.time.LocalDateTime;

public class TreatmentHistory {
    private int id;
    private Appointment appointment;
    private String treatmentDescription;
    private LocalDateTime treatmentDate;
    int randomNum = (int)(Math.random() * 101);

    public TreatmentHistory(int id, Appointment appointment, String treatmentDescription, LocalDateTime treatmentDate) {
        this.id = randomNum;
        this.appointment = appointment;
        this.treatmentDescription = treatmentDescription;
        this.treatmentDate = treatmentDate;
    }

    public TreatmentHistory() {

    }

    @Override
    public String toString() {
        return "TreatmentHistory{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", treatmentDescription='" + treatmentDescription + '\'' +
                ", treatmentDate=" + treatmentDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public LocalDateTime getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDateTime treatmentDate) {
        this.treatmentDate = treatmentDate;
    }
}
