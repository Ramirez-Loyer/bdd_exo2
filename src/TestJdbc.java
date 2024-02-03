import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;

public class TestJdbc {



	public static void main(String[] args) throws Exception  {
		
		ArticleDao articleDao =  new ArticleDao();
		
	
		
		ArrayList<Article> articles = new ArrayList<Article>();

		/*
		 * createArticle(new Article("MacBookPro", "Apple", 5000)); updateArticle(15,
		 * "Apple Watch", "Apple", 200); deleteArticle(5);
		 */
		
		Article article = new Article ("Smartphone", "Sony", 399);
		
		//articleDao.create(article);
		System.out.println(articleDao.read(3));

		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); //enregistre la class auprès du driver manager, autrement dit : charge le pilote
		}

		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}


		//récuperer une connection à partir d'une url + id + pwd
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";

		try(Connection connection = DriverManager.getConnection(url,login, password)){ //Connection de java.sql
			String strSql="SELECT * FROM T_Articles";    //Une fois connecté, réalisation d'un requête
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(strSql)){ //ResultSet de java.sql
					while(resultSet.next()) {
						int rsIdUser = resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsMarque = resultSet.getString(3);
						double rsPrixUnitaire = resultSet.getDouble(4);
						articles.add((new Article(rsIdUser, rsDescription, rsMarque, rsPrixUnitaire)));

					}//fin while	
				}
			}

			for(Article a: articles)
				System.out.println(a.getIdentifiant() + "-" + a.getDescription()+ "-" + a.getBrand() + "-" + a.getPrice());
		}//fin try1

	} // fin main 

	
	
	
	
	//METHODE : requête d’insertion d’un article	  //preparedStatemnt -> évite les attaques par injection sql

	public static void createArticle (Article obj) {       
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES(?,?,?)";
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";
		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			try (PreparedStatement ps = connection.prepareStatement(str)){

				ps.setString(1,  obj.getDescription());
				ps.setString(2,  obj.getBrand());
				ps.setDouble(3,  obj.getPrice());
				if(ps.executeUpdate() ==1)
					System.out.println("insertion ok");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	// METHODE : mise à jour

	public static void updateArticle(int idArticle, String description, String brand, double price) {
		String str = "UPDATE T_Articles set description=?, brand=?, UnitaryPrice=? where idArticle=?;";
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";

		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			try (PreparedStatement ps = connection.prepareStatement(str)){

				
				ps.setString(1, description); 
				ps.setString(2, brand);
				ps.setDouble(3,  price);
				ps.setInt(4,  idArticle);
				
				
				if(ps.executeUpdate() ==1)
					System.out.println("mise à jour ok");}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //fin updateArticle	
	
	
	//METHODE : supprimer un article
	public static void deleteArticle(int idArticle) {
		String str = "DELETE from t_articles where IdArticle=?";
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";
		
		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			try (PreparedStatement ps = connection.prepareStatement(str)){

			
				ps.setInt(1, idArticle);
				
				
				if(ps.executeUpdate() ==1)
					System.out.println("mise à jour ok");}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //fin Article	


	//METHODE : qui renvoie toutes les infos d'un article
	
	public static void renvoieInfos(int idArticle) {
		String str = "select * from t_articles where idArticle=?;";
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";
		
		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			try (PreparedStatement ps = connection.prepareStatement(str)){

			
				ps.setInt(1, idArticle);
				
				
				if(ps.executeUpdate() ==1)
					System.out.println("mise à jour ok");}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	}










