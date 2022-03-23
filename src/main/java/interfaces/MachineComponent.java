package interfaces;

import dagger.Component;
import models.Machine;
import module.MachinesModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = MachinesModule.class)
public interface MachineComponent {
    Machine runMachine();
}
