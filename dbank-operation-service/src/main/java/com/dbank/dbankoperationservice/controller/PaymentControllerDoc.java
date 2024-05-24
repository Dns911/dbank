package com.dbank.dbankoperationservice.controller;

import com.dbank.dbankoperationservice.dto.request.PaymentCardHistoryDTO;
import com.dbank.dbankoperationservice.dto.request.PaymentDTO;
import com.dbank.dbankoperationservice.dto.response.PaymentResponseDTO;
import com.dbank.dbankoperationservice.entity.Payment;

import java.util.List;

public interface PaymentControllerDoc {
    Payment doPayment(PaymentDTO paymentDTO) throws Exception;
    List<PaymentResponseDTO> getHistory(PaymentCardHistoryDTO paymentHistoryDTO);
}
