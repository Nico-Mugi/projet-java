package model;


import java.util.Collection;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 * 
 * Cete classe fabrique et stocke toutes les PieceModel du Model dans une collection 
 * elle est donc responsable de rechercher et mettre à jour les PieceModel (leur position)
 * En réalité, elle délègue à une fabrique le soin de fabriquer les bonnes PieceModel 
 * avec les bonnes coordonnées
 * 
 * En revanche, elle n'est pas responsable des algorithme métiers liés au déplacement des pièces
 * (responsabilité de la classe Model)
 */
public class ModelImplementor {

	// la collection de pièces en jeu - mélange noires et blanches
	private Collection<PieceModel> pieces ;	

	public ModelImplementor() {
		super();

		pieces = ModelFactory.createPieceModelCollection();
	}

	public PieceSquareColor getPieceColor(Coord coord) {
		return (this.isPiecehere(coord) != false ? this.findPiece(coord).getPieceColor() : null);
	}

	public boolean isPiecehere(Coord coord) {
		return (this.findPiece(coord) != null ? true : false);
	}

	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord, boolean isPieceToTake) {
		if(!(this.isPiecehere(initCoord) && !this.isPiecehere(targetCoord)))
			return false;
		return this.findPiece(initCoord).isMoveOk(targetCoord, isPieceToTake);
	}


	public boolean movePiece(Coord initCoord, Coord targetCoord) {
		if(!this.isPiecehere(initCoord))
			return false;
		this.findPiece(initCoord).move(targetCoord);
		return true;
	}

	public void removePiece(Coord pieceToTakeCoord) {
		this.pieces.remove(this.findPiece(pieceToTakeCoord));
	}

	
	public List<Coord> getCoordsOnItinerary(Coord initCoord, Coord targetCoord) {
		List<Coord> coordsOnItinerary = null;

		PieceModel piece = findPiece(initCoord);
		if (piece != null) {
			coordsOnItinerary = piece.getCoordsOnItinerary(targetCoord);
		}
		
		return coordsOnItinerary;
	}

	
	/**
	 * @param coord
	 * @return la pièce qui se trouve aux coordonnées indiquées
	 */
	 PieceModel findPiece(Coord coord) {
		if(coord != null) {
			for (PieceModel piece : this.pieces) {
				if(piece.hasThisCoord(coord)) {
					return piece;
				}
			}
		}
		return null;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * La méthode toStrong() retourne une représentation 
	 * de la liste de pièces sous forme d'un tableau 2D
	 * 
	 */
	public String toString() {


		String st = "";
		String[][] damier = new String[ModelConfig.LENGTH][ModelConfig.LENGTH];

		// création d'un tableau 2D avec les noms des pièces à partir de la liste de pièces
		for(PieceModel piece : this.pieces) {

			PieceSquareColor color = piece.getPieceColor();
			String stColor = (PieceSquareColor.WHITE.equals(color) ? "--B--" : "--N--" );

			int col = piece.getColonne() -'a';
			int lig = piece.getLigne() -1;
			damier[lig][col ] = stColor ;
		}

		// Affichage du tableau formatté
		st = "     a      b      c      d      e      f      g      h      i      j\n";
		for ( int lig = 9; lig >=0 ; lig--) {
			st += (lig+1) + "  ";
			for ( int col = 0; col <= 9; col++) {					 
				String stColor = damier[lig][col];				
				if (stColor != null) {						
					st += stColor + "  ";	
				} 
				else {
					st += "-----  ";
				}
			}
			st +="\n";
		}
		
		return "\nDamier du model \n" + st;	
	}

}
