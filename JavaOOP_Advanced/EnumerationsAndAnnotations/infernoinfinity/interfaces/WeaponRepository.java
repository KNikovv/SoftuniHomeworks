package infernoinfinity.interfaces;

import infernoinfinity.enums.Gem;
import infernoinfinity.enums.WeaponType;

public interface WeaponRepository {

    void createWeapon(WeaponType weaponType, String weaponName);

    void addGemToSocket(String weaponName, int socketIndex, Gem gemType);

    void removeGemFromSocket(String weaponName, int socketIndex);

    String compareWeapons(String firstWeaponName, String secondWeaponName);

    String getAnnotationAsString(String annotationType);

    String getWeaponToPrint(String weaponName);
}
