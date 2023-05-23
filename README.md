Depuis la nuit des temps, les programmeurs en quatrième session utilisent Ntro et JavaFx pour le cours d'Environnement Graphique.
Nous les avons utilisé pour coder le jeu MissileWars. Cependant, le projet est encore en cours de développement au moment de la remise.
Nous avons plusieurs fonctionnalités tel que l'inscription, le didacticiel, les paramètres, l'historique, les contrôles et le jeu.
Dans le code nous avons presque fini d'implémenter les missiles, cependant du à une contrainte de temps nous avons seulement les 
planchers et les jouers qui peuvent bouger. Nous avons différentes traductions ainsi que du CSS pour personaliser nos pages.

-Florentin Toupet-
    Branches:
        CSSMaster
        main
    Commits noMerges: Ftoupet #51

Travail effectué:
    Refonte complète du Menu
        -Mise en place d'un CSS style LimeGreen & Black sur le Menu.
        -Animations de boutons lors du hover & after
        -Ajustements mineurs sur la vueMenu.java afin de coordonner avec le nouveau menu.xml

    Ajout de nouvelles traductions en plusieurs langues (certaines plus utiles que d'autres)
        -Ajouts/Ajustements des 47 textes présentes dans le projet en CHINOIS.
        -Ajouts/Ajustements des 47 textes présents dans le projet en ANGLAIS.
        -Ajouts/Ajustements des 47 textes présents dans le projet en ESPAGNOL.
        -Ajouts/Ajustements des 47 textes présents dans le projet en Québecois (pas parfait)
        -Et quelques ajustements sur la langue Francaise
    
    Refonte complète de la page d'inscription
        -Incorporation du style/thème du jeu sur la page
        -Changements sur le Label joueur via le VueInscription.java
        -Fix du bouton Reset pour seulement Reset le LabalPlayer qui était écrit, afin de permettre à l'utilisateur de simplement appuyer sur le bouton pour réécrire par la suite.
        -Replacement des éléments dans un grand éléments
        -Fix de la méthode de validation (Bouton valider) via le vueInscription.java
        -Ajout du CSS (Oviously)
    Ajout Style File_Attente.xml:
        Ajouts des StyleClass css utilisées
    Général:
        -Mise en place des boutons pour toutes les pages pour avoir un style/thème général


-Eric-
    Travail effectué:
        Développement du jeu (assisté par Charles):
            - Programmation des planchers, joueurs, équipes et missiles dans le monde2d 
            - Programmation de la valeur plancher, joueur, équipes et missiles
		    - Programmation des EvtTouchePressed, EvtToucheReleased, EvtAjouterMissile
            - Programmation des messages MsgAjouterMissile, MsgModifierPositionJoueur
            - Programmation de la synchronisation des planchers, joueurs, équipes et missiles en suivant le modèle MVC
            - Programmation du mouvement des joueurs sur le canvas


-Charles-
	- Programmation de la file d'attente et du dorsal.
		Au démarage d'un client, le client demande reçois du serveur un id.
			Messages et évènements pour l'algorithme qui donne des id de joueur à chaque client.
			Solution de contournement pour régler un problème : 
				S'il y a déjà des parties, la fil d'attente et les boutons seront créé avant d'avoir reçu un id du serveur. les premiers bouton créé seront associé à des lambdas qui ont encore l'idJoueur -1. Solution est de faire attendre la création de la file d'attente jusqu'à ce qu'on ait un idJoueur (waitsFor(event(...)))
		Solution de contournement pour un problème avec des *clock()*:
			Il ne semble pas possible de conserver différentes clock() et les retirer dynamiquement sans que toutes les clocks s'arrêtent. Alors j'ai centralisé une clock dans Interval 
    - Réorganisation de base des appels de dessin sur le canvas
	- J'ai indiqué à Éric comment architecturer les classes et le code.
	- Vraiment beaucoup de débugage. 
	- De nombreux autres détails. 

-Antonii-



