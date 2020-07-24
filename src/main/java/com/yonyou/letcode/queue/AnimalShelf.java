package com.yonyou.letcode.queue;

import java.util.LinkedList;

class AnimalShelf {

    LinkedList<int[]> animals;
    public AnimalShelf() {
        animals = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
        animals.add(animal);
    }
    
    public int[] dequeueAny() {
       return animals.isEmpty() ? new int[]{-1, -1} : animals.poll();
    }
    
    public int[] dequeueDog() {
        int[] dog = new int[]{-1, -1};
        for (int[] animal : animals) {
            if (animal[1] == 1) {
                dog = animal;
                break;
            }
        }
        animals.remove(dog);
        return dog;
    }
    
    public int[] dequeueCat() {
        int [] cat = new int[]{-1, -1};
        for (int[] animal : animals) {
            if (animal[1] == 0) {
                cat = animal;
                break;
            }
        }
        animals.remove(cat);
        return cat;
    }
}
