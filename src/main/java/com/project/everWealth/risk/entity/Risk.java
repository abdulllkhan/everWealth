package com.project.everWealth.risk.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.Instant;
import java.util.List;

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

    @Convert(converter = InvestmentOptionsConverter.class)
    @Column(name = "investment_options", columnDefinition = "JSON", nullable = false)
    private List<String> investmentOptions;

    @Column(name = "created_date", nullable = false)
    private Long createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = Instant.now().getEpochSecond(); // Set Unix timestamp before persisting
    }
}