package com.techelevator.deprecated;

import com.techelevator.view.Menu;

//@Deprecated
public class FinishTransactionNYI {

    private final Menu menu;

    public FinishTransactionNYI(Menu menu) {
        this.menu = menu;
    }

    public void displayFinishedTransaction() {
        BalanceNYI.giveChange();
    }
}
