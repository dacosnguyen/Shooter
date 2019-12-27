
package cz.fit.dpo.mvcshooter.model.shootingmode;

import cz.fit.dpo.mvcshooter.model.entities.Missile;

import java.io.Serializable;
import java.util.List;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public interface ShootingMode extends Serializable {

    List<Missile> shoot();

}
