package models;

import emuns.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Promotion {

    private Map<Products, Integer> rateProducts = new HashMap<Products, Integer>();
    private List<Products> histItems = new ArrayList<Products>();

    private int remainBudget;
    private int budget;
    private int winRate;

    public Promotion(){
    }

    public int getRemainBudget() {
        return remainBudget;
    }

    public void setRemainBudget(int remainBudget) {
        this.remainBudget = remainBudget;
    }

    public int getWinRate() {
        return winRate;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    public int getRateItem(Products products) {
        return rateProducts.get(products) == null ? 0 : rateProducts.get(products);
    }

    public void setRateItems(Map<Products, Integer> rateItems) {
        this.rateProducts = rateItems;
    }

    public void nextDay(){
        if(this.getRemainBudget() > 0){
            int rate = this.getWinRate() + this.getWinRate()/2;
            this.setWinRate(rate>100?100:rate);
        }else{
            this.setWinRate(10);
        }
        this.setRemainBudget(this.budget);
        this.histItems.clear();
        this.rateProducts.clear();
    }

    public void addItemAndCalculate(Products products) {

        if(this.getRemainBudget() > 0){
            this.histItems.add(products);
            if(histItems.size()>=3){
                int t = 0;
                Products last = histItems.get(histItems.size()-1);
                for (int i = histItems.size()-1; i>=0 ; i--) {
                    if(last.getName().equals(histItems.get(i).getName())){
                        t++;
                    }
                }

                if(t==3){
                    int rate = rateProducts.get(products) == null ? 0: rateProducts.get(products);
                    this.rateProducts.put(products, rate + this.getWinRate() > 100 ? 100 : rate + this.getWinRate());
                    this.histItems.clear();
                }
            }
        }
    }


    public void resetRateItem(Products products) {
        rateProducts.put(products, 0);
    }

    public List<Products> getHistItems() {
        return histItems;
    }

    public void setBudget(int budget) {
        this.budget = budget;
        this.remainBudget = budget;
    }
}
