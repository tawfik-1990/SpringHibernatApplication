
package com.springhibernatapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.springhibernatapplication.dao.ProduitDao;
import com.springhibernatapplication.model.Produit;




@Service("produitService")
@Transactional
public class ProduitServiceImpl implements ProduitService {
    
    
    
    @Autowired
	private ProduitDao dao;
	
	public Produit findById(int id) {
		return dao.findById(id);
	}
        
        
        
        public void saveProduit(Produit produit) {
		dao.saveProduit(produit);
	}
        
        
        public void updateProduit(Produit produit) {
		Produit entity = dao.findById(produit.getId());
		if(entity!=null){
			entity.setName(produit.getName());
			entity.setDescription(produit.getDescription());
			entity.setPrix(produit.getPrix());
		}
	}
    
        
        
        public void deleteProduitByName(String name) {
		dao.deleteProduitByName(name);
	}
    
    
        public List<Produit> findAllProduit() {
		return dao.findAllProduit();
	}
    
    
    public Produit findProduitByName(String name) {
		return dao.findProduitByName(name);
	}
    
    
    public boolean IsNotProduitfound( String name) {
		Produit produit = findProduitByName(name);
		return ( produit == null );
	}
    
}
