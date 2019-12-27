package cz.fit.dpo.mvcshooter.model;

import AbstractFactory.IModel;
import memento.MementoCrate;
import memento.Memento;
import clone.ObjectCloner;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.shootingmode.DoubleShootingMode;
import cz.fit.dpo.mvcshooter.model.shootingmode.SingleShootingMode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 *
 *     The simple model contains basic game mode where canon shoots missiles in straight direction.
 */
public class ModelSimple implements IModel {
    private Timer timer;
    private final ModelInfo modelInfo;
    private ModelObserver viewObserver;

    private Cannon cannon;
    private List<Missile> missiles;
    private List<Enemy> enemies;
    private List<Collision> collisions;
    private final int gravity = 0;
    private int score;


    public ModelSimple() {
        cannon = new Cannon();
        missiles = new ArrayList<Missile>();
        enemies = new ArrayList<Enemy>();
        collisions = new ArrayList<Collision>();
        score = 0;
        modelInfo = new ModelInfo(
                ModelConfig.CANNON_DEFAULT_FORCE,
                ModelConfig.CANNON_DEFAULT_ANGLE,
                gravity,
                score,
                cannon.getShootingMode().toString()
        );

        generateFirstEnemies();
    }

    @Override
    public Cannon getCannon() {
        return cannon;
    }

    @Override
    public ModelInfo getModelInfo() {
        return modelInfo;
    }

    @Override
    public Iterable<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public Iterable<Missile> getMissiles() {
        return missiles;
    }

    @Override
    public Iterable<Collision> getCollisions() {
        return collisions;
    }

    @Override
    public int getPlaygroundWidth() {
        return ModelConfig.PLAYGROUND_WIDTH;
    }

    @Override
    public int getPlaygroundHeight() {
        return ModelConfig.PLAYGROUND_HEIGHT;
    }

    @Override
    public void changeShootingMode() {
        if (cannon.getShootingMode() instanceof SingleShootingMode) {
            cannon.setShootingMode(new DoubleShootingMode(cannon));
        } else {
            cannon.setShootingMode(new SingleShootingMode(cannon));
        }
        modelInfo.shootingMode = cannon.getShootingMode().toString();
        notifyObserver();
    }

    public void changeShootStrategy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Observable
    @Override
    public void registerObserver(ModelObserver observer) {
        viewObserver = observer;
        initTimer();
    }

    @Override
    public void notifyObserver() {
        viewObserver.modelUpdated();
    }


    //Facade
    @Override
    public void moveCannonDown() {
        cannon.moveDown();
    }

    @Override
    public void moveCannonUp() {
        cannon.moveUp();
    }

    @Override
    public void forceOfCannonDown() {
        cannon.forceDown();
        updateModelInfo();
    }

    @Override
    public void forceOfCannonUp() {
        cannon.forceUp();
        updateModelInfo();
    }

    @Override
    public void aimCannonUp() {
        cannon.aimUp();
        updateModelInfo();
    }

    @Override
    public void aimCannonDown() {
        cannon.aimDown();
        updateModelInfo();
    }

    @Override
    public void shootCannon() {
        missiles.addAll(cannon.shoot());
    }

    @Override
    public void increaseGravity() {
        System.out.println("Changing gravity is not supported in the simple mode.");
    }

    @Override
    public void decreaseGravity() {
        System.out.println("Changing gravity is not supported in the simple mode.");
    }


    // ############################### private initialization ###############################
    private void cancelTimer() {
        timer.cancel();
    }

    private void initTimer() {
        timer = new Timer();
        mainGameLoop();
        periodicallyAddEnemies();
    }

    private void mainGameLoop() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveObjects();
                discardGameObjects();
                notifyObserver();
            }
        }, 0, ModelConfig.TICK_TIME);
    }

    private void periodicallyAddEnemies() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                addRandomEnemy();
                //System.out.println("New enemy added!");
            }
        }, 0, ModelConfig.TICK_TIME * ModelConfig.ENEMY_RESPAWN_TIME);
    }


    // ################################## private logic ##################################

    private void moveObjects() {
        for (Iterator<Missile> m_it = missiles.iterator(); m_it.hasNext(); ) {
            Missile missile = m_it.next();
            missile.move(gravity);
            for (Iterator<Enemy> e_it = enemies.iterator(); e_it.hasNext(); ) {
                Enemy enemy = e_it.next();

                if (missile.collidesWith(enemy)) {
                    enemy.inflictDamage();
                    if (enemy.getLife() <= 0) {
                        increaseScoreByKillingEnemyOfType(enemy.getType());
                        collisions.add(new Collision(enemy.getX(), enemy.getY()));
                        e_it.remove();
                    }
                    m_it.remove();
                }
            }
        }
    }

    private void increaseScoreByKillingEnemyOfType(int type) {
        switch (type) {
            case 0:
                score += ModelConfig.HIT_POINTS;
                break;
            case 1:
                score += ModelConfig.HIT_POINTS * 2;
                break;
            default:
        }
        updateModelInfo();
    }

    private void generateFirstEnemies() {
        for (int i = 0; i < ModelConfig.ENEMIES_COUNT; i++) {
            addRandomEnemy();
        }
    }

    private void addRandomEnemy() {
        Random random = new Random();
        int x = random.nextInt(ModelConfig.ENEMY_X_MAX - ModelConfig.ENEMY_X_MIN) + ModelConfig.ENEMY_X_MIN;
        int y = random.nextInt(ModelConfig.ENEMY_Y_MAX - ModelConfig.ENEMY_Y_MIN) + ModelConfig.ENEMY_Y_MIN;
        enemies.add(new Enemy(x, y));
    }

    private void discardGameObjects() {

        for (Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext(); ) {
            Enemy e = iterator.next();
            if (e.shouldBeDiscarted()) {
                iterator.remove();
            }
        }

        for (Iterator<Collision> iterator = collisions.iterator(); iterator.hasNext(); ) {
            Collision c = iterator.next();
            if (c.shouldBeDiscarted()) {
                iterator.remove();
            }
        }

        for (Iterator<Missile> iterator = missiles.iterator(); iterator.hasNext(); ) {
            Missile m = iterator.next();
            if (m.shouldBeDiscarted()) {
                iterator.remove();
            }
        }
    }

    private void updateModelInfo() {
        modelInfo.cannonAngle = cannon.getAngle();
        modelInfo.cannonForce = cannon.getForce();
        modelInfo.gravity = gravity;
        modelInfo.score = score;
        modelInfo.shootingMode = cannon.getShootingMode().toString();
    }

    // ############################## Memento ###############################š

    @Override
    public Memento save() throws Exception {
        System.out.println("Originator: Saving to Memento");
        cancelTimer();
        MementoCrate newMementoCrate = (MementoCrate) ObjectCloner.deepCopy(new MementoCrate(cannon, missiles, enemies, collisions, gravity, score));
        initTimer();
        return new Memento(newMementoCrate);
    }

    @Override
    public void load(final Memento m) {
        System.out.println("Originator: Load from memento");
        MementoCrate c = m.getMementoCrate();
        cannon = c.getCannon();
        enemies = c.getEnemies();
        missiles = c.getMissiles();
        collisions = c.getCollisions();
        score = c.getScore();
        updateModelInfo();
    }

}
