package infernoinfinity.interfaces;

import infernoinfinity.enums.WeaponType;

public interface WeaponFactory {

    Weapon forgeWeapon(String weaponName, WeaponType weaponType);

}
