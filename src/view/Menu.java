package view;

import view.command.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;
    private View view;

    public Menu(View view) {
        this.view = view;
        this.commandList = new ArrayList<>();
        this.commandList.add(new FillShop(view));
        this.commandList.add(new GetToy(view));
        this.commandList.add(new SaveToys(view));
        this.commandList.add(new Exit(view));
        this.commandList.add(new AddToys(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Menu" + "\n");
        for (int i = 0; i < this.commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(this.commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        this.commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return this.commandList.size();
    }
}