package TestSuites;

import cz.fit.dpo.mvcshooter.model.ModelRealistic;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.shootingmode.DoubleShootingMode;
import cz.fit.dpo.mvcshooter.model.shootingmode.SingleShootingMode;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestSuites.CountTest.class})
public class ShootingModeTest {
    private ModelRealistic model;
    private Cannon cannon;


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        model = new ModelRealistic();
        cannon = model.getCannon();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSingleShootingMode() {
        ArrayList listOfMissiles = ((ArrayList) model.getMissiles());
        int missilesCnt = listOfMissiles.size();

        cannon.setShootingMode(new SingleShootingMode(cannon));
        model.shootCannon();

        assertEquals(((ArrayList) model.getMissiles()).size(), missilesCnt + 1);
    }

    @Test
    public void testDoubleShootingMode() {
        ArrayList listOfMissiles = ((ArrayList) model.getMissiles());
        int missilesCnt = listOfMissiles.size();

        cannon.setShootingMode(new DoubleShootingMode(cannon));
        model.shootCannon();

        assertEquals(((ArrayList) model.getMissiles()).size(), missilesCnt + 2);
    }
}
