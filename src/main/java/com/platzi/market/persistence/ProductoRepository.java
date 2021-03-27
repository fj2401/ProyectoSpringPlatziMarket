package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductoRepository implements ProductRepository {
    @Autowired //esta anotacion da a entender a spring que los objetos que reciban esta notacion
    // les va a ceder el control a spring para que cree esas intancias, a parte estos objetos deben
    // de ser parte de spring(la clase debe de terner una notacion de spring)
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    //Recuperarmos todos los productos que hay en nuestra base de datos
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    //El metodo findByIdCategoria esta relacionado con la lista ubicada en productoCrudRepository
    //cualquier cambio se tienen que hacer en los dos ficheros.
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts((prods)));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
