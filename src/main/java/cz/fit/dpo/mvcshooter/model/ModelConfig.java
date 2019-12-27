package cz.fit.dpo.mvcshooter.model;

/**
 *
 * @author Ondrej Stuchlik
 */
public class ModelConfig {
    public static final int PLAYGROUND_WIDTH = 800;
    public static final int PLAYGROUND_HEIGHT = 600;
    public static final int DEFAULT_GRAVITY = 5;
    public static final int GRAVITY_MAX = 50;
    public static final int GRAVITY_MIN = 0;
    public static final int GRAVITY_STEP = 1;
    public static final int TICK_TIME = 10;  //default 20   
    public static final int HIT_POINTS = 10;
    
    
    // ########### cannon ##########
    // cannon moves just vertically, therefore x doesn't change
    public static final int CANNON_X = 20;
    public static final int CANNON_DEFAULT_Y = PLAYGROUND_HEIGHT / 2;    
    public static final int CANNON_TOP_MARGIN = (int)(ModelConfig.PLAYGROUND_HEIGHT * 0.1);
    public static final int CANNON_BOTTOM_MARGIN = (int)(ModelConfig.PLAYGROUND_HEIGHT * 0.1);
    public static final int CANNON_MOVE_STEP = 10;
    
    public static final int CANNON_DEFAULT_ANGLE = 20;
    public static final int CANNON_MAX_UP_ANGLE = 80;
    public static final int CANNON_MAX_DOWN_ANGLE = -80;
    public static final int CANNON_AIM_STEP = 10;    
    
    public static final int CANNON_DEFAULT_FORCE = 50;
    public static final int CANNON_MAX_FORCE = 100;
    public static final int CANNON_MIN_FORCE = 1;
    public static final int CANNON_FORCE_STEP = 1;
    
    public static final int CANNON_SHOOTING_DELAY = 200*TICK_TIME;
    public static final int CANNON_DOUBLE_SHOOTING_MODE_DISPERSION = 9;
       
    
    // ########### missiles ##########
    
    // ########### enemies ##########
    public static final int ENEMY_LIVE_TIME = Integer.MAX_VALUE;
    public static final int ENEMY_RESPAWN_TIME = TICK_TIME*50;
    public static final int ENEMIES_COUNT = 3;
    //Left margin
    public static final int ENEMY_X_MIN = PLAYGROUND_WIDTH/3;
    public static final int ENEMY_X_MAX = PLAYGROUND_WIDTH-30;
    public static final int ENEMY_Y_MIN = 30;
    public static final int ENEMY_Y_MAX = PLAYGROUND_HEIGHT - ENEMY_Y_MIN;
    
    public static final int ENEMY_MOVE_STEP = 8;
    public static final int ENEMY_MOVE_DELAY = TICK_TIME*15;
    
    // ########### collisions ##########
    public static final int COLLISION_MARGIN = 20;
    public static final int COLLISION_LIVE_TIME = 500;
    
    
}
