package Model;

import java.util.ArrayList;
import java.util.List;

public class Physiotherapist {

    private int id;
    private List<Expertise> expertise;
    private String clinicName;
    private List<Doctor> drName;
    private String clinicAddress;
    private String clinicNumber;
    private List<Treatment> treatment;
    private List<Availability> availability;
    private List<Patient> patients;
    private List<Appointment> appointments;

    // Random ID generation (consider using a better method for production)
    private static int idCounter = 1;

    public Physiotherapist() {
        // Default constructor
    }

    // Constructor used during registration (without ID initially)
    public Physiotherapist(List<Expertise> expertise, String clinicName, List<Doctor> drName,
                           String clinicAddress, String clinicNumber, List<Treatment> treatment,
                           List<Availability> availability) {
        this.id = idCounter++; // Increment the ID for each new Physiotherapist
        this.expertise = expertise;
        this.clinicName = clinicName;
        this.drName = drName;
        this.clinicAddress = clinicAddress;
        this.clinicNumber = clinicNumber;
        this.treatment = treatment;
        this.availability = availability;
        this.patients = new ArrayList<>();  // Initialize patients list
        this.appointments = new ArrayList<>();  // Initialize appointments list
    }

    public Physiotherapist(int i, List<String> expertiseList, String wellHealthClinic, List<String> doctorList, String s, List<String> treatmentList, List<String> availabilityList, String s1) {
    }
    // Constructor used during registration (without ID initially)
    public Physiotherapist(int id, List<Expertise> expertise, String clinicName, List<Doctor> drName,
                           String clinicAddress, String clinicNumber, List<Treatment> treatment,
                           List<Availability> availability) {
        this.id = id;
        this.expertise = expertise;
        this.clinicName = clinicName;
        this.drName = drName;
        this.clinicAddress = clinicAddress;
        this.clinicNumber = clinicNumber;
        this.treatment = treatment;
        this.availability = availability;
        this.patients = new ArrayList<>();  // Initialize patients list
        this.appointments = new ArrayList<>();  // Initialize appointments list
    }

    @Override
    public String toString() {
        return "Physiotherapist{" +
                "id=" + id +
                ", expertise=" + expertise +
                ", clinicName='" + clinicName + '\'' +
                ", drName=" + drName +
                ", clinicAddress='" + clinicAddress + '\'' +
                ", clinicNumber='" + clinicNumber + '\'' +
                ", treatment=" + treatment +
                ", availability=" + availability +
                ", patients=" + patients +
                ", appointments=" + appointments +
                '}';
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Expertise> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<Expertise> expertise) {
        this.expertise = expertise;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public List<Doctor> getDrName() {
        return drName;
    }

    public void setDrName(List<Doctor> drName) {
        this.drName = drName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public String getClinicNumber() {
        return clinicNumber;
    }

    public void setClinicNumber(String clinicNumber) {
        this.clinicNumber = clinicNumber;
    }

    public List<Treatment> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Treatment> treatment) {
        this.treatment = treatment;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Setter for drName
    public void setDrName(String doctorName) {
        // Assuming you want to set a new doctor by name
        this.drName.add(new Doctor(doctorName));
    }
}
