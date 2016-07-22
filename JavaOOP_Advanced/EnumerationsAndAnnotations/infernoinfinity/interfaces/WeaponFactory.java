package infernoinfinity.interfaces;

import infernoinfinity.enums.WeaponType;

public interface WeaponFactory {

    Weapon createWeapon(String weaponName,WeaponType weaponType);

}
