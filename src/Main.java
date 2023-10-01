import model.Service;
import model.save.Save;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        Save saving = new Save();
        Service service = new Service(saving);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
