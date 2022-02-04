package org.kozak.credit.Repositories;

import org.kozak.credit.Models.Entities.CreditEntity;
import org.kozak.credit.Models.Entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface ICustomerDao extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findCustomerEntityByPesel(String pesel);
}