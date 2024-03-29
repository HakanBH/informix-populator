package org.imd.informix.sample1.service;

import java.util.Arrays;
import java.util.Date;
import org.imd.informix.sample1.dao.AcdmDao;
import org.imd.informix.sample1.model.Acdm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author Iliyan_Dimov
 * Created on: 18-Jul-19
 */
@Component
public class Populator implements CommandLineRunner {

    private AcdmDao acdmDao;

    @Autowired
    public Populator(AcdmDao acdmDao) {
        this.acdmDao = acdmDao;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("Populator ");
        stopWatch.start("loading data ... ");

        for (int i = 0; i < 1; i++) {
            System.out.println(i);
            Acdm acdm =
                new Acdm(0, "ADMA", "BG", i, "220", 7654321, "BGN", 123.41, "ACMA", new Date(), new Date(),
                    1234567890.12345, "A", "S", "N");

            this.acdmDao.insertRecord(acdm);
        }

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("S".getBytes()));
        System.out.println(Arrays.toString("A".getBytes()));
    }
}
