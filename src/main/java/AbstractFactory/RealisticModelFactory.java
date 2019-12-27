package AbstractFactory;

import cz.fit.dpo.mvcshooter.model.ModelRealistic;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class RealisticModelFactory implements AbstractModelFactory {

    @Override
    public IModel createModel() {
        return new ModelRealistic();
    }

}
