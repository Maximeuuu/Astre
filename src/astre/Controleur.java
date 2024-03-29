package astre;

/** Classe Controleur
  * @author : Maximilien Lesterlin, Maxime Lemoine, Mateo Sa et Clémentin Ly
  * @version : 2.2 - 22/12/2023
  * @date : 06/12/2023
  */

import java.io.File;
import java.util.List;

import astre.vue.outils.AFrame;
import astre.vue.outils.PopUpErreur;
import astre.vue.FrameAccueil;

import astre.vue.FrameIdentifiant;
import astre.modele.*;
import astre.modele.elements.*;

//FIXME: enlever les TODO: et les FIXME: avant de rendre le projet
//TODO: mettre des belles constantes pour les colonnes des tableaux
//TODO: rajouter les bandeaux des parties du code

public class Controleur
{
	//TODO: généraliser l'emplacement de ces constantes
	public static final char AJOUTER   = 'A';
	public static final char MODIFIER  = 'M';
	public static final char SUPPRIMER = 'S';

	private AFrame ihm;
	private Astre  metier;

	public Controleur ( )
	{
		this.metier = new Astre        (      );
		this.ihm    = new FrameAccueil ( this );
		
		if ( ! this.metier.estGenere ( ) )
			this.metier.genererBDD ( );
	}
	
	/*---------------------------------------*/
	/*               ACCES IHM               */
	/*---------------------------------------*/ 

	/**
	 * Méthode permettant de mettre à jour la fenetre ouverte actuellement et utilisable par le controleur
	 */
	public void setFrameActuelle   ( AFrame fenetre ) { this.ihm = fenetre; }
	public AFrame getFrameActuelle (                ) { return this.ihm;    }

	/**
	 * Ouvre une popup pour afficher une erreur
	 */
	public static void afficherErreur ( String titre, String message )
	{
		new PopUpErreur ( titre, message );
	}

	/*---------------------------------------*/
	/*             ACCES METIER              */
	/*---------------------------------------*/ 

	public <T> List<T> getTable ( Class<T> type ) { return this.metier.getTable ( type ); }

	public Semestre          getSemestre           ( int    numSemestre           ) { return this.metier.getSemestre           ( numSemestre    ); }
	public Intervenant       getIntervenant        ( int    id                    ) { return this.metier.getIntervenant        ( id             ); }
	public Heure             getHeure              ( int    id                    ) { return this.metier.getHeure              ( id             ); }
	public Heure             getHeure              ( String nom                   ) { return this.metier.getHeure              ( nom            ); }
	public Contrat           getContrat            ( String nom                   ) { return this.metier.getContrat            ( nom            ); }
	public ModuleIUT         getModule             ( String nom                   ) { return this.metier.getModule             ( nom            ); }
	public int               getNBHeureEQTD        ( String code, String nomHeure ) { return this.metier.getNBHeureEQTD        ( code, nomHeure ); }
	public List<String>      getHistorique         (                              ) { return this.metier.getHistorique         (                ); }
	public Object[][]        getTableau            ( Class<?> type                ) { return this.metier.getTableau            ( type           ); }
	public Object[][]        getTableauParticulier ( String nomRecherche          ) { return this.metier.getTableauParticulier ( nomRecherche   ); }

	public void update ( Object o ) { this.metier.update ( o ); }
	public void insert ( Object o ) { this.metier.insert ( o ); }
	public void delete ( Object o ) { this.metier.delete ( o ); }

	public void majTableauBD ( Object[][] tab, Class<?> type                    ) { this.metier.majTableauBD ( tab, type ); }
	public void majObjetBD   ( Object[]   ens, Class<?> type, char modification ) { this.metier.majObjetBD   ( ens, type, modification ); }

	public boolean      nouvelleAnnee     ( String nom ) { return this.metier.nouvelleAnnee     ( nom ); }
	public boolean      nouvelleAnneeZero ( String nom ) { return this.metier.nouvelleAnneeZero ( nom ); }
	public String       getAnnee          (            ) { return this.metier.getAnnee          (     ); }
	public List<String> getEnsAnnee       (            ) { return this.metier.getEnsAnnee       (     ); }
	public boolean      changerAnnee      ( String nom ) { return this.metier.changerAnnee      ( nom ); }

	public static void main ( String[] args )
	{
		String cheminFichier  = "./data/identifiant/identifiant.txt";
		String cheminFichier2 = "../data/identifiant/identifiant.txt";

		File fichier  = new File ( cheminFichier  );
		File fichier2 = new File ( cheminFichier2 );

		if ( !fichier.exists ( ) && !fichier2.exists ( ) ) 
		{
			new FrameIdentifiant ( );
		}
		else 
		{
			new Controleur ( );
		}
	}
}
