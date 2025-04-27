import Model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ClinicConsoleTest {

    private List<Appointment> appointmentsList = new ArrayList<>();
    private List<TreatmentHistory> treatmentHistoryList = new ArrayList<>();
    private List<Physiotherapist> physiotherapistsList = new ArrayList<>();
    private Patient testPatient = new Patient();
    private Appointment testAppointment = new Appointment();

    @Test
    public void addClinicTest() {
        // Clinic and physiotherapist details
        List<String> expertiseList = new ArrayList<>(Arrays.asList(
                "Physiotherapy", "Osteopathy", "Rehabilitation"
        ));

        List<String> doctorList = new ArrayList<>(Arrays.asList(
                "Dr Nigel Smith", "Dr Priya Patel", "Dr Ayesha Khan"
        ));

        List<String> treatmentList = new ArrayList<>(Arrays.asList(
                "Neural mobilisation", "Acupuncture", "Massage",
                "Mobilisation of the spine and joints", "Pool rehabilitation"
        ));

        List<String> availabilityList = Arrays.asList(
                "Monday 9AM - 12PM",
                "Monday 2PM - 5PM",
                "Tuesday 10AM - 2PM",
                "Wednesday 9AM - 1PM",
                "Thursday 8AM - 11AM",
                "Friday 10AM - 3PM",
                "Saturday 9AM - 12PM",
                "Sunday Closed"
        );

        // Creating physiotherapist
        Physiotherapist physiotherapist = new Physiotherapist(
                1, expertiseList, "Well Health Clinic", doctorList,
                "Avenue Street 108, Broad Road, New York",
                treatmentList, availabilityList, "+2432423432"
        );
        physiotherapistsList.add(physiotherapist);

        System.out.println("Clinic Details Added Successfully");
    }

    @Test
    public void viewTreatmentScheduleTest() {
        // Create dummy appointment and patient
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(21);
        appointment.setPatientID(1);
        appointment.setDoctorName("Dr Priya Patel");
        appointment.setAvailability("Monday 9AM - 12PM");

        // Setting dummy data for the patient
        Patient patient = new Patient(1,"John Doe","221B Baker Street, London, NW1 6XE, United Kingdom", "+93278222");
        appointment.setPatient(patient);
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setCheckin(true);
        appointment.setTreatmentName("Acupuncture");
        appointment.setClinicName("Well Health Clinic");
        appointmentsList.add(appointment);

        System.out.println("Patient Details Schedule: " + appointment);
    }

    @Test
    public void generateAppointmentReview() {
        List<String> reviewList = new ArrayList<>();  // List to store the generated reviews

        // Debugging: Check if appointmentsList is empty or not
        System.out.println("Appointments list size: " + appointmentsList.size());
        if (appointmentsList.isEmpty()) {
            System.out.println("No appointments to review.");
        }

        // Iterate through the appointments list
        for (Appointment appointment : appointmentsList) {
            // Only generate reviews for booked appointments (optional condition)
            if (appointment.isBooked()) {
                // Constructing the review for each appointment
                StringBuilder review = new StringBuilder();

                // Patient details
                review.append("Patient Details:\n");
                review.append("Name: ").append(appointment.getPatient().getFull_name()).append("\n");
                review.append("Address: ").append(appointment.getPatient().getAddress()).append("\n");
                review.append("Contact Number: ").append(appointment.getPatient().getNumber()).append("\n\n");

                // Appointment details
                review.append("Appointment Details:\n");
                review.append("Doctor: ").append(appointment.getDoctorName()).append("\n");
                review.append("Treatment: ").append(appointment.getTreatmentName()).append("\n");
                review.append("Clinic: ").append(appointment.getClinicName()).append("\n");
                review.append("Availability: ").append(appointment.getAvailability()).append("\n");

                // Add the generated review to the reviewList
                reviewList.add(review.toString());
            }
        }

        // Print all the reviews after the loop
        System.out.println("Generated Appointment Reviews:");
        if (reviewList.isEmpty()) {
            System.out.println("No reviews generated.");
        } else {
            for (String generatedReview : reviewList) {
                System.out.println(generatedReview);
            }
        }

        // For debugging purposes, you can also print the size of the list
        System.out.println("Total Reviews Generated: " + reviewList.size());
    }
    @Test
    public void addTreatmentHistoryTest() {
        TreatmentHistory treatmentHistory = new TreatmentHistory();
        // Set a specific appointment if necessary (not a list)
        treatmentHistory.setTreatmentDate(LocalDateTime.now());
        treatmentHistory.setId(12);
        treatmentHistory.setTreatmentDescription("Prescribed Treatment for 3 Weeks, need to check up after 3 weeks for further treatments.");
        treatmentHistoryList.add(treatmentHistory);
        System.out.println("Treatment Prescribed to patient: " + treatmentHistory);
    }


}
