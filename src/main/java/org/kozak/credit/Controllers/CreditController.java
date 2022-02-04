package org.kozak.credit.Controllers;


import org.kozak.credit.Models.DTOs.Requests.CreateCreditDto;
import org.kozak.credit.Models.DTOs.Response.GetCreditDto;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;
import org.kozak.credit.Services.Interfaces.ICreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    ICreditService creditService;

    @PostMapping
    public ResponseEntity<Integer> createCredit(@RequestBody CreateCreditDto creditDto) throws IncorrectFieldException, PeselAlreadyUsedException {
        Integer creditId = creditService.createCredit(creditDto);
        return new ResponseEntity<Integer>(creditId, HttpStatus.CREATED);
    }
    @ResponseBody
    @GetMapping
    public ResponseEntity<List<GetCreditDto>> getCredits(){
        List<GetCreditDto> creditDtos = creditService.getCredits();
        if(creditDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<GetCreditDto>>(creditDtos, HttpStatus.OK);
        }
    }


}
