package com.example.clustereddatawarehouse.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clustereddatawarehouse.entity.Deal;
import com.example.clustereddatawarehouse.repository.DealRepository;

import jakarta.transaction.Transactional;

@Service
public class DealService {

    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private DealRepository dealRepository;

    @Transactional
    public Deal saveDeal(Deal deal) {
        logger.info("Saving deal with ID: {}", deal.getDealUniqueId());
        Optional<Deal> existingDeal = dealRepository.findByDealUniqueId(deal.getDealUniqueId());
        if (existingDeal.isPresent()) {
            logger.error("Deal with ID: {} already exists.", deal.getDealUniqueId());
            throw new IllegalArgumentException("Deal with this unique ID already exists.");
        }
        Deal savedDeal = dealRepository.save(deal);
        logger.info("Deal with ID: {} saved successfully.", deal.getDealUniqueId());
        return savedDeal;
    }
}
