package productservicepublisher;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ProductPublishImpl implements ProductPublish{
	
    Scanner userInput = new Scanner(System.in);
    char userAnswer;
    String product;
    float price;
    LinkedHashMap<String, Float> products = new LinkedHashMap<String, Float>();
  
	
	 
	 LinkedHashMap<String, Integer[]> Supplyments = new LinkedHashMap<String, Integer[]>();
	 Scanner input = new Scanner(System.in);
	
	
	@Override
	public char publishproduct() {		
		Scanner charInput = new Scanner (System.in);
		
		System.out.println();
		System.out.print("Add product: ");
		product =charInput.next();
		
		System.out.println();
		System.out.print("Selling price of the product (per unit) : ");
		price =charInput.nextFloat();
		
		products.put(product, price);
		
		System.out.println();
		System.out.print("Do you want to add more products: Enter Y if yes. Enter S if no.");
		userAnswer = charInput.next().charAt(0);
		
		if (userAnswer == 'Y' || userAnswer == 'y') {
			System.out.println();
			System.out.print("Add product: ");
			product =charInput.next();
			
			System.out.println();
			System.out.print("Selling price of the product: ");
			price =charInput.nextFloat();
			
			products.put(product, price);
			
			System.out.println();
			System.out.println("Do you want to add more products: Enter Y if yes. Enter S if no.");
			userAnswer = charInput.next().charAt(0);
			System.out.println();
			
			return userAnswer;
		}
		
		return userAnswer;

	}
	
	@Override
	public void viewlist() {		
		System.out.println();
		for (Entry<String, Float> entry : products.entrySet()) {
	        System.out.println("Product : " + entry.getKey() + " " + entry.getValue());
	    }
		System.out.println();
	}
	
	@Override
	public char addProducts() {
		List<LinkedHashMap<String, Float>> allProducts = new ArrayList();
		
		allProducts.add(products);
		
		System.out.println("Your products " + allProducts + " have been added successfully!");
		System.out.println();
		userAnswer = 'S';
		
		return userAnswer;
	}
	
	@Override
	public char deleteProducts() {
		System.out.println("Removing product: " + products);
		System.out.println();
		products.clear();
		
		userAnswer = 'S';
		
		return userAnswer;
	};
}

	