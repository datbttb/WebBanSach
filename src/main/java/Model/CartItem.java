package Model;

public class CartItem {
	private Sach sach;
	private int amount;
	public CartItem() {
		super();
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public long tongTien() {
		long s=sach.getPrice()*amount;
		return s;
	}
		
}
