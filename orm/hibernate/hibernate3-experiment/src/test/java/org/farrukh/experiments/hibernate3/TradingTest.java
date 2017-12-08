package org.farrukh.experiments.hibernate3;

import org.farrukh.experiments.hibernate3.model.trading.Trade;
import org.farrukh.experiments.hibernate3.model.trading.TradeId;
import org.farrukh.experiments.hibernate3.model.trading.TradeStatus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.function.Consumer;

public class TradingTest extends AbstractBaseTest {

    private static Logger logger = LoggerFactory.getLogger(TradingTest.class);

/*    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        doInHibernate(new Consumer<Session>() {
            @Override
            public void accept(Session session) {
                Query delete = session.createQuery("delete from Trade");
                delete.executeUpdate();
            }
        });
    }*/

    @Test
    public void testPersistingOnlyNewestTrades() {
        doInHibernate(new Consumer<Session>() {
            @Override
            public void accept(Session session) {
                TradeStatus newTradeStatus = getNewTradeStatus();

                TradeId id = new TradeId();
                id.setDeal("123426721");
                id.setTransactionId("1");
                id.setSeqNo(1L);

                Trade newTrade = newTrade(id, newTradeStatus);
                logger.info("-===============START MERGING===========-");
                session.saveOrUpdate(newTrade);
                //session.saveOrUpdate(newTrade);
                logger.info("-===============END MERGING===========-");
            }
        });
    }

    private TradeStatus getNewTradeStatus() {
        TradeStatus newTradeStatus = new TradeStatus();
        newTradeStatus.setCobdate(new Date());
        newTradeStatus.setRegion("TK");
        return newTradeStatus;
    }

    private Trade newTrade(TradeId id, TradeStatus tradeStatus) {
        Trade trade = new Trade();
        trade.setId(id);
        trade.setTradeStatus(tradeStatus);
        trade.setAgreementId(1L);
        trade.setNotional(7000.00);
        return trade;
    }

    @Override
    protected String getUnitTestProperties() {
        return "oracle_unittest.properties";
    }
}
