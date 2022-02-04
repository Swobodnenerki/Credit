package org.kozak.credit.Controllers;


import org.kozak.credit.Models.DTOs.Requests.CreateCreditDto;
import org.kozak.credit.Models.DTOs.Response.GetCreditDto;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;
import org.kozak.credit.Services.Implementation.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    CreditService creditService;

    @PostMapping
    public Integer createCredit(@RequestBody CreateCreditDto creditDto) throws IncorrectFieldException, PeselAlreadyUsedException {
        Integer creditId = creditService.createCredit(creditDto);
        return creditId;
    }
    @GetMapping
    public List<GetCreditDto> getCredits(){
        List<GetCreditDto> creditDtos = creditService.getCredits();
        return creditDtos;
    }


}
