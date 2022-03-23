package models;

import dagger.Module;
import emuns.Money;
import emuns.Products;
import exception.MessageException;
import interfaces.MachineInterface;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Machine implements MachineInterface {

    private Inventory<Money> moneyInventory;
    private Inventory<Products> productsInventory;
    private Promotion promotion;

    private long totalSales;
    private long currentBalance;
    private Products currentProducts;
    private List<Money> listMoneyInserted = new ArrayList<Money>();

    @Inject
    public Machine(Inventory<Money> moneyInventory, Inventory<Products> productsInventory, Promotion promotion) {
        this.moneyInventory = moneyInventory;
        this.productsInventory = productsInventory;
        this.promotion = promotion;
    }

    @Override
    public List<Money> refund() {
        updateCashInventory(listMoneyInserted);
        currentBalance = 0;
        currentProducts = null;
        return listMoneyInserted;
    }

    @Override
    public void insert(Money money) {
        currentBalance = currentBalance + money.getDenomination();
        listMoneyInserted.add(money);
        moneyInventory.add(money);
    }

    @Override
    public long selectProductsAndGetPrice(Products products) {
        if (productsInventory.hasItem(products)) {
            currentProducts = products;
            return currentProducts.getPrice();
        }
        throw new MessageException("Sold Out");
    }

    @Override
    public Budget collectProductsAndChange() {

        List<Products> productsList = collectProducts();

        totalSales = totalSales + currentProducts.getPrice();

        List<Money> collectChange = collectChange();

        return new Budget(productsList, collectChange);
    }

    private List<Products> collectProducts() throws MessageException {
        if (isFullPaid()) {

            List<Products> list = new ArrayList<Products>();
            promotion.addItemAndCalculate(currentProducts);
            productsInventory.deduct(currentProducts);
            list.add(currentProducts);

            if(promotion.getRemainBudget() >= currentProducts.getPrice() && promotion.getRateItem(currentProducts)==100
                    && productsInventory.hasItem(currentProducts)) {

                int remainBudget = promotion.getRemainBudget() - currentProducts.getPrice();

                promotion.setRemainBudget(remainBudget);
                productsInventory.deduct(currentProducts);
                promotion.resetRateItem(currentProducts);

                list.add(currentProducts);
            }

            return list;
        }
        long remainingBalance = currentProducts.getPrice() - currentBalance;
        throw new MessageException("Price not full paid");
    }

    private List<Money> collectChange() {
        long changeAmount = currentBalance - currentProducts.getPrice();
        List<Money> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentProducts = null;
        listMoneyInserted.clear();
        return change;
    }

    private boolean isFullPaid() {

        if (currentBalance >= currentProducts.getPrice()) {
            return true;
        }

        return false;
    }

    private void updateCashInventory(List<Money> change) {
        for (Money money : change) {
            moneyInventory.deduct(money);
        }
    }

    private List<Money> getChange(long amount) throws MessageException {
        List<Money> changes = new ArrayList<Money>();
        Inventory<Money> changeInventory = new Inventory<Money>();
        if (amount > 0) {
            long remaining = amount;
            while (remaining > 0) {
                boolean isContinue = false;
                for (Money money : Money.values()) {
                    if (remaining >= money.getDenomination()
                            && moneyInventory.hasItemWithQty(money, changeInventory.getQuantity(money) + 1)) {
                        remaining -= money.getDenomination();
                        changeInventory.add(money);
                        isContinue = true;
                        break;
                    }
                }
                if (!isContinue) {
                    break;
                }
            }
            if (remaining != 0) {
                throw new MessageException("Not sufficient change");
            }

            for (Money money : changeInventory.getAll()) {
                for (int i = 0; i < changeInventory.getQuantity(money); i++) {
                    changes.add(money);
                }
            }
        }
        return changes;
    }
}
