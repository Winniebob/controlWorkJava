package view.command;

import view.View;

public class SaveToys implements Command {
    private View view;

    public SaveToys(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Save drop toys";
    }

    @Override
    public void execute() {
        this.view.saveToysQueue();
    }
}