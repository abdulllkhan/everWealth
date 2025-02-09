package com.project.everWealth.risk.entity;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateRiskPayload {
    @Min(1)
    @Max(10)
    @NotBlank(message = "Range start is required")
    private Integer rangeStart;

    @Min(1)
    @Max(10)
    @NotBlank(message = "Range end is required")
    private Integer rangeEnd;

    @NotEmpty(message = "Range start is required")
    private List<String> investmentOptions;
}
