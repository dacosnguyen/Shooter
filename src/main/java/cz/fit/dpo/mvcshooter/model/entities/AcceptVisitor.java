package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.view.GameObjectVisitor;

import java.awt.Graphics;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public interface AcceptVisitor {

    void accept(Graphics g, GameObjectVisitor visitor);

}
