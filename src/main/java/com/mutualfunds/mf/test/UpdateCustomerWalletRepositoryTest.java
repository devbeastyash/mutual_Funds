package com.mutualfunds.mf.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.mutualfunds.mf.entity.wallet.CustomerWalletEntity;
import com.mutualfunds.mf.repository.updateCustomerWallet.UpdateCustomerWalletRepository;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCustomerWalletRepositoryTest {
    @InjectMocks
    private UpdateCustomerWalletRepository updateCustomerWalletRepository;

    @Mock
    private UpdateCustomerWalletRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMoneyToWallet() {
        updateCustomerWalletRepository.addMoneyToWallet(1000, 1);

        verify(repository, times(1)).addMoneyToWallet(anyDouble(), anyInt());
    }

    @Test
    public void testWithdrawMoneyFromWallet() {
        updateCustomerWalletRepository.withdrawMoneyFromWallet(1000, 1);

        verify(repository, times(1)).withdrawMoneyFromWallet(anyDouble(), anyInt());
    }

    @Test
    public void testGetAccountBalance() {
        double balance = 5000;

        when(repository.getAccountBalance(anyInt())).thenReturn(balance);

        double result = updateCustomerWalletRepository.getAccountBalance(1);

        assertEquals(balance, result, 0.001);

        verify(repository, times(1)).getAccountBalance(anyInt());
    }
}
