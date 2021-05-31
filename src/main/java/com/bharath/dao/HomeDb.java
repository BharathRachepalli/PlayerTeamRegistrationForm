package com.bharath.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bharath.entity.Player;


public class HomeDb {
	
	DataSource dataSource;
	public HomeDb(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void addPlayer(Player player) {
		Connection con = null;
		PreparedStatement stmt= null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into player(id,name,age,gender,player_team) values (?,?,?,?,?);";
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, player.getId());
			stmt.setString(2, player.getName());
			stmt.setInt(3, player.getAge());
			stmt.setString(4, player.getGender());
			stmt.setString(5, player.getPlayerTeam());
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con,stmt,null);
		}
	}

	public List<Player> getPlayer() throws SQLException {
		List<Player> playerList = new ArrayList<Player>();
		Connection con = null;
		Statement stmt= null;
		ResultSet res = null;
		try {
			con = dataSource.getConnection();
			
			String sql = "select * from player";
			
			stmt = con.createStatement();
			
			res = stmt.executeQuery(sql);
			
			while (res.next()) {
				Player obj = new Player();
				obj.setId(res.getInt("id"));
				obj.setName(res.getString("name"));
				obj.setAge(res.getInt("age"));
				obj.setGender(res.getString("gender"));
				obj.setPlayerTeam(res.getString("player_team"));
				
				playerList.add(obj);
			}
			
			return playerList;
		} 
		finally {
			close(con,stmt,res);
		}
		
		
		
	}

}
