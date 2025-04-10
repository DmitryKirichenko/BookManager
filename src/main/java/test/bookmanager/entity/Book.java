package test.bookmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String vendorCode;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false, length = 128)
    private String brand;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal price;

}
