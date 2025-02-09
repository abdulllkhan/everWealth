package com.project.everWealth.risk;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.project.everWealth.risk.entity.Risk;
import com.project.everWealth.risk.repository.RiskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;


@RestController
public class RiskController {
    @Autowired
    RiskRepository riskRepository;

    @GetMapping("risk")
    public ResponseEntity<?> getAllRiskEntities() {
          try {
            System.err.println("TEST");
            List<Risk> risks = riskRepository.findAll();
            System.out.println("-->"+risks);
            if (risks.isEmpty()) {
                return ResponseEntity.noContent().build(); // Return 204 No Content if the list is empty
            }
            return ResponseEntity.ok(risks); // Return 200 OK with the list of risks
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching data", e);
        }


    }
    
    
}
