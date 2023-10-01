package model.toys;

public class Toys implements Comparable<Toys>{
    private int id;
    private String name;
    private  double frequency;

    public Toys(int id, String name, double frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }


    @Override
    public int compareTo(Toys toy) {
        int firstCompare = Double.compare(this.frequency, toy.getFrequency());
        if (firstCompare == 0) {
            int secondCompare = this.name.compareTo(toy.getName());
            if (secondCompare == 0) {
                return Integer.compare(this.getId(), toy.getId());
            }
            return secondCompare;
        }
        return firstCompare;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Chance drop: %.2f\n",
                id, name, frequency);
    }


}