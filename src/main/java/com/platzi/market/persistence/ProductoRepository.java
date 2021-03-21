package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Recuperarmos todos los productos que hay en nuestra base de datos
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    //El metodo findByIdCategoria esta relacionado con la lista ubicada en productoCrudRepository
    //cualquier cambio se tienen que hacer en los dos ficheros.
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
