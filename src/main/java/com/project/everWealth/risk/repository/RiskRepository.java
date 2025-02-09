package com.project.everWealth.risk.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.everWealth.risk.entity.Risk;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {

    
        
}