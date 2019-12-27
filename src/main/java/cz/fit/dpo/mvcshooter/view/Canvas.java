package cz.fit.dpo.mvcshooter.view;

import AbstractFactory.IModel;
import cz.fit.dpo.mvcshooter.model.ModelRealistic;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.ModelObserver;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements ModelObserver, GameObjectVisitor {
    GraphicsDrawer drawer = new GraphicsDrawer();
    IModel model;

    public Canvas(int x, int y, int width, int height, IModel model) {
        this.model = model;
        this.model.registerObserver(this);
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }

    @Override
    public void modelUpdated() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        model.getCannon().accept(g, this);
        
        for (Missile missile: model.getMissiles()) {
            missile.accept(g, this);
        }
        
        for (Enemy enemy: model.getEnemies()) {
            enemy.accept(g, this);
        }
        
        for (Collision collision: model.getCollisions()) {
            collision.accept(g, this);
        }
        
        drawer.drawInfo(g, model.getModelInfo());
        // todo implement
    }

    @Override
    public void visit(Graphics g, Cannon cannon) {
        drawer.drawCannon(g, cannon);
    }

    @Override
    public void visit(Graphics g, Enemy enemy) {
        drawer.drawEnemy(g, enemy);
    }

    @Override
    public void visit(Graphics g, Collision collision) {
        drawer.drawCollision(g, collision);    
    }

    @Override
    public void visit(Graphics g, Missile missile) {
        drawer.drawMissile(g, missile);
    }


}
