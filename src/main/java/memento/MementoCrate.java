package memento;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

import java.io.Serializable;
import java.util.List;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class MementoCrate implements Serializable {
    private final Cannon cannon;
    private final List<Missile> missiles;
    private final List<Enemy> enemies;
    private final List<Collision> collisions;
    private final int gravity;
    private final int score;

    public MementoCrate(Cannon cannon, List<Missile> missiles, List<Enemy> enemies, List<Collision> collisions, int gravity, int score) {
        this.cannon = cannon;
        this.missiles = missiles;
        this.enemies = enemies;
        this.collisions = collisions;
        this.gravity = gravity;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Collision> getCollisions() {
        return collisions;
    }

    public int getGravity() {
        return gravity;
    }


}
