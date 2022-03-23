package models;

import dagger.internal.Factory;
import emuns.Money;
import emuns.Products;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Machine_Factory implements Factory<Machine> {
  private final Provider<Inventory<Money>> moneyInventoryProvider;

  private final Provider<Inventory<Products>> productsInventoryProvider;

  private final Provider<Promotion> promotionProvider;

  public Machine_Factory(Provider<Inventory<Money>> moneyInventoryProvider,
      Provider<Inventory<Products>> productsInventoryProvider,
      Provider<Promotion> promotionProvider) {
    this.moneyInventoryProvider = moneyInventoryProvider;
    this.productsInventoryProvider = productsInventoryProvider;
    this.promotionProvider = promotionProvider;
  }

  @Override
  public Machine get() {
    return new Machine(moneyInventoryProvider.get(), productsInventoryProvider.get(), promotionProvider.get());
  }

  public static Machine_Factory create(Provider<Inventory<Money>> moneyInventoryProvider,
      Provider<Inventory<Products>> productsInventoryProvider,
      Provider<Promotion> promotionProvider) {
    return new Machine_Factory(moneyInventoryProvider, productsInventoryProvider, promotionProvider);
  }

  public static Machine newInstance(Inventory<Money> moneyInventory,
      Inventory<Products> productsInventory, Promotion promotion) {
    return new Machine(moneyInventory, productsInventory, promotion);
  }
}
