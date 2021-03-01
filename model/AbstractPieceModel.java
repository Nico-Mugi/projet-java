package model;

import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public abstract class AbstractPieceModel implements PieceModel {

	private Coord coord;
	private PieceSquareColor pieceColor;
	
	public AbstractPieceModel(Coord coord, PieceSquareColor pieceColor) {
		this.coord=coord;
		this.pieceColor=pieceColor;
	}
	@Override
	public char getColonne() {
		char colonne = coord.getColonne();
		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = coord.getLigne();
		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;
		if (coord.getLigne() == getLigne() && coord.getColonne() == getColonne()) {
			hasThisCoord = true;
		}

		return hasThisCoord;
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord;

	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = pieceColor;
		return color;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {
		List<Coord> coordsOnItinery = new LinkedList<Coord>();
		Coord coordOnItinery = null;
		int coefColor = coefColor(targetCoord);
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
		if (coord.getColonne()>targetCoord.getColonne()) {
			coefDirection = -1;
		}
		return coefDirection;
	}

	/**
	 * Return 1 if the pawn is going up (white pawn) and -1 going down( black pawn)
	 * 
	 * @return int
	 */
	public int coefColor(Coord targetCoord) {
		int coefColor = -1;
		if (this.pieceColor == PieceSquareColor.WHITE) {
			coefColor = 1;
		}
		return coefColor;
	}
	
	@Override
	public abstract boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture);

}
