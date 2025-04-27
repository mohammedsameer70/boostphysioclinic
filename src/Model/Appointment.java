package Model;

import Role.PatientConsole;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private int patientID;
    private String doctorName;
    private String treatmentName;
    private String availability;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private boolean isBooked;
    private String appointmentTime;
    private boolean isAvailable;
    private boolean isCheckin;
    private AppointmentStatus status;



    public Appointment() {

    }

    public Appointment(String patientId, String doctorName, String clinicName, String treatmentName, String availibility, Patient patient, AppointmentStatus appointmentStatus) {
    }

    public Appointment(int id, String fullName, String doctorName, String healingHandsClinic, String treatmentName, String availibility, AppointmentStatus appointmentStatus) {
    }

    public Appointment(int i, String healingHandsClinic, String s, String physiotherapy, String available) {
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientID=" + patientID +
                ", clinicName='" + clinicName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", treatmentName='" + treatmentName + '\'' +
                ", availability='" + availability + '\'' +
                ", patient=" + patient +
                ", physiotherapist=" + physiotherapist +
                ", isBooked=" + isBooked +
                ", appointmentTime=" + appointmentTime +
                ", isAvailable=" + isAvailable +
                ", isCheckin=" + isCheckin +
                ", status=" + status +
                '}';
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }


    private String clinicName;


    public Appointment(int id, String clinicName, String doctorName, String treatmentName, String availability, Patient patient, AppointmentStatus status) {
        this.appointmentId = (int)(Math.random() * 9000) + 1000;  // Random number between 1000 and 9999
        this.clinicName = clinicName;
        this.doctorName = doctorName;
        this.treatmentName = treatmentName;
        this.availability = availability;
        this.patient = patient;
        this.isBooked = true;
        this.appointmentTime = String.valueOf(LocalDateTime.now());  // Current timestamp (if you want real time)
        this.isAvailable = false;
        this.isCheckin = false;
        this.status = status;
    }


    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public boolean isCheckin() {
        return isCheckin;
    }

    public void setCheckin(boolean checkin) {
        isCheckin = checkin;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    // Random ID generation
    private static int generateRandomId() {
        return (int) (Math.random() * 10000);  // Generates a random integer between 0 and 9999
    }

    // Method to book appointment
    public void bookAppointment() {
        this.isBooked = true;
    }

    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(Physiotherapist physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setPatient(PatientConsole patient) {
    }
}
