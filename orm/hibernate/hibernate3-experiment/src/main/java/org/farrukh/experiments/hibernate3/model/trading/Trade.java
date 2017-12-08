package org.farrukh.experiments.hibernate3.model.trading;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trade implements Serializable {

   // @GeneratedValue(strategy = GenerationType.AUTO, generator = "TRADE_ID_GEN")

    @Id
    private TradeId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TRADESTATUSID")
    private TradeStatus tradeStatus;

    @Column
    private Long agreementId;


    @Column
    private Double notional;

    public TradeId getId() {
        return id;
    }

    public void setId(TradeId id) {
        this.id = id;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public Double getNotional() {
        return notional;
    }

    public void setNotional(Double notional) {
        this.notional = notional;
    }
}
