package view.command;

import view.View;

public class FillShop implements Command {
    private View view;

    public FillShop(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Add new toys";
    }

    @Override
    public void execute() {
        this.view.loadShop();
    }
}