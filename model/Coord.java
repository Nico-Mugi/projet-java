package model;



/**
 * @author francoiseperrin
 *
 * Coordonn�es des PieceModel
 */
public class Coord implements Comparable<Coord>{
	
	private char colonne; 	// ['a'..'j']
	private int ligne;		// [10..1]
	static final int MAX = ModelConfig.LENGTH;	// 10

	public Coord(char colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}

	public char getColonne() {
		return colonne;
	}

	public int getLigne() {
		return ligne;
	}


	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}


	/**
	 * @param coord
	 * @return true si 'a' <= col < 'a'+MAX et 1 < lig <= MAX
	 */
	public static boolean coordonnees_valides(Coord coord){

		boolean ret = false;
		if (('a'<=coord.colonne)&&(coord.colonne<'a'+MAX)&&(1<coord.ligne)&&(coord.ligne<=MAX)) {
			ret=true;
		}
		return ret;
	}
	/**
	 * 
	 * @param coord
	 * @return true si l'objet courant est egal a coord
	 */
	public boolean equals(Coord coord) {
		if(this.ligne==coord.ligne && this.colonne==coord.colonne){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * La m�thode compareTo() indique comment comparer un objet � l'objet courant
	 * selon l'ordre dit naturel
	 * Dans cet application, nous d�cidons que l'ordre naturel est celui 
	 * correspondant au N� de la case d'un tableau 2D repr�sent� par la Coord
	 * ainsi le N� 1 correspond � la Coord ['a', 10], le N� 100 correspond � la Coord ['j', 1]  
	 */
	@Override
	public int compareTo(Coord o) {
		int ret = 999;
		if((this.ligne==o.ligne)&&(this.colonne==o.colonne)){
			ret=0;
		}else {
			int ligne = o.ligne-this.ligne;
			int colonne = o.colonne-this.colonne;
			ret=ligne*colonne;
			
		}
		return ret ;
	}

}
