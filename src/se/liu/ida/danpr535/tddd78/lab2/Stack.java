package se.liu.ida.danpr535.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 2015-01-27.
 */
public class Stack {
    private List<Person> elements;

    public Stack() {
        this.elements = new ArrayList<Person>();
    }
    public int size(){
        return this.elements.size();
    }
    public boolean isEmpty(){
        return this.elements.size() == 0;
    }
    public void clear(){
        this.elements.clear();
    }
    public boolean contains(Person term){
        return this.elements.contains(term);
    }
    public Person pop(){
        return elements.remove(this.size() - 1);
    }
    public void push(Person person){
        this.elements.add(person);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + elements +
                '}';
    }
}
