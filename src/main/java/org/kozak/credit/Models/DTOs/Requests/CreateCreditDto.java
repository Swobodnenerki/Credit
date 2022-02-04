package org.kozak.credit.Models.DTOs.Requests;

import lombok.Data;

@Data
public class CreateCreditDto {
    String firstName;
    String lastName;
    String pesel;
    String creditName;
    Double value;
}
