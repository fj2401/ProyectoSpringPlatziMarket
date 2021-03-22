package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Diseñamos nuestros mappers
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    //con esta anotacion le indicamos a mapstruct que tiene que hacer el mapeo a la inversa sin volver
    //a indicar los mappings
    @InheritInverseConfiguration
    //Como en categoria tenemos producto y no lo vamos a mapear lo indicamos con la notacion mapping
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
