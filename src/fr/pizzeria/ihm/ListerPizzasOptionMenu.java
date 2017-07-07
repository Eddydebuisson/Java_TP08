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
			if (s != null ) {
				System.out.println(dao.findAllPizzas()[i].getCode() + " -> " + dao.findAllPizzas()[i].getNom() + " (" + dao.findAllPizzas()[i].getPrix() + ")");
				i++;
			}
		}
		
		return true;
	}

	
	
	
}
