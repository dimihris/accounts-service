package com.dimihris.accountsservice.service.impl;

import com.dimihris.accountsservice.dto.CustomerDto;
import com.dimihris.accountsservice.repository.AccountsRepository;
import com.dimihris.accountsservice.repository.CustomerRepository;
import com.dimihris.accountsservice.service.AccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService {

    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
