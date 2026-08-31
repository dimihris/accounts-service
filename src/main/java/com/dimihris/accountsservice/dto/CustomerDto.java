package com.dimihris.accountsservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class CustomerDto {

    @Size(min = 2, max = 30)
    @NotEmpty(message = "Name cannot be null or empty")
    private String name;

    @Email(message = "Email address should be a valid value")
    @NotEmpty(message = "Email address cannot be null or empty")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;
}
