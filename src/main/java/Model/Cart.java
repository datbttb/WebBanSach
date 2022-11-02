package Model;

import java.util.List;

public class Cart {
	private Account account;
	private List<CartItem> items;
	public Cart() {
		super();
	}
	
	
	public Cart(Account account, List<CartItem> items) {
		super();
		this.account = account;
		this.items = items;
	}

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	public long tongTien() {
		long s=0;
		for (CartItem ci1:items) {
			s+=ci1.tongTien();
		}
		return s;
	}
	
	public long vat() {
		long v=tongTien()/10;
		return v;
	}
	
	public long thanhTien() {
		long tt=vat()+tongTien();
		return tt;
	}
}
