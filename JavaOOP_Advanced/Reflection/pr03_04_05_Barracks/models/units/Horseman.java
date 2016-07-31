package pr0304Barracks.models.units;


public class Horseman extends AbstractUnit {

    private static final int HORSEMAN_HEALTH = 50;
    private static final int ARCHER_DAMAGE = 10;

    protected Horseman() {
        super(HORSEMAN_HEALTH, ARCHER_DAMAGE);
    }
}
