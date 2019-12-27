package TestSuites;

import AbstractFactory.AbstractModelFactory;
import AbstractFactory.IModel;
import cz.fit.dpo.mvcshooter.Shooter;
import cz.fit.dpo.mvcshooter.model.ModelRealistic;
import cz.fit.dpo.mvcshooter.model.ModelSimple;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class AbstractModelFactoryTest {


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSimpleModelCreation() {
        String arg = "-s";
        AbstractModelFactory af = Shooter.createSpecificFactory(arg);
        IModel model = af.createModel();

        Assert.assertTrue(model instanceof ModelSimple);
    }

    @Test
    public void testRealisticModelCreation() {
        String arg = "-r";
        AbstractModelFactory af = Shooter.createSpecificFactory(arg);
        IModel model = af.createModel();

        Assert.assertTrue(model instanceof ModelRealistic);
    }

}
