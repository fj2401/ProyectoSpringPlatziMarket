package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*
     * Otra forma de hacer una consulta es de manera nativa:
     * @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true);
     * List<Producto> nombreQueQuerramos(int idCategoria);
     *
     * siempre es mejor usar los query methods por la flexivibidad que nos ofrece
     * a la hora de implementar nuestro codigo.
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Nos devuelve los productos con menos conatidad de stock mas vendidos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
