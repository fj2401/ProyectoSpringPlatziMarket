package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Recuperarmos todos los productos que hay en nuestra base de datos
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
