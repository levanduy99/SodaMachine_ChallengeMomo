import emuns.Money;
import emuns.Products;
import interfaces.DaggerMachineComponent;
import interfaces.MachineComponent;
import models.Budget;
import models.Inventory;
import models.Machine;
import models.Promotion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UnitTest {

    private Machine machine;
    private Inventory<Money> moneyInventory = new Inventory<Money>();
    private Inventory<Products> productsInventory = new Inventory<Products>();
    private Promotion promotion = new Promotion();

    @Before
    public void setUp(){
        MachineComponent component = DaggerMachineComponent.create();
        machine = component.runMachine();

        for (Money money : Money.values()) {
            moneyInventory.put(money, 10);
        }

        for (Products products : Products.values()) {
            productsInventory.put(products, 10);
        }

        promotion.setBudget(50000);
        promotion.setWinRate(10);

        machine.setMoneyInventory(moneyInventory);
        machine.setProductsInventory(productsInventory);
        machine.setPromotion(promotion);

        productsInventory.put(Products.COKE, 10);
        productsInventory.put(Products.PEPSI, 10);
        productsInventory.put(Products.SODA, 20);
    }

    @Test()
    public void testBuyProductsWithExactPrice() {
        long price = machine.selectProductsAndGetPrice(Products.COKE);
        machine.insert(Money.VND10);

        Budget budget = machine.collectProductsAndChange();
        Products product = budget.getProductsList().get(0);
        List<Money> change = budget.getMoneyList();

        Assert.assertEquals(Products.COKE, product);
        Assert.assertTrue(change.isEmpty());
        Assert.assertEquals(0, getTotal(change));
    }

    @Test
    public void testBuyProductsWithMuchPrice() {
        long price = machine.selectProductsAndGetPrice(Products.COKE);
        machine.insert(Money.VND20);

        Budget budget = machine.collectProductsAndChange();
        Products product = budget.getProductsList().get(0);
        List<Money> change = budget.getMoneyList();

        Assert.assertEquals(Products.COKE.getPrice(), price);
        Assert.assertEquals(Products.COKE, product);
        Assert.assertTrue(!change.isEmpty());
        Assert.assertEquals(20000 - Products.COKE.getPrice(), getTotal(change));
    }

    private long getTotal(List<Money> change){
        long total = 0;
        for(Money money : change){
            total = total + money.getDenomination();
        }
        return total;
    }
}
