package org.imd.informix.sample1.dao;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.imd.informix.sample1.model.Acdm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AcdmDao {

    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("acdm");
    }

    @Transactional
    public int insertRecord(final Acdm acdm) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", acdm.getId());
        parameters.put("type", acdm.getType());
        parameters.put("country", acdm.getCountry());
        parameters.put("document_number", acdm.getDocumentNumber());
        parameters.put("airline_code", acdm.getAirlineCode());
        parameters.put("agent_code", acdm.getAgentCode());
        parameters.put("currency_code", acdm.getCurrencyCode());
        parameters.put("amount", acdm.getAmount());
        parameters.put("rtdn_type", acdm.getRtdnType());
        parameters.put("issue_date", acdm.getIssueDate());
        parameters.put("reporting_date", acdm.getReportingDate());
        parameters.put("bsplink_document", acdm.getBspLinkDocument());
        parameters.put("dispute_status", acdm.getDisputeStatus());
        parameters.put("is_deleted", acdm.getIsDeleted());
        parameters.put("is_active", acdm.getIsActive());

        return simpleJdbcInsert.execute(parameters);
    }
}
