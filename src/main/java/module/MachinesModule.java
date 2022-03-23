package module;

import dagger.Module;
import dagger.Provides;
import emuns.Money;
import emuns.Products;
import models.Inventory;
import models.Promotion;


@Module
public class MachinesModule {

    @Provides
    public Inventory<Money> provideMoneyInventory() {
        return new Inventory<Money>();
    }

    @Provides
    public Inventory<Products> provideItemInventory() {
        return new Inventory<Products>();
    }

    @Provides
    public Promotion providePromotion( ) {
        return new Promotion();
    }
}
