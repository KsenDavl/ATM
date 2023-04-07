package davlks.atm;

import davlks.atm.exceptions.IncorrectAmountException;
import davlks.atm.exceptions.NotEnoughMoneyException;
import davlks.atm.models.ATM;
import davlks.atm.models.MoneyCounter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс ATM должен ")
class ATMTest {

    private ATM atm;

    @BeforeEach
    void init() {
        MoneyCounter moneyCounter = new MoneyCounter(10, 10, 10, 10, 10);
        atm = new ATM(moneyCounter);
    }

    @Test
    @DisplayName("зачислить на счет введенные купюры")
    void shouldAddMoney() {
        atm.receiveMoney(1, 4, 1, 1, 0);
        int balanceAfterAdding = atm.getBalance();
        assertEquals(balanceAfterAdding, 68450);
    }

    @Test
    @DisplayName("снять со счета нужную сумму")
    void shouldWithdrawMoney() {
        atm.withdrawMoney(6650);
        int balanceAfterWithdrawing = atm.getBalance();
        assertEquals(balanceAfterWithdrawing, 59850);
    }

    @Test()
    @DisplayName("выбрасывать ошибку, когда запрашивается сумма большая, чем есть на счете")
    void shouldThrowErrorWhenTryingToWithdrawMoreThanOnAccount() {
        Assertions.assertThatExceptionOfType(NotEnoughMoneyException.class)
                .isThrownBy(() -> atm.withdrawMoney(67650));
    }

    @Test()
    @DisplayName("выбрасывать ошибку, когда запрашивается сумма некратная 100")
    void shouldThrowErrorWhenTryingToWithdrawAmountNonDivisibleBy100() {
        Assertions.assertThatExceptionOfType(IncorrectAmountException.class)
                .isThrownBy(() -> atm.withdrawMoney(4333));
    }

    @Test
    @DisplayName("выводить баланс счета")
    void getBalance() {
        assertEquals(66500, atm.getBalance());
    }
}