import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] history, LocalDate birthDate, String bloodType) {
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies.clone();
        this.medicalHistory = history.clone();
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    public Patient(String name, String contact) {
        this.patientId = UUID.randomUUID().toString();
        this.medicalRecord = null;
        this.currentName = name;
        this.emergencyContact = contact;
    }

    public Patient(String id, MedicalRecord record, String name, String contact, String insurance, int room, String physician) {
        this.patientId = id;
        this.medicalRecord = record;
        this.currentName = name;
        this.emergencyContact = contact;
        this.insuranceInfo = insurance;
        this.roomNumber = room;
        this.attendingPhysician = physician;
    }

    String getBasicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber;
    }

    public String getPublicInfo() {
        return "Patient: " + currentName + ", Room: " + roomNumber;
    }
}

class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String license, String specialty, Set<String> certs) {
        this.licenseNumber = license;
        this.specialty = specialty;
        this.certifications = new HashSet<>(certs);
    }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String id, String shift, List<String> quals) {
        this.nurseId = id;
        this.shift = shift;
        this.qualifications = new ArrayList<>(quals);
    }
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String id, List<String> perms) {
        this.adminId = id;
        this.accessPermissions = new ArrayList<>(perms);
    }
}

public class HW1_HospitalManagement {
    private final Map<String, Object> patientRegistry = new HashMap<>();
    public static final String PRIVACY_POLICY = "Strict HIPAA Compliance";

    public boolean admitPatient(Object patient, Object staff) {
        if (validateStaffAccess(staff, patient)) {
            String id = UUID.randomUUID().toString();
            patientRegistry.put(id, patient);
            return true;
        }
        return false;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        return staff instanceof Doctor || staff instanceof Administrator;
    }

    public static void main(String[] args) {
        MedicalRecord record = new MedicalRecord("MR001", "DNA123", new String[]{"Penicillin"}, new String[]{"Asthma"}, LocalDate.of(1990, 5, 20), "O+");
        Patient p = new Patient("P001", record, "Nishchay", "9999999999", "HealthPlus", 101, "Dr. Rao");
        Doctor d = new Doctor("LIC123", "Cardiology", Set.of("BLS", "ACLS"));

        HW1_HospitalManagement system = new HW1_HospitalManagement();
        boolean admitted = system.admitPatient(p, d);
        System.out.println("Admission Status: " + admitted);
    }
}
