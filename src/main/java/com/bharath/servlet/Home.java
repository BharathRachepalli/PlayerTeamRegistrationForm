package com.bharath.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bharath.dao.HomeDb;
import com.bharath.entity.Player;
import com.bharath.service.impl.PlayerServiceImpl;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HomeDb homeDb;

	@Resource(name = "jdbc/demo")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {

		super.init();

		homeDb = new HomeDb(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "Login";
			}

			switch (theCommand) {
			case "AddPlayer":
				addPlayer(request, response);
			case "displayPlayer":
				displayPlayer(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void displayPlayer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Player> playerList = homeDb.getPlayer();
		
		new PlayerServiceImpl().SortByName(playerList);
		
		request.setAttribute("player_list", playerList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayPlayer.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addPlayer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String team = request.getParameter("team");

		Player player = new Player();
		player.setId(id);
		player.setName(name);
		player.setAge(age);
		player.setGender(gender);
		player.setPlayerTeam(team);

		homeDb.addPlayer(player);
		
		displayPlayer(request, response);
	}

}
