package com.psoft.app;

import com.psoft.app.model.Item;

import org.springframework.stereotype.Service;

@Service
public interface ObserverLoja {

    public void update(Item item);
    
}
