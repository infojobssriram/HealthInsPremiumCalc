package com.emidstest.hicalc.model.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emidstest.hicalc.model.jpa.PremiumCalcCriteria;
/**
 * The Class PremiumDetails.
 */
/**
 * @author sriram
 */
@Repository
public interface PremiumCalcCriteriaRepo extends JpaRepository<PremiumCalcCriteria,String>{
}
