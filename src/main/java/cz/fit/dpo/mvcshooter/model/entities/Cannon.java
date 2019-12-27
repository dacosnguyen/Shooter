package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.view.GameObjectVisitor;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.shootingmode.ShootingMode;
import cz.fit.dpo.mvcshooter.model.shootingmode.SingleShootingMode;
import cz.fit.dpo.mvcshooter.view.GraphicsDrawer;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon extends GameObject implements ShootingMode{
    
    private int angle = ModelConfig.CANNON_DEFAULT_ANGLE;
    private int force = ModelConfig.CANNON_DEFAULT_FORCE;
    private ShootingMode shootingMode;
    
    public Cannon() {
        super(ModelConfig.CANNON_X, ModelConfig.CANNON_DEFAULT_Y);
        shootingMode = new SingleShootingMode(this);
    }
    
    public void setShootingMode(final ShootingMode shootingMode) {
        this.shootingMode = shootingMode;
    }
    
    public ShootingMode getShootingMode() {
        return shootingMode;
    }
    
    @Override
    public List<Missile> shoot() {
        return shootingMode.shoot();
    }
    
    public int getForce() {
        return force;
    }

    public int getAngle() {
        return angle;
    }
    
    public void moveUp() {
        if (y >= ModelConfig.CANNON_TOP_MARGIN) {
            y -= ModelConfig.CANNON_MOVE_STEP;
        }
    }
    
    public void moveDown() {
        if (y <= ModelConfig.PLAYGROUND_HEIGHT - ModelConfig.CANNON_BOTTOM_MARGIN) {
            y +=  ModelConfig.CANNON_MOVE_STEP;
        }
    }
    
    public void aimUp() {
        if (angle < ModelConfig.CANNON_MAX_UP_ANGLE) {
            angle += ModelConfig.CANNON_AIM_STEP;
        }
    }
    
    public void aimDown() {
        if (angle > ModelConfig.CANNON_MAX_DOWN_ANGLE) {
            angle -= ModelConfig.CANNON_AIM_STEP;
        }
    }
    
    public void forceUp() {
        if (force < ModelConfig.CANNON_MAX_FORCE) {
            force += ModelConfig.CANNON_FORCE_STEP;
        }
    }
    
    public void forceDown() {
        if (force > ModelConfig.CANNON_MIN_FORCE) {
            force -= ModelConfig.CANNON_FORCE_STEP;
        }
    }

    @Override
    public void accept(Graphics g, GameObjectVisitor visitor) {
        visitor.visit(g, this);
    }

}
