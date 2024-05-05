package com.turkcell.pair3.invoiceservice.services.rules;

import com.turkcell.pair3.invoiceservice.repositories.BillAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.messages.Messages;


@Component
@RequiredArgsConstructor
public class BillAccountBusinessRules {

    private final BillAccountRepository billAccountRepository;
    private final MessageService messageService;



}
