package org.kozak.credit.Services.Implementation;

import org.kozak.credit.Models.DTOs.Requests.CreateCreditDto;
import org.kozak.credit.Models.DTOs.Requests.CreateCustomerDto;
import org.kozak.credit.Models.DTOs.Requests.CustomersIdsDto;
import org.kozak.credit.Models.DTOs.Requests.SearchCustomerDto;
import org.kozak.credit.Models.DTOs.Response.GetCreditDto;
import org.kozak.credit.Models.Entities.CreditEntity;
import org.kozak.credit.Models.Entities.CustomerEntity;
import org.kozak.credit.Repositories.ICreditDao;
import org.kozak.credit.Services.Exceptions.IncorrectFieldException;
import org.kozak.credit.Services.Exceptions.PeselAlreadyUsedException;
import org.kozak.credit.Services.Interfaces.ICreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CreditService implements ICreditService {

    @Autowired
    CustomerService customerService;

    @Autowired
    ICreditDao creditDao;

    @Override
    public Integer createCredit(CreateCreditDto creditDto) throws IncorrectFieldException, PeselAlreadyUsedException {
        SearchCustomerDto customerDto = new SearchCustomerDto();
        customerDto.setPesel(creditDto.getPesel());
        CustomerEntity customer = customerService.searchCustomer(customerDto);
        if(customer == null){
            CreateCustomerDto newCustomer = new CreateCustomerDto();
            newCustomer.setPesel(creditDto.getPesel());
            newCustomer.setFirstName(creditDto.getFirstName());
            newCustomer.setLastName(creditDto.getLastName());
            customerService.createCustomer(newCustomer);
        }
        if(creditDto.getCreditName() == null || creditDto.getCreditName().length() > 30 || creditDto.getCreditName() == "")
            throw new IncorrectFieldException("Credit name is incorrect");
        else if(creditDto.getValue() == null)
            throw new IncorrectFieldException("Credit value is null");
        else{
            CreditEntity newCredit = new CreditEntity();
            newCredit.setCreditName(creditDto.getCreditName());
            newCredit.setValue(creditDto.getValue());
            newCredit.setCustomersById(customer);
            System.out.println(customer.getId());
            var savedCredit = creditDao.saveAndFlush(newCredit);
            return savedCredit.getCreditId();
        }
    }

    @Override
    public List<GetCreditDto> getCredits() {
        List<CreditEntity> credits = creditDao.findAll();
        List<GetCreditDto> creditDtos = new ArrayList<>();
        List<Integer> customersIds = new ArrayList<>();
        for(CreditEntity credit: credits){
            customersIds.add(credit.getCustomersById().getId());
        }
        CustomersIdsDto customersIdsDto = new CustomersIdsDto();
        customersIdsDto.setCustomersIds(customersIds);
        List<CustomerEntity> customers = customerService.getCustomers(customersIdsDto);
        for(CreditEntity credit: credits){
            for(CustomerEntity customer: customers){
                if(credit.getCustomersById().getId().equals(customer.getId())){
                    GetCreditDto creditDto = new GetCreditDto();
                    creditDto.setCreditId(credit.getCreditId());
                    creditDto.setCreditName(credit.getCreditName());
                    creditDto.setValue(credit.getValue());
                    creditDto.setPesel(customer.getPesel());
                    creditDto.setFirstName(customer.getFirstname());
                    creditDto.setLastName(customer.getLastname());
                    creditDtos.add(creditDto);
                }
            }
        }
        return creditDtos;
    }


}
