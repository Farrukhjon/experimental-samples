package org.farrukh.experiments.money;

import org.farrukh.experiments.money.repository.AccountDao;
import org.farrukh.experiments.money.service.TransfersService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class MoneyTransfersServiceUnitTest extends BaseUnitTest {

    @Mock
    private AccountDao accountDao;

    private int payerAccountId;

    private int recipientAccountId;

    @InjectMocks
    private TransfersService transfersService;

/*    @Before
    public void setUp() throws Exception {
        Client payer = new Client("", "");
        Client recipient = new Client("", "");
        Account payerAccount = new Account(payer, "", 200.0);
        Account recipientAccount = new Account(recipient, "", 50.0);
        payerAccountId = accountService.createAccount(payerAccount);
        recipientAccountId = accountService.createAccount(recipientAccount);
    }

    @Test
    public void testTransferMoneyByMultipleThreadsConcurrently() throws MoneyTransferException {
        Account fromAccount = accountService.findAccountById(payerAccountId);
        Account toAccount = accountService.findAccountById(recipientAccountId);
        double amountForTransfer = 100.0;
        Transaction transaction = new Transaction(fromAccount, toAccount, amountForTransfer);
        transfersService.transfer(transaction);

        Account payer = accountService.findAccountById(payerAccountId);
        Account recipient = accountService.findAccountById(recipientAccountId);

        assertEquals(100.0, payer.getBalance(), 1);
        assertEquals(150.0, recipient.getBalance(), 1);
    }*/
}
