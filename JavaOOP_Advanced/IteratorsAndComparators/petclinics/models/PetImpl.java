package petclinics.models;

import petclinics.interfaces.Pet;

public class PetImpl implements Pet {

    private String petName;
    private Integer petAge;
    private String petKind;

    public PetImpl(String petName, Integer petAge, String petKind) {
        this.setPetAge(petAge);
        this.setPetName(petName);
        this.setPetKind(petKind);
    }

    @Override
    public String getPetName() {
        return this.petName;
    }

    @Override
    public Integer getPetAge() {
        return this.petAge;
    }

    @Override
    public String getPetKind() {
        return this.petKind;
    }

    private void setPetName(String petName) {
        this.petName = petName;
    }

    private void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    private void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.getPetName(), this.getPetAge(), this.getPetKind());
    }
}
