package org.farrukh.experiments.hibernate3.model.trading;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "TRADE_STATUS_ID_GEN", initialValue = 1, sequenceName = "TRADE_STATUS_ID_GEN_SEQ")
public class TradeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRADE_STATUS_ID_GEN")
    private Long id;

    @Column
    private Date cobdate;

    @Column
    private String region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCobdate() {
        return cobdate;
    }

    public void setCobdate(Date cobdate) {
        this.cobdate = cobdate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
