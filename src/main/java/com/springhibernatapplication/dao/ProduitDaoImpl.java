
package com.springhibernatapplication.dao;


import com.springhibernatapplication.model.Produit;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository("produitDao")
public class ProduitDaoImpl extends AbstractDao<Integer,Produit > implements ProduitDao {
    
    public Produit findById(int id) {
		return getByKey(id);
	}

	public void saveProduit(Produit produit) {
		persist(produit);
	}

	public void deleteProduitByName(String name) {
		Query query = getSession().createSQLQuery("delete from PRODUIT where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Produit> findAllProduit() {
		Criteria criteria = createEntityCriteria();
		return (List<Produit>) criteria.list();
	}

	public Produit findProduitByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Produit) criteria.uniqueResult();
	}
    
}
