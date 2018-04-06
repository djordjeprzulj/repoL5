package com.example.l5data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.l5data.model.TStore;
import com.example.l5data.repository.TStoreRepository;

@RestController
public class TStoreController {

	@Autowired
	private TStoreRepository tStoreRepository;

	@RequestMapping("/store")
	public Iterable<TStore> getAllStores() {
		return tStoreRepository.findAll();
	}

	@RequestMapping("/storeOrdered")
	public Iterable<TStore> getOrdered() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Direction.ASC, "name"));		
		orders.add(new Order(Direction.DESC, "id"));
		Sort sort = Sort.by(orders);
		return tStoreRepository.findAll(sort);
		
	}

	@RequestMapping("/storePaged")
	public Iterable<TStore> getPagedOrdered() {
		Pageable pageRequest = PageRequest.of(0,5);  	  
		return tStoreRepository.findAll(pageRequest);		
	}

	@RequestMapping("/storePagedOrdered")
	public Page<TStore> getStorePageOrdered(Pageable p) {		
		return tStoreRepository.findAll(p);
	}

}
