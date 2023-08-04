package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(3_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = account.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayIfAmountZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.pay(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.pay(-500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayIfInitialBalanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = account.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayIfInitialBalanceLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                1_100,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(500);

        int expected = 1_500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayAmountIfBalanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(1_000);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = account.add(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIfAmountZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.add(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.add(-500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIfInitialBalanceEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                9_500,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = account.add(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIfInitialBalanceMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                9_800,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.add(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddAmountIfBalanceEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        int expected = 10_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        int expected = 100;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChangeIfNotInt() {
        SavingAccount account = new SavingAccount(
                2_582,
                1_000,
                10_000,
                5
        );

        int expected = 125;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChangeIfRateZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChangeIfRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount (2_000, 1_000, 10_000, -5);
        });
    }

    @Test
    public void shouldYearChangeIfInitialBalanceLessThanMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount (500, 1_000, 10_000, 5);
        });
    }

    @Test
    public void shouldYearChangeIfInitialBalanceMoreThanMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount (11_000, 1_000, 10_000, 5);
        });
    }

    @Test
    public void shouldYearChangeIfMinBalanceMoreThanMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount (10_000, 11_000, 10_000, 5);
        });
    }

    @Test
    public void shouldYearChangeIfMinBalanceEqualMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount (10_000, 10_000, 10_000, 5);
        });
    }
}