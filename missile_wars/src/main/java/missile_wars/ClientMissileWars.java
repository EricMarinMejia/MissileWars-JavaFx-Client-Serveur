package missile_wars;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.Declarations;
import missile_wars.dorsal.DorsalMissileWarsDistant;
import missile_wars.frontal.FrontalMissileWars;

public class ClientMissileWars implements NtroClientFx {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(new DorsalMissileWarsDistant());
		
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new FrontalMissileWars());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		Declarations.declarerModeles(registrar);
		
	}
}
