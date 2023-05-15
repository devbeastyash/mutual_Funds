package com.mutualfunds.mf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mutualfunds.mf.entity.wallet.CustomerWalletHistory;

public class CustomerWalletHistoryTest {
    private CustomerWalletHistory history;

    @Before
    public void setUp() {
        history = new CustomerWalletHistory();
    }

    @Test
    public void testGetSetId() {
        history.setId(1);
        assertEquals(1, history.getId());
    }

    @Test
    public void testGetSetWalletId() {
        history.setWalletId(2);
        assertEquals(2, history.getWalletId());
    }

    @Test
    public void testGetSetCustomerId() {
        history.setCustomerId(3);
        assertEquals(3, history.getCustomerId());
    }

    @Test
    public void testGetSetWalletAmount() {
        history.setWalletAmount(1000);
        assertEquals(1000, history.getWalletAmount());
    }

    @Test
    public void testGetSetTransactionTypeId() {
        history.setTransactionTypeId(4);
        assertEquals(4, history.getTransactionTypeId());
    }

    @Test
    public void testGetSetTransactionDate() {
        Date date = new Date();
        history.setTransactionDate(date);
        assertNotNull(history.getTransactionDate());
        assertEquals(date, history.getTransactionDate());
    }
}
