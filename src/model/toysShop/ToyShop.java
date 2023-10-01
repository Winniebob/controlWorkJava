package model.toysShop;

import model.toys.Toys;

import java.util.PriorityQueue;
import java.util.Random;

public class ToyShop {
    private int[] ids;
    private String[] names;
    private double[] frequencies;
    private PriorityQueue<Toys> winsQueue;
    private PriorityQueue<Toys> toysQueue;

    public ToyShop() {
        this.winsQueue = new PriorityQueue<>();
        this.toysQueue = new PriorityQueue<>();
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setFrequencies(double[] frequencies) {
        this.frequencies = frequencies;
    }

    public void addToys() {
        if (toysQueue.size() == 0) {
            Toys toy1 = new Toys(1, "Monkey", 0.2);
            toysQueue.add(toy1);
            Toys toy2 = new Toys(2, "Robot", 0.2);
            toysQueue.add(toy2);
            Toys toy3 = new Toys(3, "Tank", 0.6);
            toysQueue.add(toy3);

            System.out.println("Toys have been added ");
        } else {
            System.out.println("Toys have already been added ");
        }
    }

    public String fillToyList() {
        for (int i = 0; i < ids.length; i++) {
            Toys toy = new Toys(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }
        return "Toy in shop.";
    }

    public String giveMeAToy() {
        String result = "";
        if (toysQueue.size() == 0) {
            result = "Toy shop is null.";
        } else {
            Random random = new Random();
            double sum = 0.0;
            for (Toys toy : toysQueue)
                sum += toy.getFrequency();
            double win = random.nextDouble(0.01, sum);
            double countFrequencies = 0.0;
            for (Toys toy : toysQueue) {
                countFrequencies += toy.getFrequency();
                if (countFrequencies >= win) {
                    winsQueue.add(toy);
                    result = toy.toString();
                    break;
                }
            }
        }
        return result;
    }


    public PriorityQueue<Toys> getWinsQueue() {
        return winsQueue;
    }
}