package edu.zut.cs.software.navigation.admin.car;

import edu.zut.cs.software.navigation.admin.car.dao.CarDao;
import edu.zut.cs.software.navigation.admin.car.domain.Car;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

////places和car一样
////map和driver一样

public class CarDaoTest extends GenericDaoTestCase<Long,Car,CarDao> {
    private static final Logger logger = LogManager.getLogger(CarDaoTest.class.getName());
    @Autowired
    CarDao carDao;

    @Test
    public void testFindAll() {

        List<Car> all = this.carDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<car> all={}", all);
        }
    }
}

