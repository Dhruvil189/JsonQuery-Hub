package controller;
import repository.FruitsDao;
import repository.FruitsDaoImpl;

public class FactoryPattern {
	public FruitsDao getInstance(String str) {
		if (str.equals("FruitsDaoImpl")){
			
		}
		return new FruitsDaoImpl();
		
	}

}
