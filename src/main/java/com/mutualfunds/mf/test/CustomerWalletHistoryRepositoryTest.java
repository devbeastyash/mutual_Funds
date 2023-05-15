package com.mutualfunds.mf.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.mutualfunds.mf.entity.wallet.CustomerWalletHistory;
import com.mutualfunds.mf.repository.walletHistory.CustomerWalletHistoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerWalletHistoryRepositoryTest {
    @InjectMocks
    private CustomerWalletHistoryRepository walletHistoryRepository;

    @Mock
    private CustomerWalletHistoryRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetHistories() {
        List<CustomerWalletHistory> histories = new ArrayList<>();
        histories.add(new CustomerWalletHistory(1, 1, 1, 1000, 1, new Date()));
        histories.add(new CustomerWalletHistory(2, 1, 1, 2000, 2, new Date()));

        when(repository.getHistories(anyInt())).thenReturn(histories);

        List<CustomerWalletHistory> result = walletHistoryRepository.getHistories(1);

        assertEquals(histories.size(), result.size());
        assertEquals(histories.get(0), result.get(0));
        assertEquals(histories.get(1), result.get(1));

        verify(repository, times(1)).getHistories(anyInt());
    }

    @Test
    public void testUpdateTransactionHistory() {
        walletHistoryRepository.updateTransactionHistory(1, 1, 1000, 1);

        verify(repository, times(1)).updateTransactionHistory(anyInt(), anyInt(), anyDouble(), anyInt());
    }
}
   
