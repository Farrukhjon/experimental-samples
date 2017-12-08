package org.farrukh.experiments.hibernate3.model.trading;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *  - It must implement java.io.Serializable.
 *  - It must re-implement equals() and hashCode() consistently with the database's notion of composite key equality.
 */

@Embeddable
public class TradeId implements Serializable {

    private String deal;

    private String transactionId;

    private Long seqNo;

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeId tradeId = (TradeId) o;

        if (!deal.equals(tradeId.deal)) return false;
        if (!transactionId.equals(tradeId.transactionId)) return false;
        return seqNo.equals(tradeId.seqNo);
    }

    @Override
    public int hashCode() {
        int result = deal.hashCode();
        result = 31 * result + transactionId.hashCode();
        result = 31 * result + seqNo.hashCode();
        return result;
    }

}
