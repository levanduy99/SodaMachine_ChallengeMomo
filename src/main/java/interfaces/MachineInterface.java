package interfaces;

import emuns.Money;
import emuns.Products;
import models.Budget;

import java.util.List;

public interface MachineInterface {

    List<Money> refund();

    void insert(Money money);

    long selectProductsAndGetPrice(Products products);

    Budget collectProductsAndChange();
}
