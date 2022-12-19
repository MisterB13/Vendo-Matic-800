package com.techelevator;

import com.techelevator.data.Repo;
import com.techelevator.deprecated.PurchaseCLI;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
<<<<<<< HEAD
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private final static String FILE_PATH = "vendingmachine.csv";

	private static Map<String, Product> products;
=======

	private static final String MAIN_MENU_END = "End Program";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_END };
>>>>>>> 7aa632079ce0e7667d27ca72374d41d6a3b5581b

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
<<<<<<< HEAD
				Repo.printListOfProducts();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				PurchaseCLI purchaseCLI = new PurchaseCLI(menu);
				purchaseCLI.displayPurchasingMenu();
=======
				Repo.displayListOfProducts();
				PurchasingMenu pm = new PurchasingMenu(menu);
				pm.run();
			} if (choice.equals(MAIN_MENU_END)) {
				break;
>>>>>>> 7aa632079ce0e7667d27ca72374d41d6a3b5581b
			}
		}
	}

	public static void main(String[] args) {
		Repo.startup(FILE_PATH);
		products = Repo.getListOfProducts();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}
}
