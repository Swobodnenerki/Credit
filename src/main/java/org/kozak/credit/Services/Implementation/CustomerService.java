package org.kozak.credit.Services.Implementation;

import org.kozak.credit.Models.DTOs.Requests.CreateCustomerDto;
import org.kozak.credit.Models.DTOs.Requests.CustomersIdsDto;
import org.kozak.credit.Models.DTOs.Response.GetCustomerIdDto;
import org.kozak.credit.Models.Entities.CustomerEntity;
import org.kozak.credit.Models.DTOs.Requests.SearchCustomerDto;
import org.kozak.credit.Repositories.ICustomerDao;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;
import org.kozak.credit.Services.Interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerDao customerDao;

    @Override
    public CustomerEntity searchCustomer(SearchCustomerDto searchCustomerDto) {
        String pesel = searchCustomerDto.getPesel();
        return customerDao.findCustomerEntityByPesel(pesel);
    }

    @Override
    public GetCustomerIdDto createCustomer(CreateCustomerDto newCustomerDto) throws IncorrectFieldException, PeselAlreadyUsedException {
        GetCustomerIdDto getCustomerIdDto = new GetCustomerIdDto();
        if(customerDao.findCustomerEntityByPesel(newCustomerDto.getPesel()) != null)
            throw new PeselAlreadyUsedException("This PESEL was already used");
        if(newCustomerDto.getPesel() == null || newCustomerDto.getPesel().length() != 11)
            throw new IncorrectFieldException("Incorrect PESEL");
        else if(newCustomerDto.getFirstName() == null || newCustomerDto.getFirstName().length() > 30 || newCustomerDto.getFirstName() == "")
            throw new IncorrectFieldException("Incorrect first name");
        else if(newCustomerDto.getLastName() == null || newCustomerDto.getLastName().length() > 30 || newCustomerDto.getLastName() == "")
            throw new IncorrectFieldException("Incorrect last name");
        else {
            CustomerEntity newCustomer = new CustomerEntity();
            newCustomer.setPesel(newCustomerDto.getPesel());
            newCustomer.setFirstname(newCustomerDto.getFirstName());
            newCustomer.setLastname(newCustomerDto.getLastName());
            var savedCustomer = customerDao.saveAndFlush(newCustomer);
            getCustomerIdDto.setCustomerId(savedCustomer.getId());
            return getCustomerIdDto;
        }
    }

    @Override
    public List<CustomerEntity> getCustomers(CustomersIdsDto customersIdsDto) {
        List<Integer> customersIds = customersIdsDto.getCustomersIds();
        return customerDao.findAllById(customersIds);
    }

}
