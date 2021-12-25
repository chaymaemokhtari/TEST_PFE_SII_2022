package sii.maroc;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

	private Map<String,String> stock;

	public Restaurant(String ... ingredients) {
		
		//stock initialization
		
		stock = new HashMap<>();

		for(String ingredient:ingredients){
			if (Character.isDigit(ingredient.charAt(0))
			) {
				String[] ingredientElements = ingredient.trim().split(" ",2);
				String ingredientName = ingredientElements[1];
				String quantity = ingredientElements[0];
				stock.put(ingredientName,quantity);
			}else{
				String quantity = "unlimited";
				stock.put(ingredient,quantity);
			}
		}
	}


	public Ticket order(String order) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket(order);
		return ticket;
	}

	public Meal retrieve(Ticket ticket) {
		// TODO Auto-generated method stub
		//get all the dishes from the ticket
		Map<String,Integer> dishes = getTicketDishes(ticket);

		Map<String,Integer> servedDishes = new HashMap<>();
		servedDishes.put("Pizza",0);
		servedDishes.put("Tomato Mozzarella Salad",0);

		while(dishes.get("Pizza") > 0){
			try {
				substractPizzaIngredients();
				servedDishes.put("Pizza", servedDishes.get("Pizza")+1);
				dishes.put("Pizza",dishes.get("Pizza")-1);
			}
			catch(UnavailableDishException e) {
				e.getMessage();
			}

		}

		while(dishes.get("Tomato Mozzarella Salad") > 0){
			substractSaladIngredients();
			servedDishes.put("Tomato Mozzarella Salad", servedDishes.get("Tomato Mozzarella Salad")+1);
			dishes.put("Tomato Mozzarella Salad",dishes.get("Tomato Mozzarella Salad")-1);
		}

		return new Meal(servedDishes);
	}

	public Map<String,Integer> getTicketDishes(Ticket ticket){
		Map<String,Integer> dishes = new HashMap<>();
		dishes.put("Pizza",0);
		dishes.put("Tomato Mozzarella Salad",0);

		for(String order: ticket.getOrders()){
			String dishName = order.split(" ",2)[1];
			int quantity = Integer.parseInt(order.split(" ",2)[0]);

			if(dishName.equals("Pizza")){
				dishes.put("Pizza",quantity + dishes.get("Pizza"));
			}
			if(dishName.equals("Tomato Mozzarella Salad")){
				dishes.put("Tomato Mozzarella Salad",quantity + dishes.get("Tomato Mozzarella Salad"));
			}
		}
		return dishes;
	}

	public void substractPizzaIngredients() throws UnavailableDishException {
		int tomatoqte = Integer.parseInt(stock.get("tomatoes"));
		int mozzarellaqte = Integer.parseInt(stock.get("balls Mozzarella"));

		if(tomatoqte >=2 && mozzarellaqte >=1) {
			stock.put("tomatoes", String.valueOf(tomatoqte - 2));
			stock.put("balls Mozzarella", String.valueOf(mozzarellaqte-1));
		}
		else {
			throw new UnavailableDishException("Insufficient Ingradients");
		}
	}

	private void substractSaladIngredients() {

	}

	public Map<String, String> getStock() {
		return stock;
	}

	public void setStock(Map<String, String> stock) {
		this.stock = stock;
	}



}
