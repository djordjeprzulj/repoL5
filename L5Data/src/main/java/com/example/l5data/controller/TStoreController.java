package com.example.l5data.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.l5data.model.TStore;
import com.example.l5data.repository.TStoreRepository;

@RestController
public class TStoreController {

	@Autowired
	TStoreRepository repository;

	@RequestMapping("/allStores")
	public Iterable<TStore> findAll() {
		Iterable<TStore> allStores = repository.findAll();
		Iterator<TStore> it = allStores.iterator();
		while (it.hasNext()) 
			System.out.println(it.next().getName());
		return allStores;
	}
}
