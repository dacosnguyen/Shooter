
package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import java.util.Random;

/**
 *
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class EnemyMovable extends Enemy{

    protected int moveDelay = ModelConfig.ENEMY_MOVE_DELAY;
    
    public EnemyMovable(int x, int y) {
        super(x, y);
    }
    
    public void move() {
        if (moveDelay > 0) {
            moveDelay--;
            return;
        }
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
}
