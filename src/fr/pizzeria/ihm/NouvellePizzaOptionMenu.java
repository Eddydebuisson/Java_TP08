package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {

	/**
	 * @param dao constructeur NouvellePizzaOptionMenu
	 */
	public NouvellePizzaOptionMenu(PizzaDao dao) {
		this.dao = dao;
		
	}

	@Override
	public String getLibelle() {
		return "2. Ajouter une nouvelle pizza";
	}

	@Override
	public boolean excute() {

		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez saisir le code");

		String code = Menu.sc.next();
		if (!code.equals("99")) {

			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = Menu.sc.next();
			System.out.println("Veuillez saisir le prix");
			String prix = Menu.sc.next();
			
			// Instanciation pizza
			Pizza pizza =  new Pizza(code, nom, Double.parseDouble(prix));
			
			// Sauvegarde pizza
			try {
				dao.saveNewPizza(pizza);
			} catch (SavePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
		}

		return true;
	}

}
