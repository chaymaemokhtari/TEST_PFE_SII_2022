package sii.maroc;

import java.util.HashMap;
import java.util.Map;

public class Meal {

	private Map<String,Integer> servedDishes;

	public Meal(Map<String,Integer> servedDishes){
		 this.servedDishes = servedDishes;

	}

	public int servedDishes() {
		return servedDishes.get("Pizza")+ servedDishes.get("Tomato Mozzarella Salad");
	}

	public int cookingDuration() {
		int saladCookingDuration = 0;
		int pizzaCookingDuration = 0;
		
		if(servedDishes.get("Tomato Mozzarella Salad") == 1)
			saladCookingDuration = 6;
		if(servedDishes.get("Tomato Mozzarella Salad") > 1)
			saladCookingDuration =  (servedDishes.get("Tomato Mozzarella Salad") + 1) * 3;
			
        if(servedDishes.get("Pizza") == 1)
				saladCookingDuration = 10 + 10;
		
        if(servedDishes.get("Pizza") > 1)
				saladCookingDuration =  servedDishes.get("Tomato Mozzarella Salad") * 10 + 10;
		

		return saladCookingDuration + pizzaCookingDuration;
	}

	public Map<String, Integer> getServedDishes() {
		return servedDishes;
	}

	public void setServedDishes(Map<String, Integer> servedDishes) {
		this.servedDishes = servedDishes;
	}
}
