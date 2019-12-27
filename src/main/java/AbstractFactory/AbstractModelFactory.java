package AbstractFactory;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 *
 *     The Model Factory is used to create game modes for the Shooter game.
 */
public interface AbstractModelFactory {

    IModel createModel();

}
