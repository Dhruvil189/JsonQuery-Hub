package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.lang.String;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fruits;

import other_modules.FruitsFactory;
import repository.FruitsDao;
import repository.FruitsDaoImpl;

@WebServlet("/")
public class FruitsController extends HttpServlet {
	 private FruitsDao fruitsDao;

	public void init() {
		 FruitsFactory factoryPattern=new FruitsFactory();
		 fruitsDao=factoryPattern.getInstance("FruitsDaoImpl");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.lang.String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				fruitsData(request, response);
				break;

			case "/insert":

				insertFruits(request, response);
				break;

			case "/delete":
				deleteFruits(request, response);
				break;

			case "/edit":
				showEditForm(request, response);
				break;

			case "/update":

				updateFruits(request, response);
				break;

			default:
				listFruits(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void fruitsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Fruits.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String fruit_id = request.getParameter("fruit_id");
		Fruits existingFruits = fruitsDao.selectFruit(fruit_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Fruits.jsp");
		request.setAttribute("fruits", existingFruits);

		dispatcher.forward(request, response);

	}

	private void updateFruits(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String fruit_id = (request.getParameter("fruit_id"));
		String genus = request.getParameter("genus");
		String name = request.getParameter("name");
		String family = request.getParameter("family");
		String order_name = request.getParameter("order_name");
		String carbohydrates = request.getParameter("carbohydrates");
		String protein = request.getParameter("protein");
		String fat = request.getParameter("fat");
		String calories = request.getParameter("calories");
		String sugar = request.getParameter("sugar");
		Fruits newFruits = new Fruits(genus, name, fruit_id, family, order_name, carbohydrates, protein, fat, calories,sugar);
		System.out.println("Value updated" + fat);
		System.out.println("Value updated" + calories);
		fruitsDao.updateFruits(newFruits);
		response.sendRedirect("list");
	}

	private void listFruits(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		List<Fruits> listFruits = fruitsDao.selectAllFruits();

		request.setAttribute("listFruits", listFruits);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FruitList.jsp");
		dispatcher.forward(request, response);
	}

	private void insertFruits(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("Hello");
		String genus = request.getParameter("genus");
		String name = request.getParameter("name");
		String fruit_id = request.getParameter("fruit_id");
		String family = request.getParameter("family");
		String order_name = request.getParameter("order_name");
		String carbohydrates = request.getParameter("carbohydrates");
		String protein = request.getParameter("protein");
		String fat = request.getParameter("fat");
		String calories = request.getParameter("calories");
		String sugar = request.getParameter("sugar");
		System.out.println("Value inserted" + calories);

		Fruits newFruits = new Fruits(genus, name, fruit_id, family, order_name, carbohydrates, protein, fat, calories,sugar);
		fruitsDao.insertFruits(newFruits);
		response.sendRedirect("list");
	}

	private void deleteFruits(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String fruit_id = request.getParameter("fruit_id");
		fruitsDao.deleteFruit(fruit_id);
		response.sendRedirect("list");

	}
}
