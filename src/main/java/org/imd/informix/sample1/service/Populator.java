package org.imd.informix.sample1.service;

import java.util.stream.Stream;
import org.imd.informix.sample1.model.dao.TTDAO;
import org.imd.informix.sample1.model.pojo.TTPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Iliyan_Dimov
 * Created on: 18-Jul-19
 */
@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private TTDAO ttDao;

    @Override
    public void run(String... args) throws Exception {
        for (int x = 0; x < 10000; x ++) {
            System.out.println(x);

            TTPojo ttPojo = new TTPojo();
            ttPojo.setId(x);
            ttPojo.setVersion(0);
            ttPojo.setName("name" + x);
            ttPojo.setData(String.valueOf(System.currentTimeMillis()));
            ttDao.insertRecord(ttPojo);
        }
    }
}
