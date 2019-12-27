package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import java.awt.Graphics;

/**
 *
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public interface GameObjectVisitor {
    void visit(Graphics g, Cannon cannon);
    void visit(Graphics g, Enemy enemy);
    void visit(Graphics g, Collision collision);
    void visit(Graphics g, Missile missile);
}
