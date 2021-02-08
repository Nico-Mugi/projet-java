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
	public Coord getCoord() {
		return this.coord;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		if(coord.equals(this.getCoord()))
			return true;
		return false;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return this.pieceColor;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "["+this.getPieceColor().toString().substring(0, 1)+"["+this.getLigne()+","+this.getColonne()+"]]";
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		int a = isPieceToCapture? 2 : 1;
		if(PieceSquareColor.BLACK == this.getPieceColor())
			a *= -1;
		if((targetCoord.getColonne() - this.getColonne()) == a) {
			if((targetCoord.getLigne() - this.getLigne()) == a) {
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

