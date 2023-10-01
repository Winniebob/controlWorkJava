package view.command;

import view.View;

public class Exit implements Command {
    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Exit";
    }

    @Override
    public void execute() {
        this.view.exit();
    }
}