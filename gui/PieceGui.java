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
 * Cette classe permet de donner une image aux pièces
 *
 */

public class PieceGui extends ImageView implements CheckersPieceGui {
	
	public ImageView createPieceView(ImageView pieceGui, Image image, PieceSquareColor pieceColor){
		image = PieceGui.createImage(pieceColor, true);
		pieceGui.setImage(image);
		return pieceGui;
	}
	
	@Override
	public void promote(Image image) {
		
		// ToDo Atelier 2, utile pour Atelier 3
		
	}

	@Override
	public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {

		// ToDo Atelier 2, utile pour Atelier 4
		
		return false; // à changer 
	}
	

	/**
	 * @param pieceColor
	 * @param ispawn
	 * @return une image créée à partir d'un fichier png
	 */
	private static Image createImage(PieceSquareColor pieceColor, boolean ispawn) {

		Image image = null;
		String pieceImageFile = null, nomImageFile = null;
		File g = new File("");

		if (ispawn) {
			nomImageFile = pieceColor == PieceSquareColor.BLACK ? "caca.png" : "PionBlanc.png";
		}
		else {	
			nomImageFile = pieceColor == PieceSquareColor.BLACK ? "DameNoire.png" : "DameBlanche.png";
		}

		pieceImageFile = g.getAbsolutePath()+"/images/" + nomImageFile;	// TODO - attention au chemin
		try {
			image = new Image(new FileInputStream(pieceImageFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return image;
	}
	
}