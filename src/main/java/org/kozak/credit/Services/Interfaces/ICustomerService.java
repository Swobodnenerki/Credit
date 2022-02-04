package org.kozak.credit.Services.Interfaces;

import org.kozak.credit.Models.DTOs.Requests.CreateCustomerDto;
import org.kozak.credit.Models.DTOs.Requests.CustomersIdsDto;
import org.kozak.credit.Models.DTOs.Response.GetCustomerIdDto;
import org.kozak.credit.Models.Entities.CustomerEntity;
import org.kozak.credit.Models.DTOs.Requests.SearchCustomerDto;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;

import java.util.List;

public interface ICustomerService {
    CustomerEntity searchCustomer(SearchCustomerDto searchCustomerDto);
    GetCustomerIdDto createCustomer(CreateCustomerDto createCustomerDto) throws IncorrectFieldException, PeselAlreadyUsedException;
    List<CustomerEntity> getCustomers(CustomersIdsDto customersIdsDto);
}
