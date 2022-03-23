package module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import emuns.Products;
import javax.annotation.Generated;
import models.Inventory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MachinesModule_ProvideItemInventoryFactory implements Factory<Inventory<Products>> {
  private final MachinesModule module;

  public MachinesModule_ProvideItemInventoryFactory(MachinesModule module) {
    this.module = module;
  }

  @Override
  public Inventory<Products> get() {
    return provideItemInventory(module);
  }

  public static MachinesModule_ProvideItemInventoryFactory create(MachinesModule module) {
    return new MachinesModule_ProvideItemInventoryFactory(module);
  }

  public static Inventory<Products> provideItemInventory(MachinesModule instance) {
    return Preconditions.checkNotNull(instance.provideItemInventory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
