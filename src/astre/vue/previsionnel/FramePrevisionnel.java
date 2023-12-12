package astre.vue.previsionnel;

/** Classe FramePrevisionnel
  * @author : Clémentin Ly
  * @version : 1.0 - 11/12/2023
  * @date : 06/12/2023
  */

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import astre.Controleur;
import astre.vue.outils.ConstantesVue;

public class FramePrevisionnel extends JFrame
{
	/*-------------*/
	/*--Attributs--*/
	/*-------------*/

	private Controleur ctrl;

	/*----------------*/
	/*--Constructeur--*/
	/*----------------*/

	/** Constructeur de FramePrevisionnel
	 * @param ctrl le controleur
	 * 
	 */

	public FramePrevisionnel ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.setSize               ( 1000, 700      );
		this.setTitle              ( "Prévisionnel" );
		this.setLocationRelativeTo ( null           );

		/* ------------------------- */
		/* Création des composants   */
		/* ------------------------- */

		JPanel panelBordure = new JPanel ( new BorderLayout ( ) );
		panelBordure.setBorder ( ConstantesVue.MARGE_INTERIEURE_FENETRE );

		panelBordure.add ( new PanelEnsSemestre  ( this.ctrl ), BorderLayout.CENTER );
		panelBordure.add ( new PanelBouton       ( this.ctrl ), BorderLayout.SOUTH );

		this.add( panelBordure );

		this.setVisible ( true );
	}
}