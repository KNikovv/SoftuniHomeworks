package app.console;

import app.entities.Doctor;
import app.entities.Visitation;
import app.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private DiagnoseService diagnoseService;
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitationService visitationService;
    @Autowired
    private DoctorService doctorService;

    @Override
    public void run(String... strings) throws Exception {
//        Patient patient = new Patient();
//        patient.setFirstName("Pesho");
//        patient.setBirthDate(new Date());
//
//        Set<Patient> pm = new HashSet<>();
//        pm.add(patient);
//        Medicament medicament = new Medicament();
//        medicament.setName("Aspirin");
//        medicament.setPatients(pm);
//
//        Diagnose diagnose = new Diagnose();
//        diagnose.setName("Hrema");
//        diagnose.setPatients(pm);
//
//        Visitation visitation = new Visitation();
//        visitation.setPatient(patient);
//        visitation.setDate(new Date());
//        visitation.setComments("hi");
//
//        this.patientService.create(patient);
//        this.diagnoseService.create(diagnose);
//        this.medicamentService.create(medicament);
//        this.visitationService.create(visitation);

        Doctor doctor = new Doctor("Pesho", "Surgeon");
        this.doctorService.create(doctor);
        Visitation visitation = new Visitation();
        visitation.setDate(new Date());
        visitation.setDoctor(doctor);
        doctor.getVisitations().add(visitation);

        this.visitationService.create(visitation);
    }
}
