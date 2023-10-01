package model.save;

import model.toys.Toys;


import java.util.PriorityQueue;

public interface Saves {
    String saveToFile(String path, PriorityQueue<Toys> toysQueue);
}
