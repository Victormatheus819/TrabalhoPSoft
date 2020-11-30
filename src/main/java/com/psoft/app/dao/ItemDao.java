package com.psoft.app.dao;

import com.psoft.app.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item,Integer>  {
    
}
