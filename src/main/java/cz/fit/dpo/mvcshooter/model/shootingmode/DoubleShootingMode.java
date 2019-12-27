
package cz.fit.dpo.mvcshooter.model.shootingmode;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class DoubleShootingMode implements ShootingMode {

    private Cannon cannon;

    public DoubleShootingMode(Cannon cannon) {
        this.cannon = cannon;
    }

    @Override
    public List<Missile> shoot() {
        List<Missile> missiles = new ArrayList<Missile>();
        missiles.add(new Missile(cannon.getX(), cannon.getY(), cannon.getForce(), cannon.getAngle()));
        missiles.add(new Missile(cannon.getX(), cannon.getY(), cannon.getForce(), cannon.getAngle() + ModelConfig.CANNON_DOUBLE_SHOOTING_MODE_DISPERSION));
        return missiles;
    }

    @Override
    public String toString() {
        return "Double shooting mode";
    }
}
