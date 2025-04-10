package test.bookmanager.dto;

public record BookFilterDto(
        String title,
        String brand,
        Integer year,
        Integer quantity,
        Integer pageNumber
) {
}
