class MedicalStaff {
    String name;

    public MedicalStaff(String name) {
        this.name = name;
    }

    public void scheduleShift() {
        System.out.println(name + ": Shift scheduled");
    }

    public void accessIDCard() {
        System.out.println(name + ": ID card access granted");
    }

    public void processPayroll() {
        System.out.println(name + ": Payroll processed");
    }
}

class Doctor extends MedicalStaff {
    public Doctor(String name) {
        super(name);
    }

    public void diagnose() {
        System.out.println(name + ": Diagnosing patient");
    }

    public void prescribe() {
        System.out.println(name + ": Prescribing medicine");
    }

    public void performSurgery() {
        System.out.println(name + ": Performing surgery");
    }
}

class Nurse extends MedicalStaff {
    public Nurse(String name) {
        super(name);
    }

    public void administerMedicine() {
        System.out.println(name + ": Administering medicine");
    }

    public void monitorPatient() {
        System.out.println(name + ": Monitoring patient");
    }

    public void assistProcedure() {
        System.out.println(name + ": Assisting procedure");
    }
}

public class HW4_HospitalManagementSystem {
    public static void main(String[] args) {
        MedicalStaff m = new Doctor("Dr. Smith");
        m.scheduleShift();
        m.accessIDCard();
        m.processPayroll();
    }
}
