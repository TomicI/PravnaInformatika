package com.example.demo.repository;

import com.example.demo.model.ContractR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRRepository extends JpaRepository<ContractR, Long> {
    Optional<ContractR> findByRobaId(Long id);
    List<ContractR> findByKupacId(Long id);
}
