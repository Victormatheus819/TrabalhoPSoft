package com.psoft.app;

import com.psoft.app.model.Item;

//interface observável  para observer
public interface ObservableLoja {

    
        public void registerObserver(ObserverLoja observer);
        public void removeObserver(ObserverLoja observer);
        public void notifyObservers(Item item);  
    
    
}; 
    

