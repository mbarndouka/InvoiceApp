package com.example.invoicing.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Invoice")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_generator")
    @SequenceGenerator(name = "invoice_generator", sequenceName = "invoice_seq", initialValue = 100000, allocationSize = 1)
    @Column
    private Long id;

    @Column(unique = true, length = 6)
    private String InvoiceNumber;

    @Column
    private LocalDateTime invoiceDate;

    @Column
    private Integer quantity;

    @Column
    private Integer unitPrice;

    @Column
    private BigDecimal totalAmount;

    @Column
    private  BigDecimal VAT;

    @Column
    private BigDecimal total_amount_VAT;

    @Column
    private LocalDate dueDate;

    @Column
    private String status;




    @PrePersist
    public void generatedNumber(){
        String prefix = "INV";
        Long suffix = id % 1000000L;
        InvoiceNumber = prefix + String.format("%06d", suffix);
    }

    @PrePersist
    public void localDate(){
        invoiceDate = LocalDateTime.now();
    }

    public Invoice(String invoice_number, LocalDate dueDate){
        this.InvoiceNumber = InvoiceNumber;
        this.dueDate = LocalDate.from(invoiceDate.plusWeeks(2));

    }
}
