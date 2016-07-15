package mood3.factory;

import mood3.interfaces.GameObjFactory;
import mood3.interfaces.GameObject;
import mood3.models.ArchangelImpl;
import mood3.models.DemonImpl;

public class GameObjFactoryImpl implements GameObjFactory {

    @Override
    public <P> GameObject getCharacter(String... params) {
        GameObject gameObject = null;
        String userName = params[0];
        String type = params[1];

        int level = Integer.valueOf(params[3]);
        switch (type) {
            case "Demon":
                Double doubleValue = Double.valueOf(params[2]);
                gameObject = new DemonImpl(userName, level, doubleValue);
                gameObject.setHashedPassword(gameObject.getUsername().length() * 217);
                break;
            case "Archangel":
                Integer intValue = Integer.valueOf(params[2]);
                gameObject = new ArchangelImpl(userName, level, intValue);
                StringBuilder userNameReverse = new StringBuilder(gameObject.getUsername()).reverse();
                gameObject.setHashedPassword(userNameReverse.toString() + gameObject.getUsername().length() * 21);

        }
        return gameObject;
    }
}