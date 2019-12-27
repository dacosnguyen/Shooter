package TestSuites;

import cz.fit.dpo.mvcshooter.model.ModelRealistic;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.shootingmode.DoubleShootingMode;
import cz.fit.dpo.mvcshooter.model.shootingmode.SingleShootingMode;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class CountTest {
    private ModelRealistic model;

    public CountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        model = new ModelRealistic();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEnemyCount() {
        assertEquals(((ArrayList) model.getEnemies()).size(), ModelConfig.ENEMIES_COUNT);
    }

}
