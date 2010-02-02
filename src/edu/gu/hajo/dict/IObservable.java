package edu.gu.hajo.dict;

import java.beans.PropertyChangeListener;

/**
 * THIS WILL BE USED IN LAB 2 as part of the MVC model
 * 
 * Any class that can be observed (i.e. update observers)
 * This is based on the Java beans event model
 * @author hajo
 *
 */
public interface IObservable {
   public void addPropertyChangeListener(PropertyChangeListener listener);
   public void removePropertyChangeListener(PropertyChangeListener listener);
}
