package src;

import java.util.ArrayList;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(ArrayList<VPos> vPos);
}
