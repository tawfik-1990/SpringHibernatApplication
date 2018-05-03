
package com.springhibernatapplication.dao;

import java.util.List;

import com.springhibernatapplication.model.Produit;


public interface ProduitDao {
    
    
	Produit findById(int id);

	void saveProduit(Produit produit);
	
	void deleteProduitByName(String name);
	
	List<Produit> findAllProduit();

	Produit findProduitByName(String name);

}