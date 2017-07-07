package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {

	private Pizza[] listepizza = new Pizza[100];

	/**
	 * initialisation des pizzas avec le constructeur
	 */
	public PizzaDao() {

		listepizza[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		listepizza[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		listepizza[2] = new Pizza(2, "REI", "La Reine", 11.50);
		listepizza[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		listepizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		listepizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listepizza[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		listepizza[7] = new Pizza(7, "IND", "L'indienne", 14.00);
	}

	public Pizza[] findAllPizzas() {
		return listepizza;
	}
	
	/**
	 *
	 *regarde si la pizza existe déjà 
	 * @param a
	 * @return
	 */
	public boolean pizzaPresente(Pizza a){
		for (Pizza s : findAllPizzas() ){
			if(s.getCode().equals(a.getCode())){
				return true;
			}
		}
		return false;
				
	}
	
	
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		if(pizzaPresente(pizza)) throw new SavePizzaException("La pizza existe déjà");
		int i = 0;
		for (Pizza s : findAllPizzas()) {
			if (s != null) {
				i++;
			}
		}
		pizza.setId(i);
		findAllPizzas()[i] = pizza;
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
	
		
			int i = 0;
			while (!findAllPizzas()[i].getCode().equals(codePizza)) {
				i++;
			}
			findAllPizzas()[i] = pizza;

		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		int i = 0;
		while (!findAllPizzas()[i].getCode().equals(codePizza)) {
			i++;
		}

		while (findAllPizzas()[i] != null) {
			if (findAllPizzas()[i + 1] != null) {
				findAllPizzas()[i].setId(findAllPizzas()[i + 1].getId());
				;
				findAllPizzas()[i].setCode(findAllPizzas()[i + 1].getCode());
				;
				findAllPizzas()[i].setNom(findAllPizzas()[i + 1].getNom());
				;
				findAllPizzas()[i].setPrix(findAllPizzas()[i + 1].getPrix());
				;
			} else {
				findAllPizzas()[i] = null;
			}
			i++;
		}
		return false;
	}

}
