package com.psoft.aplication.dao;

import com.psoft.aplication.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item,Integer>  {
    
}
