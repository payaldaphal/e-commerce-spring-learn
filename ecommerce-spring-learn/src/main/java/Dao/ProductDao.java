package Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	}

