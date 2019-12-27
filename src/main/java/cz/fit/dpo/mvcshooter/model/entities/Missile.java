package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.view.GameObjectVisitor;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import java.awt.Graphics;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Missile extends GameObject{
    private static double DEGREE_TO_RAD_MULTIPLIER = (2 * Math.PI) / 360;
    private int beginVelocity;
    private double beginAngleInRad;
    private int beginX;
    private int beginY;
    private long beginTime;

    public Missile(int x, int y, int velocity, int angle) {
        super(x, y);
        this.beginVelocity = velocity;
        this.beginAngleInRad = angle * DEGREE_TO_RAD_MULTIPLIER;
        this.beginX = x;
        this.beginY = y;
        this.beginTime = System.currentTimeMillis();
    }

    public boolean shouldBeDiscarted() {
        // don't discard based on y coord, it can still fall down
        return (x > ModelConfig.PLAYGROUND_WIDTH || y > ModelConfig.PLAYGROUND_HEIGHT );
    }

    public void move(int gravity) {
        double time = (new Long(System.currentTimeMillis() - beginTime)).doubleValue();
        time /= 100;
        x = (int) (beginX + (beginVelocity * time * Math.cos(beginAngleInRad)));
        y = (int) (beginY - (beginVelocity * time * Math.sin(beginAngleInRad))
              + (0.5 * gravity * Math.pow(time,2)));
    }

    @Override
    public void accept(Graphics g, GameObjectVisitor visitor) {
        visitor.visit(g, this);
    }
}
