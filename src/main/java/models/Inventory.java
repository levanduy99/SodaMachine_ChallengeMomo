package models;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class Inventory <I> {

    private Map<I, Integer> inventory = new HashMap<I, Integer>();

    public int getQuantity(I item){
        Integer value = inventory.get(item);
        return value == null? 0 : value ;
    }

    public boolean hasItem(I item){
        return getQuantity(item) > 0;
    }

    public void add(I item){
        int count = inventory.get(item) == null ? 0: inventory.get(item);
        inventory.put(item, count + 1);
    }

    public void deduct(I item) {
        if (hasItem(item)) {
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }
    }

    public void clear(){
        inventory.clear();
    }

    public void put(I item, int quantity) {
        inventory.put(item, quantity);
    }

    public List<I> getAll() {
        return new ArrayList(inventory.keySet());
    }

    public boolean hasItemWithQty(I item, int quantity) {
        return getQuantity(item) >= quantity;
    }
}
