package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.payment.PaymentHistory;
import org.springframework.data.repository.CrudRepository;

public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long> {
}
