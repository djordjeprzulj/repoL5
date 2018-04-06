package com.example.l5data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.l5data.model.TStore;

public interface TStoreRepository extends JpaRepository<TStore, Integer> {
	Iterable<TStore> findByName(String name);
	Iterable<TStore> findByIdLessThan(int id);  
	Iterable<TStore> findByNameLike(String likeCriteria);
	Iterable<TStore> findByNameContaining(String n);
	Page<TStore> findByNameContainingIgnoreCase(String n, Pageable p);
	Iterable<TStore> firstTen();  
	
	@Query("select s from TStore s where s.id < 6 or s.id=?1")
	Iterable<TStore> firstFiveOrId(int id); 

	@Query("select s from TStore s where s.name like ?1%")
	Iterable<TStore> findByNameStartsWith(String criteria);

}
