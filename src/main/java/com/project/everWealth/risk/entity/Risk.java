package com.project.everWealth.risk.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "risk")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Risk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "range_start", nullable = false)
    private Integer rangeStart;

    @Column(name = "range_end", nullable = false)
    private Integer rangeEnd;

    // @Convert(converter = InvestmentOptionsConverter.class)
    @Column(name = "invest_option", nullable = false)
    private String investmentOptions;

}