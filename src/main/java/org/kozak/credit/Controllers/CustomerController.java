package org.kozak.credit.Controllers;

import org.kozak.credit.Models.DTOs.Requests.CreateCustomerDto;
import org.kozak.credit.Models.DTOs.Response.GetCustomerIdDto;
import org.kozak.credit.Models.Entities.CustomerEntity;
import org.kozak.credit.Models.DTOs.Requests.SearchCustomerDto;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;
import org.kozak.credit.Services.Interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/search")
    public CustomerEntity searchCustomer(@RequestBody SearchCustomerDto searchCustomerDto){
        CustomerEntity customer = customerService.searchCustomer(searchCustomerDto);
        return customer;
    }

    @PostMapping
    public GetCustomerIdDto createCustomer(@RequestBody CreateCustomerDto newCustomer) throws IncorrectFieldException, PeselAlreadyUsedException {
        GetCustomerIdDto customerId = customerService.createCustomer(newCustomer);
        return customerId;
    }




}
