package cz.fit.dpo.mvcshooter.controller;

import AbstractFactory.IModel;
import memento.Caretaker;
import cz.fit.dpo.mvcshooter.model.ModelRealistic;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import java.awt.event.KeyEvent;

/**
 * @author Ondrej Stuchlik
 */
public class Controller {

    private IModel model;
    private MainWindow view;

    private Caretaker caretaker = new Caretaker();

    public Controller(IModel model) {
        this.model = model;
    }

    public void setView(MainWindow view) {
        this.view = view;
    }

    public void keyPressed(KeyEvent evt) throws InterruptedException, Exception {
        //System.out.println("Key pressed: " + evt.getKeyChar());
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                model.moveCannonDown();
                break;
            case KeyEvent.VK_UP:
                model.moveCannonUp();
                break;
            case KeyEvent.VK_LEFT:
                model.forceOfCannonDown();
                break;
            case KeyEvent.VK_RIGHT:
                model.forceOfCannonUp();
                break;
            case KeyEvent.VK_PAGE_UP:
                model.aimCannonUp();
                break;
            case KeyEvent.VK_PAGE_DOWN:
                model.aimCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                model.shootCannon();
                break;

            case KeyEvent.VK_HOME:
                model.increaseGravity();
                break;
            case KeyEvent.VK_END:
                model.decreaseGravity();
                break;

            case KeyEvent.VK_F1:
                view.showHelp();
                break;

            case KeyEvent.VK_F2:
                model.changeShootingMode();
                break;

            case KeyEvent.VK_F11:
                caretaker.saveMemento(model.save());
                break;

            case KeyEvent.VK_F12:
                model.load(caretaker.loadMemento());
                break;
        }
    }


}
