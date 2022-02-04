package org.kozak.credit.Models.DTOs.Requests;

import lombok.Data;

@Data
public class CreateCustomerDto {
    String firstName;
    String lastName;
    String pesel;
}
