package model;


import model.save.Save;
import model.toysShop.ToyShop;

public class Service {
    private ToyShop toyShop;
    private Save save;

    public Service(Save save) {
        this.toyShop = new ToyShop();
        this.save = save;
    }

    public void setIds(int[] ids) {
        toyShop.setIds(ids);
    }

    public void setNames(String[] names) {
        toyShop.setNames(names);
    }

    public void setFrequencies(double[] frequencies) {
        toyShop.setFrequencies(frequencies);
    }

    public String fillToyList(int[] ids, String[] names, double[] frequencies) {
        setIds(ids);
        setNames(names);
        setFrequencies(frequencies);
        String result = "Success"  + "\n";
        result += toyShop.fillToyList();
        return result;
    }

    public String giveMeAToy() {
        return toyShop.giveMeAToy();
    }
    public void addToys(){
        toyShop.addToys();
    }
    public String saveToysQueue(String path) {
        return save.saveToFile(path, toyShop.getWinsQueue());
    }


}