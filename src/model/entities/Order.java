package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.OrderStatus;

public class Order {
	
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total = 0.0;
		for (OrderItem orderItem : items) {
			total += orderItem.subtotal();
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order status: "+ status.toString());
		sb.append("\nOrder moment: " + sdf2.format(moment));
		sb.append("\n" + client);
		sb.append("\nOrder items: \n");
		for (OrderItem orderItem : items) {
			sb.append(orderItem);
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
	
	

	
	

}
