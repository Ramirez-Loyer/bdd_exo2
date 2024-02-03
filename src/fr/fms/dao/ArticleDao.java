package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	@Override
	public void create(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());

			ps.executeUpdate();
		} catch (SQLException e)  {
			e.printStackTrace();

		}

	}

	@Override
	public Article read(int id) {
		String str = "SELECT * FROM T_Articles WHERE idArticle = ?";
		try(PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if (rs.next()) {
					int rsidArticle = rs.getInt("IdArticle");
					String rsDescription = rs.getString("Description");
					String rsBrand = rs.getString("Brand");
					double rsPrice = rs.getDouble("UnitaryPrice");
					
					
					return new Article (rsidArticle, rsDescription, rsBrand, rsPrice);
			}
			
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
