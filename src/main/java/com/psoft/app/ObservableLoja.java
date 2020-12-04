package com.psoft.app;

import com.psoft.app.model.Item;

public interface ObservableLoja {

    
        public void registerObserver(ObserverLoja observer);
        public void removeObserver(ObserverLoja observer);
        public void notifyObservers(Item item);  
    
    
}; 
    

