package Model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private  int ID;
    private String full_name;
    private String address;
    private String number;
    private List<Doctor> doctors;
    private List<Physiotherapist> physiotherapists;
    private TreatmentHistory treatmentHistory;

    public Patient(int i, String testPatient, String mail, String number, String male, String address) {
    }

    public Patient(int id, String name, String email) {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + ID +
                ", full_name='" + full_name + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", doctors=" + doctors +
                ", physiotherapists=" + physiotherapists +
                ", treatmentHistory=" + treatmentHistory +
                ", randomNum=" + randomNum +
                '}';
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public TreatmentHistory getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(TreatmentHistory treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public Patient(int ID, String full_name, String address, String number) {
        this.ID = ID;
        this.full_name = full_name;
        this.address = address;
        this.number = number;
        this.doctors = new ArrayList<>();
        this.physiotherapists = new ArrayList<>();
        this.treatmentHistory = new TreatmentHistory();
        this.randomNum = randomNum;
    }

    int randomNum = (int)(Math.random() * 101);
    public Patient(String full_name, String address, String number) {
        this.ID = randomNum;
        this.full_name = full_name;
        this.address = address;
        this.number = number;
        this.physiotherapists = new ArrayList<>(); // Initialize the list as empty
    }

    public Patient() {

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Physiotherapist> getPhysiotherapists() {
        return physiotherapists;
    }

    public void setPhysiotherapists(List<Physiotherapist> physiotherapists) {
        this.physiotherapists = physiotherapists;
    }
    
}
