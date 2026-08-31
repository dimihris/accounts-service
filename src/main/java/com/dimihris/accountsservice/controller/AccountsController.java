package com.dimihris.accountsservice.controller;

import com.dimihris.accountsservice.constatns.AccountsConstants;
import com.dimihris.accountsservice.dto.CustomerAccountsDto;
import com.dimihris.accountsservice.dto.CustomerDto;
import com.dimihris.accountsservice.dto.response.ResponseDto;
import com.dimihris.accountsservice.service.AccountsService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private AccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/find")
    public ResponseEntity<CustomerAccountsDto> findAccount(@RequestParam String mobileNumber) {
        CustomerAccountsDto customerAccountsDto = accountsService.findAccount(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerAccountsDto);
    }
}
