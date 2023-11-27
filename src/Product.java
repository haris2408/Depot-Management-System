
public class Product
{
	private String name;
	private double price;
	private double weight;
	private int quantity;
	
	//Default Constructor
	public Product(){
		this.name = "";
		this.price = 0.0;
		this.weight = 0.0;
		this.quantity = 0;
		
	}

	// Parameterized Constructor
	public Product(String Name, Double Price,Double Weight, int Qunatity){
		this.name = Name;
		this.price = Price;
		this.weight = Weight;
		this.quantity = Qunatity;
	}

	//getters
	public String getName(){
		return this.name;
	}
	public Double getPrice(){
		return this.price;
	}
	public Double getWeight(){
		return this.weight;
	}
	public int getQuantity(){
		return this.quantity;
	}


	//setters
	public void setName(String Name){
		this.name = Name;
	}
	public void setPrice(Double Price){
		this.price = Price;
	}
	public void setWeight(Double Weight){
		this.weight = Weight;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	//to delete aur mark product as empty
	public void delete(){
		this.name = "";
		this.price = 0.0;
		this.weight = 0.0;
		this.quantity = 0;
	}

	//check if product is empty or not
	public boolean isEmpty(){
		if (this.name.equals("")){
			return true;
		}
		return false;
	}
	public String toString(){
		
		return ""+this.name+" "+this.price+" "+this.weight+" "+this.quantity;
	}
}
