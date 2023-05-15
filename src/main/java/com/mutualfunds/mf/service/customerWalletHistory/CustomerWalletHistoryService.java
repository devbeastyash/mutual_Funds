package com.mutualfunds.mf.service.customerWalletHistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualfunds.mf.entity.wallet.CustomerWalletHistory;
import com.mutualfunds.mf.repository.walletHistory.CustomerWalletHistoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerWalletHistoryService {
	@Autowired
	CustomerWalletHistoryRepository customerWalletHistoryRepository;
	
	public List<CustomerWalletHistory> getHistories(int customerId) {
		return customerWalletHistoryRepository.getHistories(customerId);
	}
	
//	public List<CustomerWalletHistory> getHistoriesWithTransactionType(int customerId, int transactionType) {
//		return customerWalletHistoryRepository.getHistoriesWithTransactionType(customerId, transactionType);
//	}
	
	@Transactional
	public String updateTransactionHistory(int customerId, int transactionTypeId, double walletAmount, int walletId) {
		customerWalletHistoryRepository.updateTransactionHistory(customerId, transactionTypeId, walletAmount, walletId);
		return "Update successful";
	}
}
