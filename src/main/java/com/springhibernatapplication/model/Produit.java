
package com.springhibernatapplication.model;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="PRODUIT")
public class Produit {
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
        @Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;
    
        @NotEmpty
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
    
        @NotNull
	@Column(name = "PRIX", nullable = false)
	private BigDecimal prix;
        
        
        
        public int getId() {
		return id;
	}

	public void setId(int id) {
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
        
        
        
        	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
        
        
        
        @Override
	public String toString() {
		return "Produit [id=" + id + ", name=" + name + ", description=" + description + ", prix=" + prix + "]";
	}
}
