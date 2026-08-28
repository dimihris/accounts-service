package com.dimihris.accountsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class AccountsDto {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
