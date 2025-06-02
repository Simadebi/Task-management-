import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Patient {
    private String patientId;
    private String name;
    private int age;
    private String address;
    private List<Treatment> treatments;

    public Patient(String patientId, String name, int age, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.treatments = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    public void viewTreatments() {
        System.out.println("Treatments for patient: " + name);
        for (Treatment t : treatments) {
            System.out.println(t);
        }
    }
}

class Staff {
    protected String staffId;
    protected String name;
    protected String position;

    public Staff(String staffId, String name, String position) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
    }
}

class Doctor extends Staff {
    private String specialty;

    public Doctor(String staffId, String name, String position, String specialty) {
        super(staffId, name, position);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Dr. " + name + " (" + specialty + ")";
    }
}

class Treatment {
    private String treatmentId;
    private String diagnosis;
    private Date date;
    private Doctor doctor;
    private List<Prescription> prescriptions;

    public Treatment(String treatmentId, String diagnosis, Date date, Doctor doctor) {
        this.treatmentId = treatmentId;
        this.diagnosis = diagnosis;
        this.date = date;
        this.doctor = doctor;
        this.prescriptions = new ArrayList<>();
    }

    public void addPrescription(Prescription p) {
        prescriptions.add(p);
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId +
               ", Diagnosis: " + diagnosis +
               ", Doctor: " + doctor +
               ", Date: " + date +
               ", Prescriptions: " + prescriptions;
    }
}

class Prescription {
    private String prescriptionId;
    private String medicine;
    private String dosage;

    public Prescription(String prescriptionId, String medicine, String dosage) {
        this.prescriptionId = prescriptionId;
        this.medicine = medicine;
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return medicine + " (" + dosage + ")";
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Doctor doc = new Doctor("S001", "Alice Smith", "Doctor", "Cardiology");

        Patient patient = new Patient("P001", "John Doe", 45, "456 Elm St");

        Treatment treatment = new Treatment("T001", "Heart Disease", new Date(), doc);
        treatment.addPrescription(new Prescription("PR001", "Aspirin", "100mg daily"));
        treatment.addPrescription(new Prescription("PR002", "Beta Blocker", "50mg twice daily"));

        patient.addTreatment(treatment);

        patient.viewTreatments();
    }
}