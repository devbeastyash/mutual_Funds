package com.mutualfunds.mf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mutualfunds.mf.entity.wallet.CustomerWalletEntity;

public class CustomerWalletEntityTest {
    private CustomerWalletEntity wallet;

    @Before
    public void setUp() {
        wallet = new CustomerWalletEntity();
    }

    @Test
    public void testGetSetWalletId() {
        wallet.setWalletId(1);
        assertEquals(1, wallet.getWalletId());
    }

    @Test
    public void testGetSetCustomerId() {
        wallet.setCustomerId(2);
        assertEquals(2, wallet.getCustomerId());
    }

    @Test
    public void testGetSetWalletBalance() {
        wallet.setWalletBalance(1000.0);
        assertEquals(1000.0, wallet.getWalletBalance(), 0.001);
    }

    @Test
    public void testGetSetTransationDate() {
        Date date = new Date();
        wallet.setTransationDate(date);
        assertNotNull(wallet.getTransationDate());
        assertEquals(date, wallet.getTransationDate());
    }
}
