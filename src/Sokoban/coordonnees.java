package Sokoban;

public class coordonnees {
	
	//attributs
	private int x = 0;
	private int y = 0;
	
	//méthodes
	public coordonnees() {
		x = 0;
		y = 0;
	}
	
	public coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	//A vérifier
	@Override
	public int hashCode() {
		return x+y;
	}

}
