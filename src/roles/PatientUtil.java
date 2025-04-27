package Role;

import Model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientUtil {
    public static List<Patient> patientList = new ArrayList<>();

    public static List<Model.Patient> getPatientList() {
        return patientList;
    }
}
