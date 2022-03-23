package models;

import emuns.Money;
import emuns.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    private List<Products> productsList;

    private List<Money> moneyList;
}
