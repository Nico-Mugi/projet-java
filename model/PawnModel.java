package model;

import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel {

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
		if (coord.getLigne() == this.getLigne() && coord.getColonne() == this.getColonne()) {
			hasThisCoord = true;
		}

		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = this.pieceColor;
		return color;
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/**
	 * return the itinerary with arrival
	 */
	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>();
		Coord coordOnItinery = null;
		int coefColor = coefColor();
		int coefDirection = coefDirection(targetCoord);
		int ligne = this.getLigne();
		char colonne = (char) (this.getColonne());
		coordOnItinery = new Coord(colonne, ligne);

		while (!(targetCoord.equals(coordOnItinery))) {
			ligne += coefColor;
			colonne = (char) (colonne + coefDirection);
			coordOnItinery = new Coord(colonne, ligne);
			coordsOnItinery.add(coordOnItinery);

		}

		return coordsOnItinery;
	}

	/**
	 * Return 1 if the pawn is going right and -1 going left
	 * 
	 * @param targetCoord
	 * @return int
	 */
	private int coefDirection(Coord targetCoord) {
		int coefDirection = 1;
		if (coord.compareTo(targetCoord) < 0) {
			coefDirection = -1;
		}
		return coefDirection;
	}

	/**
	 * Return 1 if the pawn is going up (white pawn) and -1 going down( black pawn)
	 * 
	 * @return int
	 */
	private int coefColor() {
		int coefColor = -1;
		if (this.pieceColor == PieceSquareColor.WHITE) {
			coefColor = 1;
		}
		return coefColor;
	}

}
