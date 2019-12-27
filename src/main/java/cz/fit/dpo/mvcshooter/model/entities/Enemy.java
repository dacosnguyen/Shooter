package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.view.GameObjectVisitor;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Enemy extends GameObject {
    private static final Random random = new Random();
    
    private int type;
    private int life;

    public Enemy(int x, int y) {
        super(x, y);
        type = random.nextInt(2);
        life = type+1;
    }
    
    
    public boolean shouldBeDiscarted() {
        //return super.shouldBeDiscarted(ModelConfig.ENEMY_LIVE_TIME);
        if (life <= 0) {
            return true;
        } else 
            return false;
    }
    
    public void move() {
        Random rand = new Random();
        int tmpX = x + ((rand.nextInt(3)-1) * ModelConfig.ENEMY_MOVE_STEP);
        if ( tmpX > ModelConfig.ENEMY_X_MIN && tmpX < ModelConfig.ENEMY_X_MAX  ) {
            x = tmpX;
        }
        
        int tmpY = y + ((rand.nextInt(3)-1) * ModelConfig.ENEMY_MOVE_STEP);
        if ( tmpY > ModelConfig.ENEMY_Y_MIN && tmpY < ModelConfig.ENEMY_Y_MAX  ) {
            y = tmpY;
        }
    }

    public int getType() {
        return type;
    }
    
    public void inflictDamage() {
        life--;
    }   
    
    public int getLife() {
        return life;
    }
    
    @Override
    public void accept(Graphics g, GameObjectVisitor visitor) {
        visitor.visit(g, this);
    }
}
