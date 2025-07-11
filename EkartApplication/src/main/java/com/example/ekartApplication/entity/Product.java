package com.example.ekartApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
//test
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String name;
private String description;
private Double price;
private String stock;
private String category;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public String getStock() {
	return stock;
}
public void setStock(String stock) {
	this.stock = stock;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Product(Integer id, String name, String description, Double price, String stock, String category) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.stock = stock;
	this.category = category;
}
public Product() {
	super();
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
			+ stock + ", category=" + category + "]";
}
}
