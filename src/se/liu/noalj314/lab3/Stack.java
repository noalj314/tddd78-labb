package se.liu.noalj314.lab3;


import java.util.Iterator;

public class Stack extends ListManipulate
{
    public void push (Person person) {
        elements.add(person);
    }
    public Person pop() {


        return elements.remove(elements.size() - 1);
    }


    @Override public int size() {
        return 0;
    }

    @Override public boolean isEmpty() {
        return elements.isEmpty();
    }


    @Override public boolean contains(final Object o) {
        return false;
    }

    @Override public Iterator<Person> iterator() {
        return null;
    }

    @Override public boolean add(final Person person) {
        return false;
    }

    @Override public boolean remove(final Object o) {
        return false;
    }


    @Override public void clear() {

    }
}
