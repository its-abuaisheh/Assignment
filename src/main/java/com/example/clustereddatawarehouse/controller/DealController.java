package com.example.clustereddatawarehouse.controller;

import com.example.clustereddatawarehouse.entity.Deal;
import com.example.clustereddatawarehouse.service.DealService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping
    public ResponseEntity<Deal> createDeal(@Valid @RequestBody Deal deal) {
        Deal savedDeal = dealService.saveDeal(deal);
        return ResponseEntity.ok(savedDeal);
    }
}
