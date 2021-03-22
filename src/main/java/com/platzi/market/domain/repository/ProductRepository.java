package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

/*
* Aqui solo vamos a indicar el nombre de los metodos que queremos que cualquier repositorio que vaya a con
* productos tenga que implementar.
* definimos las reglas que va a tener nuestro dominio al momento que cualquier repositorio quiera utilizar
* o quiera acceder a producto dentro de una base de datos.
* esto nos va a garantizar a nosotros no acoplar nuestra base de datos a una base de datos especifica,
* sino que siempre estemos hablando en terminos de dominio(En este caso de product).
*/
public interface ProductRepository {
    //objetos de dominio
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save (Product product);
    void delete(int productId);
}
