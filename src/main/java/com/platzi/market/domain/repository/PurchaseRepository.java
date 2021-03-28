package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    //aqui se especifica lo que quiero definir
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clienteId);//usamos optional para controlar los clientes que no tengan ninguna compra
    Purchase save(Purchase purchase); // guardamos una compra(recibimos la compra que queremos guardar)

}
