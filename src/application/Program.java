package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		System.out.print("How many item to this order? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i ++) {
			System.out.printf("%nEnter #%s item data: %n", i+1);
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));
	
		}
		
		System.out.println(order);
		
		sc.close();
		
		

	}

}
