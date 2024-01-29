package se.liu.noalj314.lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public abstract class ListManipulate
{
    protected List<Person> elements = new ArrayList<>();
    public abstract int size();

    public abstract boolean isEmpty();

    public abstract boolean contains(Object o);

    public abstract Iterator<Person> iterator();

    public abstract boolean add(Person person);

    public abstract boolean remove(Object o);

    public abstract void clear();
}
