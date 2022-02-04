package org.kozak.credit.Services.Interfaces;


import org.kozak.credit.Models.DTOs.Requests.CreateCreditDto;
import org.kozak.credit.Models.DTOs.Response.GetCreditDto;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;

import java.util.List;

public interface ICreditService {
    Integer createCredit (CreateCreditDto creditDto) throws IncorrectFieldException, PeselAlreadyUsedException;
    List<GetCreditDto> getCredits();
}
