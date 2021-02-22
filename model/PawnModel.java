package model;

import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel extends AbstractPieceModel {

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord,pieceColor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = "Color : " + super.getPieceColor() + "\nLigne : " + this.getLigne() + "\nColonne : " + this.getColonne();

		return st;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		if (Coord.coordonnees_valides(targetCoord)) {
			int coefColor = coefColor();
			if (isPieceToCapture) {
				coefColor *= 2;
			}
			if (targetCoord.getLigne() == this.getLigne() + coefColor
					&& (targetCoord.getColonne() == this.getColonne() + coefColor
							|| targetCoord.getColonne() == this.getColonne() - coefColor)) {
				ret = true;
			}
		}

		return ret;
	}

	

}
