
import Model.*;
import Model.AppointmentStatus;
import Model.Physiotherapist;
import Role.PatientConsole;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PatientConsoleTest {

    private static PatientConsole patientConsole;
    private Model.Patient patient;
    @Test
    public void testAddPatient() {
        // Creating a patient object
        Patient patient = new Patient();

        // Setting dummy data using setter methods
        patient.setID(1234);
        patient.setFull_name("John Doe");
        patient.setAddress("Madison Avenue Apartment");
        patient.setNumber("9843242332");

        // Asserting the getters return the expected values
        assertEquals(1234, patient.getID());
        assertEquals("John Doe", patient.getFull_name());
        assertEquals("Madison Avenue Apartment", patient.getAddress());
        assertEquals("9843242332", patient.getNumber());

        // Optionally printing out to see data in test console
        System.out.println("Patient Added Successfully: ");
        System.out.println("Patient Info: ");
        System.out.println("ID: " + patient.getID());
        System.out.println("Name: " + patient.getFull_name());
        System.out.println("Address: " + patient.getAddress());
        System.out.println("Phone Number: " + patient.getNumber());
    }
    @Test
    public void testLoginPatient() {
        Patient patient = new Patient();

        // Setting dummy data using setter methods
        patient.setID(1234);
        patient.setFull_name("John Doe");

        if (patient.getID() == 1234) {
            System.out.println("Patient Login Successful");
        }

    }
    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment(1, "Dr. Smith", "Test Clinic", "Test Treatment", "10:00 AM", patient, AppointmentStatus.BOOKED);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);

        System.out.println("Appointment Added Successfully Info: " + appointment.toString());
        // Check if the appointment was added
        assertTrue("Appointment should be added.", !appointments.isEmpty());
    }

    @Test
    public void testViewAppointments() {
        // Set up some mock appointments
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, "Dr. Smith", "Test Clinic", "Test Treatment", "10:00 AM", patient, AppointmentStatus.BOOKED));

        System.out.println("Appointment List: "+appointments);
    }

    @Test
    public void testCancelAppointment() {
        // Set up some mock appointments
        List<Appointment> appointments = new ArrayList<>();
        Appointment mockAppointment = new Appointment(1, "Dr. Smith", "Test Clinic", "Test Treatment", "10:00 AM", patient, AppointmentStatus.BOOKED);
        if (mockAppointment.getAppointmentId() == 1){
            assertEquals(String.valueOf(AppointmentStatus.CANCELLED), mockAppointment.getStatus(), "The appointment should be cancelled.");

        }

        // Assert that the appointment's status has been changed to CANCELLED
    }





    // Add more tests as needed
}
