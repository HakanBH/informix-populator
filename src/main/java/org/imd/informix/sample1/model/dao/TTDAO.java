package org.imd.informix.sample1.model.dao;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.imd.informix.sample1.model.pojo.TTPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TTDAO {

    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        simpleJdbcInsert = simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("testtable3");;
    }

    @Transactional
    public int insertRecord(final TTPojo ttPojo) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("c_id", ttPojo.getId().intValue());
        parameters.put("c_version", ttPojo.getVersion());
        parameters.put("c_name", ttPojo.getName());
        parameters.put("c_data", ttPojo.getData());

        return simpleJdbcInsert.execute(parameters);
    }
}
