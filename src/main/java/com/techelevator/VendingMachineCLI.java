package com.techelevator;

import com.techelevator.data.Repo;
import com.techelevator.deprecated.PurchaseCLI;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				Repo.displayListOfProducts();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				PurchaseCLI purchaseCLI = new PurchaseCLI(menu);
				purchaseCLI.displayPurchasingMenu();
			}
		}
	}

	public static void main(String[] args) {
		Repo.startup();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}
}
