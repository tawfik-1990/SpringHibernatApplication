package com.springhibernatapplication.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springhibernatapplication.model.Produit;
import com.springhibernatapplication.service.ProduitService;

@Controller
@RequestMapping("/")
public class AppController {
    

	@Autowired
	ProduitService service;
	
	@Autowired
	MessageSource messageSource;

	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Produit> produit = service.findAllProduit();
		model.addAttribute("produit", produit);
		return "Produit";
	}

	@RequestMapping(value = { "/delete-{name}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String name) {
		service.deleteProduitByName(name);
		return "redirect:/";
	}
        
        
        
        @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Produit produit = new Produit();
		model.addAttribute("produit", produit);
		//model.addAttribute("edit", false);
		return "NewProduct";
	}
        
        
        
        
        @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Produit produit, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "NewProduct";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.IsNotProduitfound( produit.getName())){
			FieldError nameError =new FieldError("produit","name",messageSource.getMessage("non.unique.name", new String[]{produit.getName()}, Locale.getDefault()));
		    result.addError(nameError);
			return "NewProduct";
		}
		
		service.saveProduit(produit);

		model.addAttribute("success", "Produit " + produit.getName() + " registered successfully");
		return "success";
	}
}



