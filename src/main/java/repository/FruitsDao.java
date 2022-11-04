package repository;


import java.util.List;

import model.Fruits;

public interface FruitsDao {
	public Fruits selectFruit(String fruit_id);
	public List<Fruits> selectAllFruits();
	public void insertFruits(Fruits fruits);
	public boolean updateFruits(Fruits fruits);
	public boolean deleteFruit(String fruit_id);

}
