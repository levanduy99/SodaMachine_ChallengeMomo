package interfaces;

import dagger.internal.Preconditions;
import javax.annotation.Generated;
import models.Machine;
import module.MachinesModule;
import module.MachinesModule_ProvideItemInventoryFactory;
import module.MachinesModule_ProvideMoneyInventoryFactory;
import module.MachinesModule_ProvidePromotionFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMachineComponent implements MachineComponent {
  private final MachinesModule machinesModule;

  private DaggerMachineComponent(MachinesModule machinesModuleParam) {
    this.machinesModule = machinesModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static MachineComponent create() {
    return new Builder().build();
  }

  @Override
  public Machine runMachine() {
    return new Machine(MachinesModule_ProvideMoneyInventoryFactory.provideMoneyInventory(machinesModule), MachinesModule_ProvideItemInventoryFactory.provideItemInventory(machinesModule), MachinesModule_ProvidePromotionFactory.providePromotion(machinesModule));}

  public static final class Builder {
    private MachinesModule machinesModule;

    private Builder() {
    }

    public Builder machinesModule(MachinesModule machinesModule) {
      this.machinesModule = Preconditions.checkNotNull(machinesModule);
      return this;
    }

    public MachineComponent build() {
      if (machinesModule == null) {
        this.machinesModule = new MachinesModule();
      }
      return new DaggerMachineComponent(machinesModule);
    }
  }
}
