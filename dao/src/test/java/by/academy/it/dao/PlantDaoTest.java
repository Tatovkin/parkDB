package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Plant;
import by.academy.it.entities.PlantType;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Random;

@FixMethodOrder(value = MethodSorters.JVM)
public class PlantDaoTest extends TestCase {

    private static PlantDao plantDao = null;
    private static Logger log = Logger.getLogger(PlantDaoTest.class);
    private static Plant plant;
    private static Random random = new Random();

    public static PlantDao getPlantDao() {
        if (plantDao == null) {
            plantDao = new PlantDao();
        }
        return plantDao;
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlantDaoTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static junit.framework.Test suite() {
        return new TestSuite(PlantDaoTest.class);
    }

    private Plant getPlant() {
        if (plant == null) {
            plant = new Plant();
            plant.setType(PlantType.TREE.name());
            plant.setSerialNumber(random.nextInt(9999));
            plant.setLongitude(randomCoordinate(random.nextInt(180)));
            plant.setLongitude(randomCoordinate(random.nextInt(90)));
        }
        return plant;
    }

    private double randomCoordinate(int value) {
        return (2 * value) * random.nextDouble() - value;
    }

    public void testCreatePlant() {
        plant = getPlant();

        try {
            getPlantDao().saveOrUpdate(plant);
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertNotNull(plant.getId());
    }

    public void testUpdatePlant() {
        plant = getPlant();

        // update
        plant.setType(PlantType.BUSH.name());
        plant.setSerialNumber(random.nextInt(999));
        plant.setLongitude(randomCoordinate(random.nextInt(180)));
        plant.setLatitude(randomCoordinate(random.nextInt(90)));


        Plant updatedPlant = plant;
        try {
            getPlantDao().saveOrUpdate(plant);
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertEquals(updatedPlant, plant);
    }



}
