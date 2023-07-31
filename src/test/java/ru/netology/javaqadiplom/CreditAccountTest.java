package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void replenishmentOfTheAccountIfThereIsMoneyOnTheBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4000,account.getBalance());
    }

    @Test
    public void ifReplenishmentAmountIsZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false,account.add(0));
    }

    @Test
    public void ifReplenishmentAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false,account.add(-1_000));
    }

    @Test
    public void buyingWithInTheLimit () {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15);
        account.pay(4_000);

        Assertions.assertEquals(-4_000, account.getBalance());
    }

    @Test
    public void buyingOverLimit () {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15);

        Assertions.assertEquals(false,account.pay(6_000));
    }

    @Test
    public void buyingEqualToTheLimit () {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15);

        Assertions.assertEquals(true, account.pay(5_000));
    }

    @Test
    public void theRateIsZero () {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.getRate());
    }

    @Test

    public void interestAmount () {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15);
        account.balance = 5_000;
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void theAmountOfInterestOnANegativeBalance () {
        CreditAccount account =new CreditAccount(
                0,
                5_000,
                15);
        account.balance = -10_000;
        Assertions.assertEquals(-1_500, account.yearChange());
    }
}

