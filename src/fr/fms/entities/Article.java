package fr.fms.entities;


public class Article {
	
	//atributts
	public int idArticle;
	public String description;
	public String brand;
	public double price;
	
	//contructor
		public Article(String description, String brand, double price) {
			
			this.description = description;
			this.brand = brand;
			this.price = price;
		}
	
	//contructor
	public Article(int idArticle, String description, String brand, double price) {
		
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	//getters & setters
	public int getIdentifiant() {
		return idArticle;
	}


	public void setIdentifiant(int idArticle) {
		this.idArticle = idArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	} 
	

//toString

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand + ", price="
				+ price + "]";
	}

	
	
	
}





	