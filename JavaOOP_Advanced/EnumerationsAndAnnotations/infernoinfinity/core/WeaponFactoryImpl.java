package infernoinfinity.core;

import infernoinfinity.enums.WeaponType;
import infernoinfinity.interfaces.Weapon;
import infernoinfinity.interfaces.WeaponFactory;
import infernoinfinity.models.WeaponImpl;

import java.util.NoSuchElementException;

public class WeaponFactoryImpl implements WeaponFactory {

    @Override
    public Weapon createWeapon(String weaponName, WeaponType weaponType) {
        //switch case for more explicit creation of weapon
        switch (weaponType) {
            case AXE:
                return new WeaponImpl(weaponName, WeaponType.AXE);
            case SWORD:
                return new WeaponImpl(weaponName, WeaponType.SWORD);
            case KNIFE:
                return new WeaponImpl(weaponName, WeaponType.KNIFE);
            default:
                throw new NoSuchElementException();
        }
    }
}
