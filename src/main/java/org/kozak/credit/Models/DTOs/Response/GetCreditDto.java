package org.kozak.credit.Models.DTOs.Response;

import lombok.Data;

@Data
public class GetCreditDto {
    String firstName;
    String lastName;
    String pesel;
    String creditName;
    Double value;
    Integer creditId;
}
