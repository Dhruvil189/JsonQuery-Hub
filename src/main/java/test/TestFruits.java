package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import model.Fruits;
import repository.FruitsDaoImpl;

public class TestFruits {

	@Test
	public void selectFruitById() throws SQLException {
	   FruitsDaoImpl fruitsDaoImpl=new FruitsDaoImpl();
	   Fruits fruits=fruitsDaoImpl.selectFruit("1");
	   assertNotEquals(fruits,null);
	   assertNotEquals(fruits.getFamily()," ");
   }
	   	   
	@Test
	public void selectAllFruits() throws SQLException {
 	   FruitsDaoImpl fruitsDaoImpl=new FruitsDaoImpl();
 	   List<Fruits> fruits =fruitsDaoImpl.selectAllFruits();
 	   assertNotEquals(fruits,null);
 	   assertTrue(fruits.size()>0);
    }
   
   @Test
   public void insertFruits() throws SQLException {
 	   Fruits fruits=new Fruits();
 	   fruits.setGenus("Citrus");
 	   fruits.setName("Tangerine");
 	   fruits.setFruit_id("77");
 	   fruits.setFamily("Rutaceae");
 	   fruits.setOrder_name("Sapindales");
 	   fruits.setCarbohydrates("8.3");
 	   fruits.setProtein("0");
 	   fruits.setFat("0.4");
 	   fruits.setSugar("45");
 	   fruits.setCalories("9.1");
 	   assertNotEquals(fruits,null);
 	 
    }
   
   @Test
   public void deleteFruit() throws SQLException {
 	   FruitsDaoImpl fruitsDaoImpl=new FruitsDaoImpl();
 	   Boolean value =fruitsDaoImpl.deleteFruit("85");
 	   Fruits fruits=fruitsDaoImpl.selectFruit("85");
 	   assertEquals(fruits,null);
 	}
  
   @Test
   public void updateFruits() throws SQLException {
 	   FruitsDaoImpl fruitsDaoImpl=new FruitsDaoImpl();
 	   Fruits fruits=fruitsDaoImpl.selectFruit("80");
 	   fruits.setGenus("Mango");
 	   Boolean var=fruitsDaoImpl.updateFruits(fruits);
 	   assertTrue(var);
 	   
    }
}
