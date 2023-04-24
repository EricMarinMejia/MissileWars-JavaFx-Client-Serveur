package missile_wars;

import ca.ntro.app.NtroServerJdk;
import ca.ntro.app.ServerRegistrarJdkImpl;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.Declarations;
import missile_wars.dorsal.DorsalMissileWars;

public class ServeurMissileWars implements NtroServerJdk {
	
	public static void main(String[] args) {
		NtroServerJdk.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(new DorsalMissileWars());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		Declarations.declarerModeles(registrar);
		
	}

	@Override
	public void registerServer(ServerRegistrarJdkImpl registrar) {
		Declarations.declarerServeur(registrar);
		
	}

}
