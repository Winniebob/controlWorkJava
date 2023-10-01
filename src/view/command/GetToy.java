package view.command;

import view.View;

public class GetToy implements Command {
    private View view;

    public GetToy(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Give out a toy";
    }

    @Override
    public void execute() {
        this.view.getToy();
    }
}