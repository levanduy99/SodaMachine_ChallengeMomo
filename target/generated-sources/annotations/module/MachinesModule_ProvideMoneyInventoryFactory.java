package module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import emuns.Money;
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
public final class MachinesModule_ProvideMoneyInventoryFactory implements Factory<Inventory<Money>> {
  private final MachinesModule module;

  public MachinesModule_ProvideMoneyInventoryFactory(MachinesModule module) {
    this.module = module;
  }

  @Override
  public Inventory<Money> get() {
    return provideMoneyInventory(module);
  }

  public static MachinesModule_ProvideMoneyInventoryFactory create(MachinesModule module) {
    return new MachinesModule_ProvideMoneyInventoryFactory(module);
  }

  public static Inventory<Money> provideMoneyInventory(MachinesModule instance) {
    return Preconditions.checkNotNull(instance.provideMoneyInventory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
