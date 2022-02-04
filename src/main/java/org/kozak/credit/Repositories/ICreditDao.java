package org.kozak.credit.Repositories;

import org.kozak.credit.Models.Entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICreditDao extends JpaRepository<CreditEntity, Integer> {

}