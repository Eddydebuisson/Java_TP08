package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public class Menu {
	
	
	public PizzaDao dao;
	private OptionMenu[] menu = new OptionMenu[4];
	public static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * Instanciation de PizzaDao et du menu.
	 *  
	 */
	public Menu() {
		dao = new PizzaDao();
		menu[0] = new ListerPizzasOptionMenu(dao);
		menu[1] = new NouvellePizzaOptionMenu(dao);
		menu[2] = new ModifierPizza(dao);
		menu[3] = new SupprimerPizza(dao);

	}

	/**
	 * 
	 *  Afichage du menu complet.
	 * 
	 */
	public void afficher() {

		System.out.println("***** Pizzeria Administration *****");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i].getLibelle());

		}

		System.out.println("99. Sortie");
	}

	/**
	 * 
	 *  Interface utilisateur
	 * 
	 */
	public void startMenu() {

		afficher();
		int reponse = -1;
		do {
			reponse = sc.nextInt();
			switch (reponse) {

			case 1:
				menu[0].excute();
				break;

			case 2:
				menu[1].excute();
				break;
			case 3:
				menu[2].excute();
				break;
			case 4:
				menu[3].excute();
				break;
			case 99:
				System.out.println("Aurevoir =( ");
				break;
			}
		} while (reponse != 99);

	}

}
