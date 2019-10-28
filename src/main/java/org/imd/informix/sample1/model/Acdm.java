package org.imd.informix.sample1.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Acdm {

    private Integer id;
    private String type;
    private String country;
    private Integer documentNumber;
    private String airlineCode;
    private Integer agentCode;
    private String currencyCode;
    private Double amount;
    private String rtdnType;
    private Date issueDate;
    private Date reportingDate;
    private Double bspLinkDocument;
    private String disputeStatus;
    private String isActive;
    private String isDeleted;
}
