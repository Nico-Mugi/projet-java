package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 * 
 *         Cette classe permet de donner une image aux pi�ces
 *
 */

public class PieceGui extends ImageView implements CheckersPieceGui {

	public PieceGui(int col, int ligne) {
		Image image = null;
		PieceSquareColor pieceColor = null;
		if (!((col % 2 == 0 && ligne % 2 == 0) || (col % 2 != 0 && ligne % 2 != 0))) {
			if (ligne < 4)
				pieceColor = PieceSquareColor.BLACK;
			if (ligne > 5)
				pieceColor = PieceSquareColor.WHITE;
		}
		if (pieceColor != null) {
			image = PieceGui.createImage(pieceColor, true);
			this.setImage(image);
		}
	}

	@Override
	public void promote(Image image) {
		setImage(image);

	}

	@Override
	public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {
		boolean hasSameColorAsGamer = false;
		if(getImage().getUrl().contains(gamerColor.name()))
		{
			hasSameColorAsGamer = true;
		}
		return hasSameColorAsGamer;
	}

	/**
	 * @param pieceColor
	 * @param ispawn
	 * @return une image cr��e � partir d'un fichier png
	 */
	private static Image createImage(PieceSquareColor pieceColor, boolean ispawn) {

		Image image = null;
		String pieceImageFile = null, nomImageFile = null;
		File g = new File("");

		if (ispawn) {
			nomImageFile = pieceColor == PieceSquareColor.BLACK ? "PionNoir.png" : "PionBlanc.png";
		} else {
			nomImageFile = pieceColor == PieceSquareColor.BLACK ? "DameNoire.png" : "DameBlanche.png";
		}

		pieceImageFile = g.getAbsolutePath() + "/images/" + nomImageFile; // TODO - attention au chemin
		try {
			image = new Image(new FileInputStream(pieceImageFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return image;
	}

}