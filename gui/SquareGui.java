package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import nutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 * 
 * Classe d'affichage des carrés du damier
 * leur couleur est initialisé par les couleurs par défaut du jeu
 *
 */
class SquareGui extends BorderPane implements CheckersSquareGui {
	
	public SquareGui (int col, int ligne) {
		PieceSquareColor squareColor;

		// s�lection de la couleur de la case
		if ((col % 2 == 0 && ligne % 2 == 0) || (col % 2 != 0 && ligne % 2 != 0)) {
			squareColor = PieceSquareColor.WHITE;
		} else {
			squareColor = PieceSquareColor.BLACK;
		}
		
		// la couleur est d�finie par les valeurs par d�faut de configuration
		Color color = PieceSquareColor.BLACK.equals(squareColor) ? GuiConfig.CASEBLACK : GuiConfig.CASEWHITE;
		this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
	}

	/**
	 *Retourne l'indice du carr� sur la grille (N� de 0 � 99)
	 */
	@Override
	public int getSquareCoord() {
		int index = -1;
		Pane parent = (Pane) this.getParent();
		index = parent.getChildren().indexOf(this);
		return index;
	}

}

