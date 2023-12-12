package astre.modele.elements;

/** Classe Module 
  * @author : Maximilien Lesterlin
  * @version : 1.0 - 11/12/2023
  * @date : 06/12/2023
  */

import java.util.Map;

public class ModuleIUT
{
	Map<Heure, Integer> hmHeuresPn;
	Map<Heure, Integer> hmHeuresRepatiees;
	
	Semestre   semestre;
	TypeModule typeModule;
	String     code;
	String     libLong;
	String     libCourt;
	boolean    valide;

	public ModuleIUT ( Semestre semestre, TypeModule typeModule, String code, String libLong, String libCourt, Map<Heure, Integer> hmHeuresPn, Map<Heure, Integer> hmHeuresRepatiees )
	{
		this.semestre          = semestre;
		this.typeModule        = typeModule;
		this.code              = code;
		this.libLong           = libLong;
		this.libCourt          = libCourt;
		this.valide            = false;
		this.hmHeuresPn        = hmHeuresPn;
		this.hmHeuresRepatiees = hmHeuresRepatiees;
	}

	/*---------------------------------------*/
	/*                GETTEUR                */
	/*---------------------------------------*/

	public boolean             estValide             ( ) { return this.valide;            }
	public Semestre            getSemestre           ( ) { return this.semestre;          }
	public TypeModule          getTypeModule         ( ) { return this.typeModule;        }
	public String              getCode               ( ) { return this.code;              }
	public String              getLibLong            ( ) { return this.libLong;           }
	public String              getLibCourt           ( ) { return this.libCourt;          }
	public Map<Heure, Integer> getHmHeureRepartiees  ( ) { return this.hmHeuresRepatiees; }
	public Map<Heure, Integer> getHmHeurePn          ( ) { return this.hmHeuresPn;        }

	public int getHeureRepartiees ( )
	{
		int somme = 0;
		
		for ( Heure h : this.hmHeuresRepatiees.keySet ( ) )
			somme += this.hmHeuresRepatiees.get ( h );

		return somme;
	}

	public int getHeurePn ( )
	{
		int somme = 0;
		
		for ( Heure h : this.hmHeuresPn.keySet ( ) )
			somme += this.hmHeuresPn.get ( h );

		return somme;
	}


	/*---------------------------------------*/
	/*                SETTEUR                */
	/*---------------------------------------*/

	public void setSemestre   ( Semestre   semestre   ) { this.semestre   = semestre;   }
	public void setTypeModule ( TypeModule typeModule ) { this.typeModule = typeModule; }
	public void setCode       ( String     code       ) { this.code       = code;       }
	public void setLibLong    ( String     libLong    ) { this.libLong    = libLong;    }
	public void setLibCourt   ( String     libCourt   ) { this.libCourt   = libCourt;   }
	public void setValide     ( boolean    choix      ) { this.valide     = choix;      }
}
