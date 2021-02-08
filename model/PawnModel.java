package model;


import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;

	}

	@Override
	public char getColonne() {
		char colonne = this.coord.getColonne();
		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = this.coord.getLigne();
		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;
		if (coord.getLigne()==this.getLigne() && coord.getColonne()==this.getColonne()) {
			
		}

		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = this.pieceColor;
		return color;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = "Color : " + this.pieceColor + "\nLigne : " + this.getLigne() + "\nColonne : " + this.getColonne();

		return st;
	}
	
	@Override
	public void move(Coord coord) {
	this.coord = coord;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		int coefColor = -1;
		if(Coord.coordonnees_valides(targetCoord)){
			if(this.pieceColor == PieceSquareColor.WHITE) {
				coefColor = 1;
			}
			if(isPieceToCapture) {
				coefColor *= 2;
			}
			if(targetCoord.getLigne() == this.getLigne() + coefColor && 
					(targetCoord.getColonne() == this.getColonne()+coefColor 
					|| targetCoord.getColonne() == this.getColonne()-coefColor)) {
				ret = true;
			}
		}

		return ret;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 

		// TODO Atelier 2

		return coordsOnItinery;
	}

	
}

