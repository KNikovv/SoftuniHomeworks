package petclinics;

import petclinics.interfaces.ClinicCommandDispatcher;
import petclinics.interfaces.ClinicDatabase;
import petclinics.models.ClinicDatabaseImpl;

public class ClinicCommandDispatcherImpl implements ClinicCommandDispatcher {

    private ClinicDatabase clinicDatabase;

    public ClinicCommandDispatcherImpl() {
        this.clinicDatabase = new ClinicDatabaseImpl();
    }

    @Override
    public void dispatch(String... args) {
        switch (args[0].toLowerCase()) {
            case "create":
                if (args[1].toLowerCase().equals("pet")) {
                    this.createPet(args[2], Integer.valueOf(args[3]), args[4]);
                    return;
                }
                this.createClinic(args[2], Integer.valueOf(args[3]));
                break;
            case "add":
                this.addPetToClinic(args[1], args[2]);
                break;
            case "release":
                this.release(args[1]);
                break;
            case "hasemptyrooms":
                this.hasEmptyRooms(args[1]);
                break;
            case "print":
                if (args.length == 2) {
                    this.getInfoForEachRoom(args[1]);
                    return;
                }
                this.getInfoForParticularRoom(args[1], Integer.valueOf(args[2]));
                break;
        }
    }

    @Override
    public void createPet(String name, Integer age, String kind) {
        this.clinicDatabase.addPet(name, age, kind);
    }

    @Override
    public void createClinic(String name, Integer roomCapacity) {
        this.clinicDatabase.addClinic(name, roomCapacity);
    }

    @Override
    public void addPetToClinic(String petName, String clinicName) {
        this.clinicDatabase.addPetToClinic(petName, clinicName);
        System.out.println(this.clinicDatabase.isAdded());
    }

    @Override
    public void release(String clinicName) {
        this.clinicDatabase.getAllClinics()
                .get(clinicName)
                .releasePet();
        System.out.println(this.clinicDatabase.getAllClinics().get(clinicName).hasReleased());
    }

    @Override
    public void hasEmptyRooms(String clinicName) {
        System.out.println(this.clinicDatabase
                .getAllClinics()
                .get(clinicName)
                .hasEmptyRooms());
    }

    @Override
    public void getInfoForEachRoom(String clinicName) {
        System.out.print(this.clinicDatabase
                .getAllClinics()
                .get(clinicName)
                .getAllRoomsInfo());
    }

    @Override
    public void getInfoForParticularRoom(String clinicName, Integer roomNumber) {
        System.out.println(this.clinicDatabase
                .getAllClinics()
                .get(clinicName)
                .getSpecificRoomInfo(roomNumber));
    }
}
