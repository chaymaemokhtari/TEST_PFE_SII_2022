package sii.maroc;

import java.util.ArrayList;
import java.util.List;

public class Ticket {


	private List<String> orders = new ArrayList<>();

	Ticket(String order){
		this.orders.add(order);
	}

	public Ticket and(String s) {
		orders.add(s);
		return this;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

}
