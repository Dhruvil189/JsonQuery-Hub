package service;

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

public class TestFruits {

	
	//private FruitsService fs;
	@Mock
	private Fruits fruits;
	@Mock
	private DataSource ds;

   @Mock
   private Connection c;

   @Mock
   private PreparedStatement stmt;

	/*
	 * @Mock private ResultSet rs;
	 */

	/*
	 * @Spy // mock it partially
	 * 
	 * @InjectMocks
	 */
  
	/*
	 * @Mock private FruitsService fruitsService;
	 */
  // public List<Fruits> f;
   private FruitsService fs;
   
   @Test
  public void setUp() throws SQLException {
	  // ResultSet resultSet = Mockito.mock(ResultSet.class);
       Fruits fruits = new Fruits("dhruvilpo","ee","2","ss","dd","1.3","1.3","1.8","2.9","1.8");;
      // Mockito.when(resultSet.getString(1)).thenReturn(fruits.getGenus());
		/*
		 * this.fruits.setGenus("dhruvilpo"); this.fruits.setName("ee");
		 * this.fruits.setFruit_id("2"); this.fruits.setFamily("ss");
		 * this.fruits.setOrder_name("dd"); this.fruits.setCarbohydrates("1.3");
		 * this.fruits.setProtein("1.3"); this.fruits.setFat("1.8");
		 * this.fruits.setCalories("2.9"); this.fruits.setSugar("1.8");
		 * System.out.println("hello");
		 */
         // fruitsService.insertFruits(fruits);
        // Assert.assertEquals("dhruvilppo", fruits.getGenus());
      // System.out.println("hello");
   }

   @Test
   public void searchFruitsTest() {
	   
	   List<Fruits> f=new ArrayList<Fruits>();
       f.add(new Fruits ("dhruvilpo","ee","2","ss","dd","1.3","1.3","1.8","2.9","1.8"));
      // FruitsService fs=new FruitsService();
     //  FruitsService mock = org.mockito.Mockito.mock(FruitsService.class);
     //  when(mock.selectAllFruits()).thenReturn(f);

       Mockito.when(fs.selectAllFruits()).thenReturn(f);
      // Fruits userFromDb = dao.getUserByUsername("danielniko");
       assertEquals(1,1);
   }
   
}
