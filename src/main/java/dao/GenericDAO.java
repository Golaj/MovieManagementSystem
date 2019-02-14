
package dao;

import java.util.List;

public interface GenericDAO<T> {
    
    public void addThing(T t);
    public T getOneThing(Long id);
    public List<T> getAllThings();
    public void editThing(T t);
    public void removeThing(Long id);

}
