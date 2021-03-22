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
		int a = (isPieceToCapture ? 2 : 1)*coefVertical();		
		if((targetCoord.getColonne() - this.getColonne()) == a) {
			if((targetCoord.getLigne() - this.getLigne()) == a) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>();
		int coefVertical = coefVertical();
		int coefHorizontal = coefHorizontal(targetCoord);
		int ligne = this.getLigne();
		char colonne = (char) (this.getColonne());
		Coord coordOnItinery = new Coord(colonne, ligne);
		while (!(targetCoord.equals(coordOnItinery))) {
			ligne += coefVertical;
			colonne = (char) (colonne + coefHorizontal);
			coordsOnItinery.add(new Coord(colonne, ligne));
		}
		return coordsOnItinery;
	}

	private int coefHorizontal(Coord targetCoord) {
		return targetCoord.getColonne()-coord.getColonne() > 0 ? 1 : -1;
	}

	private int coefVertical() {
		return this.getPieceColor() == PieceSquareColor.WHITE ? 1 : -1;
	}
}

