package module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import models.Promotion;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MachinesModule_ProvidePromotionFactory implements Factory<Promotion> {
  private final MachinesModule module;

  public MachinesModule_ProvidePromotionFactory(MachinesModule module) {
    this.module = module;
  }

  @Override
  public Promotion get() {
    return providePromotion(module);
  }

  public static MachinesModule_ProvidePromotionFactory create(MachinesModule module) {
    return new MachinesModule_ProvidePromotionFactory(module);
  }

  public static Promotion providePromotion(MachinesModule instance) {
    return Preconditions.checkNotNull(instance.providePromotion(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
