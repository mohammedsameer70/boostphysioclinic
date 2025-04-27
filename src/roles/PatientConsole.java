package Role;

import Model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static Role.PatientUtil.patientList;

public class PatientConsole {
    public static List<Physiotherapist> therapy = new ArrayList<>();

    public static List<Model.Patient> patient = PatientUtil.getPatientList();
    public static List<Appointment> appointmentsList = new ArrayList<>();

    public PatientConsole(int patientId) {
    }

    public PatientConsole() {

    }
    public static void patientList(){
        Appointment[] appointments = new Appointment[15];

        // Clinic names array
        String[] clinicName = {"Healing Hands Clinic", "Wellness Care Center", "Vitality Therapy Hub", "PhysioPro Clinic", "Revive Therapy Centre"};

        // Creating appointments with random clinic names, random patient IDs, and other details
        Random rand = new Random();

        appointments[0] = new Appointment(1, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Physiotherapy", "Monday 9AM - 12PM", new Patient(rand.nextInt(10000), "Patient 1", "+919876543210", "patient1@example.com"), AppointmentStatus.BOOKED);
        appointments[1] = new Appointment(2, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Acupuncture", "Tuesday 10AM - 2PM", new Patient(rand.nextInt(10000), "Patient 2", "+919876543211", "patient2@example.com"), AppointmentStatus.CANCELLED);
        appointments[2] = new Appointment(3, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Rehabilitation", "Monday 9AM - 12PM", new Patient(rand.nextInt(10000), "Patient 3", "+919876543212", "patient3@example.com"), AppointmentStatus.ATTENDED);
        appointments[3] = new Appointment(4, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Massage", "Wednesday 11AM - 1PM", new Patient(rand.nextInt(10000), "Patient 4", "+919876543213", "patient4@example.com"), AppointmentStatus.BOOKED);
        appointments[4] = new Appointment(5, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Physiotherapy", "Thursday 1PM - 4PM", new Patient(rand.nextInt(10000), "Patient 5", "+919876543214", "patient5@example.com"), AppointmentStatus.CANCELLED);
        appointments[5] = new Appointment(6, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Acupuncture", "Tuesday 10AM - 2PM", new Patient(rand.nextInt(10000), "Patient 6", "+919876543215", "patient6@example.com"), AppointmentStatus.BOOKED);
        appointments[6] = new Appointment(7, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Rehabilitation", "Monday 9AM - 12PM", new Patient(rand.nextInt(10000), "Patient 7", "+919876543216", "patient7@example.com"), AppointmentStatus.ATTENDED);
        appointments[7] = new Appointment(8, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Massage", "Wednesday 11AM - 1PM", new Patient(rand.nextInt(10000), "Patient 8", "+919876543217", "patient8@example.com"), AppointmentStatus.BOOKED);
        appointments[8] = new Appointment(9, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Physiotherapy", "Thursday 1PM - 4PM", new Patient(rand.nextInt(10000), "Patient 9", "+919876543218", "patient9@example.com"), AppointmentStatus.CANCELLED);
        appointments[9] = new Appointment(10, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Acupuncture", "Tuesday 10AM - 2PM", new Patient(rand.nextInt(10000), "Patient 10", "+919876543219", "patient10@example.com"), AppointmentStatus.BOOKED);
        appointments[10] = new Appointment(11, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Rehabilitation", "Monday 9AM - 12PM", new Patient(rand.nextInt(10000), "Patient 11", "+919876543220", "patient11@example.com"), AppointmentStatus.CANCELLED);
        appointments[11] = new Appointment(12, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Massage", "Wednesday 11AM - 1PM", new Patient(rand.nextInt(10000), "Patient 12", "+919876543221", "patient12@example.com"), AppointmentStatus.ATTENDED);
        appointments[12] = new Appointment(13, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Physiotherapy", "Thursday 1PM - 4PM", new Patient(rand.nextInt(10000), "Patient 13", "+919876543222", "patient13@example.com"), AppointmentStatus.BOOKED);
        appointments[13] = new Appointment(14, clinicName[rand.nextInt(clinicName.length)], "Dr. Priya Patel", "Acupuncture", "Tuesday 10AM - 2PM", new Patient(rand.nextInt(10000), "Patient 14", "+919876543223", "patient14@example.com"), AppointmentStatus.ATTENDED);
        appointments[14] = new Appointment(15, clinicName[rand.nextInt(clinicName.length)], "Dr. Nigel Smith", "Rehabilitation", "Monday 9AM - 12PM", new Patient(rand.nextInt(10000), "Patient 15", "+919876543224", "patient15@example.com"), AppointmentStatus.BOOKED);

        // Create an appointments list and add appointments
        // Create an appointments list and add appointments
        appointmentsList.addAll(Arrays.asList(appointments));

    }
    public static void generateRandomPatients(int numPatients) {
        Random random = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah", "Isaac", "Jack", "Kylie", "Liam", "Mia", "Noah", "Olivia"};
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com"};

        for (int i = 0; i < numPatients; i++) {
            int id = random.nextInt(10000) + 1000;  // Random ID between 1000 and 10999
            String name = names[random.nextInt(names.length)] + " " + (char) (random.nextInt(26) + 'A');  // Random name with a random letter as last name
            String email = name.toLowerCase().replace(" ", "") + random.nextInt(100) + "@" + domains[random.nextInt(domains.length)];

            Patient patient = new Patient(id, name,  email);
            patientList.add(patient);  // Add the created patient to the list
        }
    }
    public static void InitialList(){
        // Create a few hardcoded physiotherapists
        therapy.add(new Physiotherapist(1212,
                Arrays.asList(new Expertise("Physiotherapy"), new Expertise("Rehabilitation")),
                "Well Health Clinic",
                Arrays.asList(new Doctor("Dr. Nigel Smith"), new Doctor("Dr. Priya Patel")),
                "123 Avenue St, City",
                "+2432423432",
                Arrays.asList(new Treatment("Acupuncture"), new Treatment("Massage")),
                Arrays.asList(new Availability("Monday 9AM - 12PM"), new Availability("Tuesday 10AM - 2PM"))
        ));

        therapy.add(new Physiotherapist(4,
                Arrays.asList(new Expertise("Chiropractic"), new Expertise("Sports Therapy")),
                "Better Health Center",
                Arrays.asList(new Doctor("Dr. Ayesha Khan")),
                "456 Oak Street, Town",
                "+9876543210",
                Arrays.asList(new Treatment("Spinal Manipulation"), new Treatment("Stretching")),
                Arrays.asList(new Availability("Monday 1PM - 5PM"), new Availability("Thursday 10AM - 2PM"))
        ));

        therapy.add(new Physiotherapist(34543,
                Arrays.asList(new Expertise("Osteopathy"), new Expertise("Pain Management")),
                "Pain Relief Clinic",
                Arrays.asList(new Doctor("Dr. Alex Hunter")),
                "789 Pine Road, Village",
                "+1234567890",
                Arrays.asList(new Treatment("Massage Therapy"), new Treatment("Posture Correction")),
                Arrays.asList(new Availability("Wednesday 9AM - 1PM"), new Availability("Friday 2PM - 6PM"))
        ));

        therapy.add(new Physiotherapist(54654,
                Arrays.asList(new Expertise("Sports Rehabilitation"), new Expertise("Joint Mobilization")),
                "Healing Touch Clinic",
                Arrays.asList(new Doctor("Dr. Daniel Lee")),
                "101 Maple Ave, Suburb",
                "+5678901234",
                Arrays.asList(new Treatment("Kinesiology"), new Treatment("Cold Therapy")),
                Arrays.asList(new Availability("Tuesday 11AM - 3PM"), new Availability("Saturday 9AM - 1PM"))
        ));
    }

    public static void addAppointment(Scanner in, Model.Patient currentPatient) {

        if (currentPatient == null) {
            System.out.println("❌ Error: currentPatient is null. Cannot proceed with booking.");
            return; // If currentPatient is null, exit the method.
        }

        while (true) {
            System.out.println("Choose your Physiotherapist:");
            for (int i = 0; i < therapy.size(); i++) {
                System.out.println((i + 1) + ". " + therapy.get(i).getClinicName());
            }
            System.out.println((therapy.size() + 1) + ". Back");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt() - 1;
            in.nextLine();

            if (choice == therapy.size()) {
                return; // Back option
            }

            if (choice < 0 || choice >= therapy.size()) {
                System.out.println("Invalid choice.");
                continue;
            }

            Physiotherapist selectedTherapist = therapy.get(choice);

            // Doctor selection
            List<Doctor> doctors = selectedTherapist.getDrName();
            System.out.println("Available Doctors:");
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println((i + 1) + ". " + doctors.get(i).getDoctorName());
            }

            System.out.print("Select Doctor: ");
            int doctorChoice = in.nextInt() - 1;
            in.nextLine();

            if (doctorChoice < 0 || doctorChoice >= doctors.size()) {
                System.out.println("Invalid doctor selection.");
                continue;
            }

            Doctor selectedDoctor = doctors.get(doctorChoice);

            // Treatment selection
            List<Treatment> treatments = selectedTherapist.getTreatment();
            System.out.println("Available Treatments:");
            for (int i = 0; i < treatments.size(); i++) {
                System.out.println((i + 1) + ". " + treatments.get(i).getTreatmentName());
            }

            System.out.print("Select Treatment: ");
            int treatmentChoice = in.nextInt() - 1;
            in.nextLine();

            if (treatmentChoice < 0 || treatmentChoice >= treatments.size()) {
                System.out.println("Invalid treatment selection.");
                continue;
            }

            Treatment selectedTreatment = treatments.get(treatmentChoice);

            // Time slot selection
            List<Availability> availabilities = selectedTherapist.getAvailability();
            System.out.println("Available Time Slots:");
            for (int i = 0; i < availabilities.size(); i++) {
                System.out.println((i + 1) + ". " + availabilities.get(i).getAvailibility());
            }

            System.out.print("Select Time Slot: ");
            int timeSlotChoice = in.nextInt() - 1;
            in.nextLine();

            if (timeSlotChoice < 0 || timeSlotChoice >= availabilities.size()) {
                System.out.println("Invalid time slot selection.");
                continue;
            }

            AppointmentStatus status = AppointmentStatus.BOOKED;
            Availability selectedTimeSlot = availabilities.get(timeSlotChoice);

            // Debug: Log current patient ID before proceeding
            System.out.println("Current Patient ID: " + currentPatient.getID());

            // Book the appointment
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(appointmentsList.size() + 1); // Assign ID manually

            appointment.setPatientID(currentPatient.getID());
            appointment.setDoctorName(selectedDoctor.getDoctorName());
            appointment.setClinicName(selectedTherapist.getClinicName());
            appointment.setTreatmentName(selectedTreatment.getTreatmentName());
            appointment.setAppointmentTime((selectedTimeSlot.getAvailibility()));
            appointment.setPatient(currentPatient);
            appointment.setStatus(status);

            System.out.println("Booking appointment for Patient ID: " + currentPatient.getID());
            System.out.println("Doctor: " + selectedDoctor.getDoctorName());
            System.out.println("Treatment: " + selectedTreatment.getTreatmentName());
            appointmentsList.add(appointment);
            appointment.bookAppointment();
            System.out.println("Appointment booked successfully with " + selectedDoctor.getDoctorName());
            break;
        }
    }



    public static void viewAppointments(Scanner sc) {
        // Print all appointments directly
        System.out.println("----------------------------------------------------");

        boolean found = false;
        for (int i = 0; i < appointmentsList.size(); i++) {
            Appointment appointment = appointmentsList.get(i);
            System.out.println((i + 1) +
                    ". ID: " + appointment.getAppointmentId() +
                    ", Doctor: " + appointment.getDoctorName() +
                    ", Clinic: " + appointment.getClinicName() +
                    ", Treatment: " + appointment.getTreatmentName() +
                    ", Time: " + appointment.getAvailability() +
                    ", Date: " + appointment.getAppointmentTime()
            );
            found = true;
        }

        if (!found) {
            System.out.println("No appointments found.");
        }

        System.out.println("----------------------------------------------------");
    }



    public static void patientScreen(Scanner in, int patientID) {
        Model.Patient currentPatient = null;

        // Find the logged-in patient
        for (Model.Patient p : patient) {
            if (p.getID() == patientID) {
                currentPatient = p;
                break;
            }
        }

        if (currentPatient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int choice = 0;
        while (choice != 9) {
            System.out.println("\nWelcome to Physiotherapist Therapy System! " +
                    currentPatient.getFull_name() + " | Your ID: " + currentPatient.getID());

            System.out.println("Select your options:");
            System.out.println("1. Book an Appointment");
            System.out.println("2. View My Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Search Physiotherapist by Name");
            System.out.println("5. Reschedule an Appointment");
            System.out.println("6. View Available Treatments");
            System.out.println("7. Mark Appointment as Attended (Check-in)");
            System.out.println("8. Search Physiotherapist by Treatment");
            System.out.println("9. Exit");

            choice = in.nextInt();
            in.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addAppointment(in, currentPatient);  // ✅ Pass the actual patient object
                    break;
                case 2:
                    viewAppointments(in);
                    break;
                case 3:
                    cancelAppointment(in);
                    break;
                case 4:
                    System.out.println("Enter Doctor Name");
                    String doctorName = in.nextLine();
                    boolean hasBookings = hasDoctorWithAppointments(doctorName);
                    System.out.println(hasBookings ? "This doctor has bookings." : "No bookings found.");
                    break;
                case 5:
                    rescheduleAppointment(in);
                    break;
                case 6:
                    viewAllTretment(in);
                    break;
                case 7:
                    System.out.println("Enter Appointment ID: ");
                    String idcheck = in.nextLine();
                    boolean hasCheckedin = CheckIn(idcheck);
                    System.out.println(hasCheckedin ? "This appointment has been booked." : "This appointment has not been booked.");
                    break;
                case 8:
                    SearchPhysiotherapistbyTreatment(in);
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void cancelAppointment(Scanner scanner) {
        System.out.print("Enter Appointment ID to cancel: ");
        int id = scanner.nextInt(); // read the actual int from Scanner

        for (Appointment appt : appointmentsList) {
            if (appt.getAppointmentId() == id) {
                appt.setStatus(AppointmentStatus.CANCELLED);
                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }
        System.out.println("Appointment ID not found.");
    }


    private static boolean CheckIn(String checkIn) {
        if (checkIn != null && !checkIn.trim().isEmpty()) {
            try {
                int appointmentId = Integer.parseInt(checkIn); // Convert string to int

                // Search for the appointment by appointmentId
                for (Appointment appointment : appointmentsList) {
                    if (appointment.getAppointmentId() == appointmentId) {
                        // If the appointment is already checked in
                        if (appointment.isCheckin()) {
                            // Appointment has already been checked in, we don't change the status here
                            System.out.println("You have already checked in for this appointment.");
                            return false;
                        }

                        // Set the appointment as checked in and change the status to ATTENDED
                        appointment.setCheckin(true);
                        appointment.setStatus(AppointmentStatus.ATTENDED); // Update status to ATTENDED

                        System.out.println("Check-in successful for appointment ID: " + appointmentId);
                        return true;
                    }
                }

                // Appointment ID not found
                System.out.println("Appointment ID not found.");
            } catch (NumberFormatException e) {
                // Handle invalid appointment ID format
                System.out.println("Invalid appointment ID format.");
            }
        } else {
            System.out.println("Appointment ID cannot be null or empty.");
        }
        return false;
    }


    public static void SearchPhysiotherapistbyTreatment(Scanner in) {
        if (therapy == null || therapy.isEmpty()) {
            System.out.println("No physiotherapists available.");
            return;
        }

        System.out.print("Enter treatment name to search: ");
        String desiredTreatment = in.nextLine();

        boolean found = false;
        for (Physiotherapist p : therapy) {
            if (p.getTreatment().stream().anyMatch(t -> t.getTreatmentName().equalsIgnoreCase(desiredTreatment))) {
                System.out.println("Physiotherapist: " + p.getDrName());
                System.out.println("Treatments: ");
                p.getTreatment().forEach(t -> System.out.println(" - " + t.getTreatmentName()));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No physiotherapist found for treatment: " + desiredTreatment);
        }
        System.out.println("\nPress Enter to exit...");
        in.nextLine();
    }

    private static void viewAllTretment(Scanner in) {
        System.out.println("All the Treatments done by Clinics");
        int count = 1;

        for (int i = 0; i < therapy.size(); i++) {
            List<Treatment> treatments = therapy.get(i).getTreatment();
            for (int j = 0; j < treatments.size(); j++) {
                System.out.println("------------------------------------");
                System.out.println(count++ + ". " + treatments.get(j).getTreatmentName());
            }
        }
        System.out.println("\nPress Enter to exit...");
        in.nextLine();
    }

    private static void rescheduleAppointment(Scanner in) {
        // Ask user for the Appointment ID they want to reschedule
        System.out.print("Enter the Appointment ID to reschedule: ");
        int appointmentId = in.nextInt();
        in.nextLine(); // Clear the buffer

        // Ask user for the new Appointment date and time
        System.out.print("Enter new appointment date (YYYY-MM-DD): ");
        String dateInput = in.nextLine();

        System.out.print("Enter new appointment time (HH:MM): ");
        String timeInput = in.nextLine();

        // Combine the date and time into a single string in the format "YYYY-MM-DDTHH:MM"
        String appointmentDateTimeString = dateInput + "T" + timeInput;

        // Find the appointment by ID
        Appointment appointmentToReschedule = null;
        for (Appointment appointment : appointmentsList) {
            if (appointment.getAppointmentId() == appointmentId) {
                appointmentToReschedule = appointment;
                break;
            }
        }

        if (appointmentToReschedule == null) {
            System.out.println("Appointment with the given ID not found.");
            return;
        }

        // Show current details
        System.out.println("Current Appointment Details:");
        System.out.println("Doctor: " + appointmentToReschedule.getDoctorName());

        // Check if the patient is null before calling getFull_name
        if (appointmentToReschedule.getPatient() != null) {
            System.out.println("Patient: " + appointmentToReschedule.getPatient().getFull_name());
        } else {
            System.out.println("Patient: No patient assigned to this appointment.");
        }

        System.out.println("Date and Time: " + appointmentToReschedule.getAppointmentTime());

        // Parse the new appointment date and time into a LocalDateTime object
        try {
            LocalDateTime newAppointmentTime = LocalDateTime.parse(appointmentDateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            // Update the appointment details
            appointmentToReschedule.setAppointmentTime(String.valueOf(newAppointmentTime));

            System.out.println("Appointment rescheduled successfully!");
            System.out.println("New Appointment Date and Time: " + newAppointmentTime);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date or time format. Please use the correct format (YYYY-MM-DD for date, HH:MM for time).");
        }
    }

    private static boolean hasDoctorWithAppointments(String doctorName) {
        for (Appointment appointment : appointmentsList) {
            if (appointment.getDoctorName() != null && appointment.getDoctorName().equalsIgnoreCase(doctorName)) {

                Physiotherapist physiotherapist = appointment.getPhysiotherapist();
                if (physiotherapist != null && physiotherapist.getAppointments() != null) {
                    for (Appointment physioAppointment : physiotherapist.getAppointments()) {
                        if (physioAppointment.getDoctorName() != null && physioAppointment.getDoctorName().equalsIgnoreCase(doctorName)) {
                            return true; // Found
                        }
                    }
                }
            }
        }
        return false;
    }


    // Method to search physiotherapist by name
    private static void searchPhysiotherapist(Scanner in) {
        System.out.print("Enter the name of the Doctor: ");
        String searchName = in.nextLine().toLowerCase(); // For case-insensitive search

        boolean found = false;

        for (Physiotherapist physiotherapist : therapy) {
            for (Doctor doctor : physiotherapist.getDrName()) {
                if (doctor.getDoctorName().equalsIgnoreCase(searchName)) {
                    found = true;
                    System.out.println("Found Physiotherapist: " + physiotherapist.getClinicName());
                    System.out.println("Address: " + physiotherapist.getClinicAddress());
                    System.out.println("Contact: " + physiotherapist.getClinicNumber());

                    System.out.println("Treatments Offered: ");
                    for (Treatment treatment : physiotherapist.getTreatment()) {
                        System.out.println("- " + treatment.getTreatmentName());
                    }

                    System.out.println("Available Time Slots: ");
                    for (Availability availability : physiotherapist.getAvailability()) {
                        System.out.println("- " + availability.getAvailibility());
                    }

                    System.out.println("Doctors Available: ");
                    for (Doctor doc : physiotherapist.getDrName()) {
                        System.out.println("- " + doc.getDoctorName());
                    }

                    System.out.println("----------------------------------------");
                    break; // No need to keep checking doctors in this physio
                }
            }
        }

        if (!found) {
            System.out.println("No Physiotherapist found with the given doctor name.");
        }
    }
    }






