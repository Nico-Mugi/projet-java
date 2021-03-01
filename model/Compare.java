package model;

import java.util.Comparator;

public class Compare implements Comparator<PieceModel> {

	@Override
	public int compare(PieceModel pieceModel, PieceModel piece) {
		Coord coord1 = new Coord(pieceModel.getColonne(),pieceModel.getLigne());
		Coord coord2 = new Coord(piece.getColonne(),piece.getLigne());
		return coord1.compareTo(coord2);
	}
	

}
