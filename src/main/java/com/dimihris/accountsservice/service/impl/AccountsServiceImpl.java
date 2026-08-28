package com.dimihris.accountsservice.service.impl;

import com.dimihris.accountsservice.constatns.AccountsConstants;
import com.dimihris.accountsservice.dto.CustomerDto;
import com.dimihris.accountsservice.entity.Accounts;
import com.dimihris.accountsservice.entity.Customer;
import com.dimihris.accountsservice.exception.CustomerAlreadyExistsException;
import com.dimihris.accountsservice.repository.AccountsRepository;
import com.dimihris.accountsservice.repository.CustomerRepository;
import com.dimihris.accountsservice.service.AccountsService;
import com.dimihris.accountsservice.util.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService {

    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    private static final Random RANDOM = new Random();

    @Override
    public void createAccount(CustomerDto customerDto) {
        customerRepository.findByMobileNumber(customerDto.getMobileNumber())
                .ifPresent(customer -> {
                    throw new CustomerAlreadyExistsException(
                            "Customer already exists with the given mobile number"
                    );
                });

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Customer savedCustomer = customerRepository.save(customer);

        Accounts newAccount = createNewAccount(savedCustomer);
        accountsRepository.save(newAccount);
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts account = new Accounts();

        account.setCustomerId(customer.getCustomerId());
        account.setAccountNumber(generateAccountNumber());
        account.setAccountType(AccountsConstants.SAVINGS);
        account.setBranchAddress(AccountsConstants.ADDRESS);

        return account;
    }

    private long generateAccountNumber() {
        return 1_000_000_000L + RANDOM.nextInt(900_000_000);
    }
}