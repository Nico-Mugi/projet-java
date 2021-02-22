package model;


import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;
/**
 * @author francoiseperrin
 *
 *le mode de d�placement et de prise de la reine est diff�rent de celui du pion
 */
public class QueenModel extends AbstractPieceModel {

	public QueenModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord,pieceColor);
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		System.out.println("you were here");
		if (Coord.coordonnees_valides(targetCoord)) {	
			System.out.println("I was here");
			if (Math.abs(targetCoord.getLigne()-this.getLigne())
					== Math.abs(targetCoord.getColonne()-this.getColonne())) {
				System.out.println("I am here");
				ret = true;
			}
		}
		
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = "Color : " + super.getPieceColor() + "\nLigne : " + this.getLigne() + "\nColonne : " + this.getColonne();

		return st;
	}

}

