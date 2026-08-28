package com.dimihris.accountsservice.service;

import com.dimihris.accountsservice.dto.CustomerDto;

public interface AccountsService {

    void createAccount(CustomerDto customerDto);
}
