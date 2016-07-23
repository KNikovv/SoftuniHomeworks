package infernoinfinity.core;

import infernoinfinity.annotations.CustomInfo;
import infernoinfinity.enums.Gem;
import infernoinfinity.enums.WeaponType;
import infernoinfinity.interfaces.Weapon;
import infernoinfinity.interfaces.WeaponRepository;
import infernoinfinity.models.WeaponImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class WeaponRepositoryImpl implements WeaponRepository {

    private Map<String, Weapon> weapons;

    public WeaponRepositoryImpl() {
        this.weapons = new HashMap<>();
    }

    @Override
    public void createWeapon(WeaponType weaponType, String weaponName) {
        Weapon newWeapon = new WeaponImpl(weaponName, weaponType);
        this.weapons.put(weaponName, newWeapon);
    }

    @Override
    public void addGemToSocket(String weaponName, int socketIndex, Gem gemType) {
        this.weapons.get(weaponName).increaseStats(gemType, socketIndex);
    }

    @Override
    public void removeGemFromSocket(String weaponName, int socketIndex) {
        this.weapons.get(weaponName).decreaseStats(socketIndex);
    }

    @Override
    public String compareWeapons(String firstWeaponName, String secondWeaponName) {
        Weapon firstWeapon = this.weapons.get(firstWeaponName);
        Weapon secondWeapon = this.weapons.get(secondWeaponName);

        String greaterWeapon = firstWeapon.compareTo(secondWeapon) >= 0 ?
                this.getGreaterWeapon(firstWeapon) :
                this.getGreaterWeapon(secondWeapon);

        return greaterWeapon;
    }

    @Override
    public String getWeaponToPrint(String weaponName) {
        String weaponAsString = this.weapons.get(weaponName).toString();
        return weaponAsString;
    }

    @Override
    public String getAnnotationAsString(String annotationType) {
        CustomInfo annotation = getAnnotationToPrint();

        switch (annotationType) {
            case "Author":
                return this.getAuthor(annotationType, annotation);
            case "Revision":
                return this.getRevision(annotationType, annotation);
            case "Description":
                return this.getDescription(annotationType, annotation);
            case "Reviewers":
                return this.getReviewers(annotationType, annotation);
            default:
                throw new NoSuchElementException();
        }
    }

    private String getGreaterWeapon(Weapon weapon) {
        return (String.format("%s (Item Level: %.1f)",
                weapon.toString(),
                weapon.getItemLevel()));
    }

    private String getReviewers(String annotationType, CustomInfo annotation) {
        String reviewers = Arrays.toString(annotation.reviewers()).replaceAll("[\\[\\]]", "");
        return (String.format("%s: %s", annotationType, reviewers));
    }

    private String getDescription(String annotationType, CustomInfo annotation) {
        return (String.format("Class %s: %s",
                annotationType.toLowerCase(),
                annotation.description()));
    }

    private String getRevision(String annotationType, CustomInfo annotation) {
        return (String.format("%s: %s", annotationType, annotation.revision()));
    }

    private String getAuthor(String annotationType, CustomInfo annotation) {
        return (String.format("%s: %s", annotationType, annotation.author()));
    }

    private CustomInfo getAnnotationToPrint() {
        Class<WeaponImpl> weaponClass = WeaponImpl.class;
        return weaponClass.getAnnotation(CustomInfo.class);
    }

}
