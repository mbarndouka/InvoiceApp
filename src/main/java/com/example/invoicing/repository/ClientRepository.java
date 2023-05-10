package com.example.invoicing.repository;

import com.example.invoicing.model.User;
import com.example.invoicing.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<User, Long> {
    Client findByEmail(String Email);
    List<Client> findByBusinessId(Long businessId);
}
