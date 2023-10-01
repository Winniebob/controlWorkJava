package model.save;

import model.toys.Toys;


import java.io.*;
import java.util.*;

public class Save implements Saves{
    @Override
    public String saveToFile(String path, PriorityQueue<Toys> toysQueue) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Toys toy;
            while ((toy = toysQueue.poll()) != null) {
                writer.write(String.format("Id: %d, Name: %s, Chance drop: %.2f\n",
                        toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        String result = path;
        return result;
    }


}
