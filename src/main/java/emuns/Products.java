package emuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Products {

    COKE("Coke", 10000),
    PEPSI("Pepsi", 10000),
    SODA("Soda", 20000);

    private String name;
    private int price;
}
