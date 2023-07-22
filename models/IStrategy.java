package models;

public interface IStrategy<Key> {
    public Key removeElement();

    public void addElement(Key key);

    public void removeElement(Key key);

    public void fetchData(Key key);
}
