package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
    como esta es una clase que esta interactuando directamente con la base de datos, es una buena practica
    annadirle la siguiente anotacionque indica que esta clase es la encargada de interactuar con la base de
    datos poque desde aqui realizamos las operaciones que queremos aplicar a nuestras tablas.

    Podemos usar tanto @Repository como @Component.
 */
@Repository
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

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
