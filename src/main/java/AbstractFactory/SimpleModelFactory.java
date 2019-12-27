package AbstractFactory;

import cz.fit.dpo.mvcshooter.model.ModelSimple;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class SimpleModelFactory implements AbstractModelFactory {

    @Override
    public IModel createModel() {
        return new ModelSimple();
    }

}
