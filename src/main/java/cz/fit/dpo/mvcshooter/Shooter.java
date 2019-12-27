package cz.fit.dpo.mvcshooter;

import AbstractFactory.AbstractModelFactory;
import AbstractFactory.IModel;
import AbstractFactory.RealisticModelFactory;
import AbstractFactory.SimpleModelFactory;
import cz.fit.dpo.mvcshooter.controller.*;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import javax.swing.SwingUtilities;

/**
 * @author stue
 */
public class Shooter {

    public static void main(String[] args) {
        AbstractModelFactory abstractModelFactory = null;
        final IModel model;

        if (args.length == 0) {
            abstractModelFactory = createSpecificFactory("-s");
        } else {
            abstractModelFactory = createSpecificFactory(args[0]);
        }
        model = abstractModelFactory.createModel();

        final Controller controller = new Controller(model);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow(model, controller).setVisible(true);
            }
        });
    }

    public static AbstractModelFactory createSpecificFactory(final String arg) {
        if (arg.equals("-r")) {
            return new RealisticModelFactory();
        } else {
            return new SimpleModelFactory();
        }
    }
}
