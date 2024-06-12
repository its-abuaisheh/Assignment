package com.example.clustereddatawarehouse.repository;

import com.example.clustereddatawarehouse.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealRepository extends JpaRepository<Deal, Long> {
    Optional<Deal> findByDealUniqueId(String dealUniqueId);
}
