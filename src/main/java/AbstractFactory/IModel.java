package AbstractFactory;

import cz.fit.dpo.mvcshooter.model.ModelInfo;
import cz.fit.dpo.mvcshooter.model.ModelObservable;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import memento.Memento;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public interface IModel extends ModelObservable {

    int getPlaygroundWidth();

    int getPlaygroundHeight();

    void moveCannonDown();

    void moveCannonUp();

    void forceOfCannonDown();

    void forceOfCannonUp();

    void aimCannonUp();

    void aimCannonDown();

    void shootCannon();

    void increaseGravity();

    void decreaseGravity();

    void changeShootingMode();

    Memento save() throws Exception;

    void load(Memento loadMemento) throws InterruptedException;

    Cannon getCannon();

    Iterable<Missile> getMissiles();

    Iterable<Enemy> getEnemies();

    Iterable<Collision> getCollisions();

    ModelInfo getModelInfo();

}
