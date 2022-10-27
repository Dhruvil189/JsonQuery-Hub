package model;



public class Fruits {
	




	



	
	public Fruits(String genus, String name, String fruit_id, String family, String order_name, String carbohydrates,
			String protein, String fat,String calories,String sugar) {
		super();
		this.genus = genus;
		this.name = name;
		this.fruit_id = fruit_id;
		this.family = family;
		this.order_name = order_name;
		this.carbohydrates = carbohydrates;
		this.protein = protein;
		this.fat = fat;
		this.calories = calories;
		this.sugar = sugar;
	}




	
	public Fruits() {
		// TODO Auto-generated constructor stub
	}





	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFruit_id() {
		return fruit_id;
	}
	public void setFruit_id(String fruit_id) {
		this.fruit_id = fruit_id;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getCarbohydrates() {
		return carbohydrates;
	}
	public void setCarbohydrates(String carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}

	
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}



	private String genus;
	private String name;
	private String fruit_id;
	private String family;
	private String order_name;
	private String carbohydrates;
	private String protein;
	private String fat;
	
	private String calories;




	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}




	private String sugar;
	





	
	
	
	
}
