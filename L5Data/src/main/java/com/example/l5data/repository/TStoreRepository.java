package com.example.l5data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.l5data.model.TStore;

public interface TStoreRepository extends JpaRepository<TStore, Integer> {
	Iterable<TStore> findByName(String name);
	Iterable<TStore> findByIdLessThan(int id);  
	Iterable<TStore> findByNameLike(String likeCriteria);
	Iterable<TStore> findByNameContaining(String n);
	Page<TStore> findByNameContainingIgnoreCase(String n, Pageable p);

}
