package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.shootingmode.ShootingMode;

/**
 *
 * @author Ondrej Stuchlik
 */
public class ModelInfo {
    public int cannonForce;
    public int cannonAngle;
    public int gravity;
    public int score;
    public String shootingMode;

    
    public ModelInfo() {
    }
    

    public ModelInfo(int cannonForce, int cannonAngle, int gravity, int score, String shootingMode) {
        this.cannonForce = cannonForce;
        this.cannonAngle = cannonAngle;
        this.gravity = gravity;
        this.score = score;
        this.shootingMode = shootingMode;
    }
    
    
    
    
}
