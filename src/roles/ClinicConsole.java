package Role;

import Model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Role.PatientConsole.appointmentsList;

public class ClinicConsole {

    public static List<Physiotherapist> therapy = new ArrayList<>();
    public static Map<Integer, List<TreatmentHistory>> patientTreatmentMap = new HashMap<>();

    public static void viewDoctorMenu(List<Appointment> appointmentsList) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Boost Physio Clinic - Physiotherapist Menu");
            System.out.println("1. View My Schedule");
            System.out.println("2. Manage Appointments");
            System.out.println("3. Add Patient Treatment History");
            System.out.println("4. Generate Patient Report");
            System.out.println("5. Manage Treatment Timetable");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Viewing your schedule...");
                    System.out.print("Enter Physiotherapist's Name: ");
                    String physiotherapistName = sc.nextLine();
                    generateClinicReport(appointmentsList, physiotherapistName);
                    break;
                case 2:
                    manageAppointment(sc);
                    break;
                case 3:
                    addTreatmentHistory(sc);
                    break;
                case 4:
                    generateAppointmentList(appointmentsList);
                    break;
                case 5:
                    generateTimetable();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
        }
    }

    private static void generateClinicReport(List<Appointment> appointmentsList, String physiotherapistName) {
        boolean found = false;

        System.out.println("--- Clinic Report for " + physiotherapistName + " ---");
        for (Appointment appointment : appointmentsList) {
            if (appointment.getDoctorName().equalsIgnoreCase(physiotherapistName)) {
                found = true;
                System.out.println("Patient: " + appointment.getPatient().getFull_name());
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Treatment: " + appointment.getTreatmentName());
                System.out.println("Time: " + appointment.getAppointmentTime());
                System.out.println("Status: " + appointment.getStatus());
                System.out.println("----------------------------");
            }
        }

        if (!found) {
            System.out.println("No appointments found for Dr. " + physiotherapistName + ".");
        }
    }

    private static void generateTimetable() {
        Map<String, Integer> physiotherapistAttendance = new HashMap<>();
        System.out.println("Number of appointments: " + appointmentsList.size());

        for (Appointment appointment : appointmentsList) {
            if (appointment.getStatus() == AppointmentStatus.ATTENDED) {
                String physiotherapistName = appointment.getDoctorName();
                physiotherapistAttendance.put(physiotherapistName, physiotherapistAttendance.getOrDefault(physiotherapistName, 0) + 1);
            }
        }

        if (physiotherapistAttendance.isEmpty()) {
            System.out.println("No attended appointments found.");
            return;
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(physiotherapistAttendance.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("\nPhysiotherapists by Number of Attended Appointments:");
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " attended appointments");
        }
    }

    private static void generateAppointmentList(List<Appointment> appointmentsList) {
        if (appointmentsList.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        System.out.println("--- Appointment List ---");
        for (Appointment appointment : appointmentsList) {
            System.out.println("Appointment ID: " + appointment.getAppointmentId());
            System.out.println("Patient: " + appointment.getPatient().getFull_name());
            System.out.println("Patient Contact: " + appointment.getPatient().getNumber());
            System.out.println("Doctor: " + appointment.getDoctorName());
            System.out.println("Treatment: " + appointment.getTreatmentName());
            System.out.println("Appointment Date: " + appointment.getAppointmentTime());
            System.out.println("Status: " + appointment.getStatus());
            System.out.println("--------------------------");
        }
    }

    private static void viewAllTreatment(Scanner sc) {
        System.out.println("All Treatments done by Clinics:");
        int count = 1;
        for (Physiotherapist physio : therapy) {
            List<Treatment> treatments = physio.getTreatment();
            for (Treatment treatment : treatments) {
                System.out.println(count++ + ". " + treatment.getTreatmentName());
            }
        }
        System.out.println("\nPress Enter to exit...");
        sc.nextLine();
    }

    private static void addTreatmentHistory(Scanner sc) {
        System.out.println("\n--- Add Treatment History ---");
        System.out.print("Enter Appointment ID: ");
        int appointmentId = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (appointmentsList.isEmpty()) {
            System.out.println("No appointments available!");
            return;
        }

        Appointment appointment = null;
        for (Appointment app : appointmentsList) {
            if (app.getAppointmentId() == appointmentId) {
                appointment = app;
                break;
            }
        }

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return;
        }

        if (appointment.getPatient() == null) {
            System.out.println("No patient associated with this appointment.");
            return;
        }

        System.out.print("Enter Treatment Description: ");
        String description = sc.nextLine();

        TreatmentHistory history = new TreatmentHistory();
        history.setId(patientTreatmentMap.size() + 1); // Auto-increment ID
        history.setAppointment(appointment);
        history.setTreatmentDescription(description);
        history.setTreatmentDate(LocalDateTime.now());

        int patientId = appointment.getPatient().getID();
        patientTreatmentMap.putIfAbsent(patientId, new ArrayList<>());
        patientTreatmentMap.get(patientId).add(history);

        System.out.println("Treatment history recorded.");
    }


    private static void manageAppointment(Scanner sc) {
        System.out.println("\n--- Manage Appointment ---");
        System.out.print("Enter Appointment ID: ");
        int appointmentId = sc.nextInt();
        sc.nextLine(); // Consume newline

        Appointment appointment = null;
        for (Appointment app : appointmentsList) {
            if (app.getAppointmentId() == appointmentId) {
                appointment = app;
                break;
            }
        }

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return;
        }

        if (appointment.getPatient() == null) {
            System.out.println("No patient associated with this appointment.");
            return;
        }

        System.out.println("Manage Appointment for " + appointment.getPatient().getFull_name());
        System.out.println("Current Status: " + appointment.getStatus());
        System.out.print("Enter new status (ATTENDED, CANCELLED, RESCHEDULED): ");
        String status = sc.nextLine().toUpperCase();

        if (!isValidStatus(status)) {
            System.out.println("Invalid status entered. Please enter one of the following: ATTENDED, CANCELLED, RESCHEDULED.");
            return;
        }

        if (status.equals("RESCHEDULED")) {
            System.out.print("Enter new appointment date and time (yyyy-MM-ddTHH:mm): ");
            String newDateTime = sc.nextLine().trim();  // Trim to avoid leading/trailing spaces

            try {
                // Specify the expected format using DateTimeFormatter
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                LocalDateTime newSchedule = LocalDateTime.parse(newDateTime, formatter); // Use formatter here
                appointment.setAppointmentTime(newSchedule.toString());  // Convert to string format
                System.out.println("Appointment rescheduled to: " + newSchedule);
            } catch (Exception e) {
                System.out.println("Invalid date-time format. Please use format like 2025-04-28T15:00");
                return;
            }
        }

        appointment.setStatus(AppointmentStatus.valueOf(status));
        System.out.println("Appointment status updated to: " + status);
    }


    private static boolean isValidStatus(String status) {
        return status.equals("ATTENDED") || status.equals("CANCELLED") || status.equals("RESCHEDULED");
    }

}
