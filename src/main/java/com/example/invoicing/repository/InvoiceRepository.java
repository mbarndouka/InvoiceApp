package com.example.invoicing.repository;

import com.example.invoicing.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository  extends JpaRepository<Invoice, Long> {

}
