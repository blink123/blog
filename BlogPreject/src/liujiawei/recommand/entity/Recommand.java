package liujiawei.recommand.entity;

public class Recommand {
	private int number;
	private int articlenumber;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getArticlenumber() {
		return articlenumber;
	}

	public void setArticlenumber(int articlenumber) {
		this.articlenumber = articlenumber;
	}

	public Recommand() {		
	}
	
	public Recommand(int articlenumber) {
		this.articlenumber=articlenumber;
	}
	
	public Recommand(int number,int articlenumber) {
		this.articlenumber=articlenumber;
		this.number=number;
	}
	
}
