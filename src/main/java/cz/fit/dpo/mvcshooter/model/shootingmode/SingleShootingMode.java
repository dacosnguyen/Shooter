
package cz.fit.dpo.mvcshooter.model.shootingmode;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class SingleShootingMode implements ShootingMode {

    private Cannon cannon;

    public SingleShootingMode(Cannon cannon) {
        this.cannon = cannon;
    }

    @Override
    public List<Missile> shoot() {
        List<Missile> missiles = new ArrayList<Missile>();
        missiles.add(new Missile(cannon.getX(), cannon.getY(), cannon.getForce(), cannon.getAngle()));
        return missiles;
    }

    @Override
    public String toString() {
        return "Single shooting mode";
    }

}
