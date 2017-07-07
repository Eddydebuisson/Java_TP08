package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu{
	
	/**
	 * @param dao contructeur de ListerPizzasOptionMenu
	 */
	public ListerPizzasOptionMenu(PizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "1. lister les pizza";
	}

	@Override
	public boolean excute() {
		int i = 0;
		for (Pizza s : dao.findAllPizzas() ) {
				System.out.println(s.getCode() + " -> " + s.getNom() + " (" +s.getPrix() + ")");
			}
		
		
		return true;
	}

	
	
	
}
