package missile_wars.dorsal;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;
import missile_wars.commun.Declarations;

public class DorsalMissileWarsDistant extends RemoteBackendNtro {

    @Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
        
    }
    
}
