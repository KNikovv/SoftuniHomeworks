package infernoinfinity.core;

import infernoinfinity.annotations.CustomInfo;
import infernoinfinity.enums.Gem;
import infernoinfinity.enums.WeaponType;
import infernoinfinity.interfaces.Weapon;
import infernoinfinity.interfaces.WeaponRepository;
import infernoinfinity.interfaces.Writer;
import infernoinfinity.io.ConsoleWriter;
import infernoinfinity.models.WeaponImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class WeaponRepositoryImpl implements WeaponRepository {

    private Map<String, Weapon> weapons;
    private Writer writer;

    public WeaponRepositoryImpl() {
        this.weapons = new HashMap<>();
        this.writer = new ConsoleWriter();
    }

    @Override
    public void createWeapon(WeaponType weaponType, String weaponName) {
        Weapon newWeapon = new WeaponImpl(weaponName,weaponType);
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
    public void compareWeapons(String firstWeaponName, String secondWeaponName) {
        Weapon firstWeapon = this.weapons.get(firstWeaponName);
        Weapon secondWeapon = this.weapons.get(secondWeaponName);

        if (firstWeapon.compareTo(secondWeapon) >= 0) {
            this.printGreaterWeapon(firstWeapon);
            return;
        }

        this.printGreaterWeapon(secondWeapon);
    }

    @Override
    public void print(String weaponName) {
        Weapon weaponToPrint = this.weapons.get(weaponName);
        this.writer.writeLine(weaponToPrint.toString());
    }

    public void printAnnotation(String annotationType) {
        CustomInfo annotation = getAnnotationToPrint();

        switch (annotationType) {
            case "Author":
                printAuthorAnnotation(annotationType, annotation);
                break;
            case "Revision":
                printRevisionAnnotation(annotationType, annotation);
                break;
            case "Description":
                printDescriptionAnnotation(annotationType, annotation);
                break;
            case "Reviewers":
                printReviewersAnnotation(annotationType, annotation);
                break;
            default:
                throw new NoSuchElementException();
        }
    }

    private void printGreaterWeapon(Weapon weapon) {
        this.writer.writeLine(String.format("%s (Item Level: %.1f)",
                weapon.toString(),
                weapon.getItemLevel()));
    }

    private void printReviewersAnnotation(String annotationType, CustomInfo annotation) {
        String reviewers = Arrays.toString(annotation.reviewers()).replaceAll("[\\[\\]]", "");
        this.writer.writeLine(String.format("%s: %s", annotationType, reviewers));
    }

    private void printDescriptionAnnotation(String annotationType, CustomInfo annotation) {
        this.writer.writeLine(String.format("Class %s: %s",
                annotationType.toLowerCase(),
                annotation.description()));
    }

    private void printRevisionAnnotation(String annotationType, CustomInfo annotation) {
        this.writer.writeLine(String.format("%s: %s", annotationType, annotation.revision()));
    }

    private void printAuthorAnnotation(String annotationType, CustomInfo annotation) {
        this.writer.writeLine(String.format("%s: %s", annotationType, annotation.author()));
    }

    private CustomInfo getAnnotationToPrint() {
        Class<WeaponImpl> weaponClass = WeaponImpl.class;
        return weaponClass.getAnnotation(CustomInfo.class);
    }

}
