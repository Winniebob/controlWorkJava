package view.command;

import view.View;

public class AddToys implements Command {
    private View view;

    public AddToys(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Add toys";
    }

    @Override
    public void execute() {
        this.view.addToys();
    }
}
