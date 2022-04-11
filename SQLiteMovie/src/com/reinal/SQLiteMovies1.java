package com.reinal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteMovies1 {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:C:\\sqlite\\db\\movies.db";
		try {
			Connection connection = DriverManager.getConnection(url);
			String sql = "SELECT * FROM movies";
            
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				String mov_name = result.getString("mov_name");
				String actor = result.getString("actor");
				String actress = result.getString("actress");
				String director = result.getString("director");
				String release_year = result.getString("release_year");
				
				System.out.println(mov_name +" | "+actor+" | "+actress+" | "+director+" | "+release_year);
			}

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }
	}

}
