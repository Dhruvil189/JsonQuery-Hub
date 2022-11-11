package other_modules;

public final class Constants {
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/app";
	public static final  String USERNAME = "root";
	public static final  String PASSWORD = "Sql@1234#";
	public static final  String INSERT_FRUITS = "INSERT INTO fruits"+ "  (genus, name, fruit_id , family, order_name, carbohydrates, protein, fat,calories, sugar) VALUES "+ "(?,?,?,?,?,?,?,?,?,?);";
	public static final  String SELECT_FRUITS_BY_ID = "select genus, name, fruit_id,family,order_name,carbohydrates,protein,fat,calories,sugar from fruits where fruit_id =?";
	public static final  String SELECT_ALL_FRUITS = "select genus, name, fruit_id,family,order_name,carbohydrates,protein,fat,calories,sugar from fruits";
	public static final  String UPDATE_FRUITS = "update fruits set genus = ?,name= ?,family=?,order_name=?,carbohydrates=?,protein=?,fat=?,calories=?,sugar=? where fruit_id = ?";
	public static final  String DELETE_FRUITS = "delete from fruits where fruit_id = ?;";

}
