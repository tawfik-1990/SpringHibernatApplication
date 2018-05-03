
package com.springhibernatapplication.service;

import com.springhibernatapplication.model.Produit;
import java.util.List;


public interface ProduitService {
    
    
        Produit findById(int id);
	
	void saveProduit(Produit produit);
	
	void updateProduit(Produit produit);
	
	void deleteProduitByName(String name);

	List<Produit> findAllProduit(); 
	
	Produit findProduitByName(String name);


        boolean IsNotProduitfound( String name);
}
