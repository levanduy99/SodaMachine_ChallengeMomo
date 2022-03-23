package emuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Money {

    VND10(10000),
    VND20(20000),
    VND50(50000),
    VND100(100000),
    VND200(200000);

    private int denomination;
}
