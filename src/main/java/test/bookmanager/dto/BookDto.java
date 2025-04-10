package test.bookmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public record BookDto(
        Long id,
        @NotBlank String vendorCode,
        @NotBlank String title,
        @Positive int year,
        @NotBlank String brand,
        @Positive int stock,
        @Positive BigDecimal price
) {
}