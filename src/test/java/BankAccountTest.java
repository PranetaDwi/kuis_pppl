import org.example.BankAccount;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountTest {

    public ArrayList<BankAccount> account;

    @BeforeAll
    public void InitClass(){
        account = new ArrayList<>();
    }

    @BeforeEach
    public void initMethod(){
        BankAccount neta = new BankAccount("12345", 50000);
        account.add(neta);
    }

    @Test
    public void testGetAccountNumber(){
        BankAccount neta = account.getFirst();
        Assertions.assertEquals("12345", neta.getAccountNumber());
    }

    @Test
    public void testGetBalance(){
        BankAccount neta = account.getFirst();
        Assertions.assertAll(
                () -> Assertions.assertEquals(50000, neta.getBalance()),
                () -> Assertions.assertNotEquals(0, neta.getBalance())
        );
    }

    @Test
    public void testDepositValid(){
        BankAccount neta = account.getFirst();
        neta.deposit(50000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(100000, neta.getBalance())
        );
    }

    @Test
    public void testDepositInValid(){
        BankAccount neta = account.getFirst();
        neta.deposit(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(50000, neta.getBalance())
        );
    }

    @Test
    public void testWithInvalidIllegalArgumentException(){
        BankAccount neta = account.getFirst();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            neta.deposit(-1);
        });
    }

    @Test
    public void testWithdraw(){
        BankAccount neta = account.getFirst();
        neta.withdraw(50000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, neta.getBalance())
        );
    }

    @Test
    public void testWithdrawInvalid(){
        BankAccount neta = account.getFirst();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            neta.withdraw(60000);
        });
    }

    @Test
    public void testTransferFunds(){
        BankAccount neta = account.getFirst();
        BankAccount angel = new BankAccount("90000", 70000);
        neta.transferFunds(angel, 50000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, neta.getBalance()),
                () -> Assertions.assertEquals(120000, angel.getBalance() )
        );
    }

    @Test
    public void testTransferFundsInvalid(){
        BankAccount neta = account.getFirst();
        BankAccount angel = new BankAccount("90000", 70000);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            neta.transferFunds(angel, 60000);
        });
    }

    @AfterEach
    public void cleanMethod(){
        account.clear();
    }

    @AfterAll
    public void cleanClass(){
        account.clear();
    }
}
