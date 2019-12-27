package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.ModelInfo;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer {
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;
    
    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;
 

    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
        
    
    public void drawCannon(Graphics g, Cannon cannon) {
        g.drawImage(cannonImage, 
              cannon.getX() - cannonImage.getWidth()/2, 
              cannon.getY() - cannonImage.getHeight()/2, null);
    }
    
    public void drawMissile(Graphics g, Missile missile) {
        g.drawImage(missileImage, 
              missile.getX() - missileImage.getWidth()/2, 
              missile.getY() - missileImage.getHeight()/2, null);
    }
    
    public void drawEnemy(Graphics g, Enemy enemy) {
        Image usedImage = enemy.getType() == 0 ? enemyImage1 : enemyImage2;
        g.drawImage(usedImage, 
              enemy.getX() - enemyImage1.getWidth()/2, 
              enemy.getY() - enemyImage1.getHeight()/2, null);
    }
    
    public void drawCollision(Graphics g, Collision collision) {        
        g.drawImage(collisionImage, 
              collision.getX() - collisionImage.getWidth()/2, 
              collision.getY() - collisionImage.getHeight()/2, null);
    }
    
    public void drawInfo(Graphics g, ModelInfo info) {
        g.drawString(
              "Force: " + info.cannonForce 
              + ", Angle: " + info.cannonAngle 
              + ", Gravity: " + info.gravity
              + ", Score: " + info.score
              + " | " + info.shootingMode,
              INFO_X, INFO_Y);
    }

}
