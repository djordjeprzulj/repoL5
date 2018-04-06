package com.example.l5data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.l5data.model.TStore;

public interface TStoreRepository extends JpaRepository<TStore, Integer> {
	
}
