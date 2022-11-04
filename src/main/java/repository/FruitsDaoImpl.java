package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fruits;

public class FruitsDaoImpl implements FruitsDao{
	private String jdbcUrl = "jdbc:mysql://localhost:3306/app";
	private String username = "root";
	private String password = "Sql@1234#";

	private static final String INSERT_FRUITS = "INSERT INTO fruits"+ "  (genus, name, fruit_id , family, order_name, carbohydrates, protein, fat,calories, sugar) VALUES "+ "(?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_FRUITS_BY_ID = "select genus, name, fruit_id,family,order_name,carbohydrates,protein,fat,calories,sugar from fruits where fruit_id =?";
	private static final String SELECT_ALL_FRUITS = "select genus, name, fruit_id,family,order_name,carbohydrates,protein,fat,calories,sugar from fruits";
	private static final String UPDATE_FRUITS = "update fruits set genus = ?,name= ?,family=?,order_name=?,carbohydrates=?,protein=?,fat=?,calories=?,sugar=? where fruit_id = ?";
	private static final String DELETE_FRUITS = "delete from fruits where fruit_id = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	
	
	public Fruits selectFruit(String fruit_id) {
		Fruits fruits = null;
		
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FRUITS_BY_ID)) {
			preparedStatement.setString(1, fruit_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String genus = rs.getString("genus");
				String name = rs.getString("name");
				String fruitId = rs.getString("fruit_id");
				String family = rs.getString("family");
				String order_name = rs.getString("order_name");
				String carbohydrates = rs.getString("carbohydrates");
				String protein = rs.getString("protein");
				String fat = rs.getString("fat");
				String calories = rs.getString("calories");
				String sugar = rs.getString("sugar");

				fruits = new Fruits(genus, name, fruitId, family, order_name, carbohydrates, protein, fat, calories,sugar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fruits;
	}

	

	public List<Fruits> selectAllFruits() {

		List<Fruits> fruits = new ArrayList<>();

		try (Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FRUITS);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String genus = rs.getString("genus");
				String name = rs.getString("name");
				String fruit_id = rs.getString("fruit_id");
				String family = rs.getString("family");
				String order_name = rs.getString("order_name");
				String carbohydrates = rs.getString("carbohydrates");
				String protein = rs.getString("protein");
				String fat = rs.getString("fat");
				String calories = rs.getString("calories");
				String sugar = rs.getString("sugar");

				fruits.add(new Fruits(genus, name, fruit_id, family, order_name, carbohydrates, protein, fat, calories,
						sugar));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return fruits;
	}

	public boolean updateFruits(Fruits fruits) {
		boolean rowUpdated = false;

		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FRUITS);) {
			preparedStatement.setString(1, fruits.getGenus());
			preparedStatement.setString(2, fruits.getName());
			preparedStatement.setString(3, fruits.getFamily());
			preparedStatement.setString(4, fruits.getOrder_name());

			preparedStatement.setString(5, fruits.getCarbohydrates());
			preparedStatement.setString(6, fruits.getProtein());
			preparedStatement.setString(7, fruits.getFat());
			preparedStatement.setString(8, fruits.getCalories());
			preparedStatement.setString(9, fruits.getSugar());
			preparedStatement.setString(10, fruits.getFruit_id());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return rowUpdated;
		
	}


	@Override
	public void insertFruits(Fruits fruits) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FRUITS)) {
			preparedStatement.setString(1, fruits.getGenus());
			preparedStatement.setString(2, fruits.getName());
			preparedStatement.setString(3, fruits.getFruit_id());
			preparedStatement.setString(4, fruits.getFamily());
			preparedStatement.setString(5, fruits.getOrder_name());

			preparedStatement.setString(6, fruits.getCarbohydrates());
			preparedStatement.setString(7, fruits.getProtein());
			preparedStatement.setString(8, fruits.getFat());
			preparedStatement.setString(9, fruits.getCalories());
			preparedStatement.setString(10, fruits.getSugar());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public boolean deleteFruit(String fruit_id) {
		boolean rowDeleted = false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_FRUITS);) {
			statement.setString(1, fruit_id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return rowDeleted;
	}

}
