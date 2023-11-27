import java.util.Scanner;

public class Depot
{
	private String name;
	private Product product1, product2, product3;
	
	//Default Constructor
	public Depot(){
		this.name = "";
		this.product1 = new Product();
		this.product2 = new Product();
		this.product3 = new Product();
	}

	// Parameterized Constructor
	public Depot(String Name){
		this.name = Name;
		this.product1 = new Product();
		this.product2 = new Product();
		this.product3 = new Product();
	}

	//return the name of the depot
	public String getName(){
		return this.name;
	}

	//setter
	public void setName(String Name){
		this.name = Name;
	}

	public int isProductpresent(String PName){
		if(PName.equals(this.product1.getName())){
			System.out.printf("\nProduct "+this.product1.getName()+" is in depot "+this.name+" with quantity "+this.product1.getQuantity()+"\n");
			return 1;
		}
		else if(PName.equals(this.product2.getName())){
			System.out.printf("\nProduct "+this.product2.getName()+" is in depot "+this.name+" with quantity "+this.product2.getQuantity()+"\n");
			return 2;
		}
		else if(PName.equals(this.product3.getName())){
			System.out.printf("\nProduct "+this.product3.getName()+" is in depot "+this.name+" with quantity "+this.product3.getQuantity()+"\n");
			return 3;
		}
		return -1;
	}

	private int isProductExist(String PName){
		if(PName.equals(this.product1.getName())){
			return 1;
		}
		else if(PName.equals(this.product2.getName())){
			return 2;
		}
		else if(PName.equals(this.product3.getName())){
			return 3;
		}
		return -1;
	}

	public void addProduct(Scanner scannerObj){
		if(!(this.product1.isEmpty()) && !(this.product2.isEmpty())&&!(this.product3.isEmpty())){
			System.out.println("\nYou cannon add anymore products!\n");
			return;
		}
		System.out.print("\nProduct Name: ");
		String PName ="";
		if(scannerObj.hasNext())
			PName = scannerObj.next();
		PName = PName.toLowerCase();

		int checc = isProductExist(PName);
		if(checc != -1){
			if(checc == 1){
				System.out.printf("Product "+this.product1.getName()+" exists, with price $"+this.product1.getPrice()+" and weight "+this.product1.getWeight()+". Adding additional items." );
				int quantity = 0;
				while(quantity<=0){
					System.out.println("Please enter a quantity value to you want to add");
					if(scannerObj.hasNext())
						quantity = scannerObj.nextInt();
					if(quantity<=0)
						System.out.println("\nEROR: Enter a positive value\n");
				}
				this.product1.setQuantity(this.product1.getQuantity()+quantity);
				System.out.printf("New Quantity: "+this.product1.getQuantity()+"\n");
			}
			else if(checc == 2){
				System.out.printf("Product "+this.product2.getName()+" exists, with price $"+this.product2.getPrice()+" and weight "+this.product2.getWeight()+". Adding additional items." );
				int quantity = 0;
				while(quantity<=0){
					if(scannerObj.hasNext())
						quantity = scannerObj.nextInt();
					if(quantity<=0)
						System.out.println("\nEROR: Enter a positive value\n");
				}
				this.product2.setQuantity(this.product2.getQuantity()+quantity);
				System.out.printf("New Quantity: "+this.product2.getQuantity()+"\n");
			}
			else{
				System.out.printf("Product "+this.product3.getName()+" exists, with price $"+this.product3.getPrice()+" and weight "+this.product3.getWeight()+". Adding additional items." );
				int quantity = 0;
				while(quantity<=0){
					if(scannerObj.hasNext())
						quantity = scannerObj.nextInt();
					if(quantity<=0)
						System.out.println("\nEROR: Enter a positive value\n");
				}
				this.product3.setQuantity(this.product3.getQuantity()+quantity);
				System.out.printf("New Quantity: "+this.product3.getQuantity()+"\n");
			}
		}
		else{
			double pricee = 0;
			while(pricee<=0){
				System.out.println("Please enter the price of the product");
				if(scannerObj.hasNext())
					pricee = scannerObj.nextInt();
				if(pricee<=0)
					System.out.println("\nEROR: Enter a positive value\n");
			}
			double weightt = 0;
			while(weightt<=0){
				System.out.println("Please enter the weight of the product");
				if(scannerObj.hasNext())
					weightt = scannerObj.nextInt();
				if(weightt<=0)
					System.out.println("\nEROR: Enter a positive value\n");
			}
			int quantity = 0;
			while(quantity<=0){
				System.out.println("Please enter a quantity value to you want to add");
				if(scannerObj.hasNext())
					quantity = scannerObj.nextInt();
				if(quantity<=0)
					System.out.println("\nEROR: Enter a positive value\n");
			}
			if(this.product1.isEmpty()){
				this.product1.setName(PName);
				this.product1.setPrice(pricee);
				this.product1.setWeight(weightt);
				this.product1.setQuantity(quantity);
			}
			else if(this.product2.isEmpty()){
				this.product2.setName(PName);
				this.product2.setPrice(pricee);
				this.product2.setWeight(weightt);
				this.product2.setQuantity(quantity);
			}
			else{
				this.product3.setName(PName);
				this.product3.setPrice(pricee);
				this.product3.setWeight(weightt);
				this.product3.setQuantity(quantity);
			}
		}
	}

	public void removeItem(String PName){
		int checc = isProductExist(PName);
		if(checc == -1){
			System.out.println("This product dosen't exist in this depot");
			return;
		}
		else if(checc == 1){
			this.product1.setQuantity(this.product1.getQuantity() - 1);
			System.out.printf("\nOne item of Product " + this.product1.getName()+ " removed from depot "+this.name+"\n");
			if(this.product1.getQuantity()<=0){
				System.out.printf("\nOne Product " + this.product1.getName()+ " removed from depot "+this.name+"\n");
				this.product1.delete();
			}
		}
		else if(checc == 2){
			this.product2.setQuantity(this.product2.getQuantity() - 1);
			System.out.printf("\nOne item of Product " + this.product2.getName()+ " removed from depot "+this.name+"\n");
			if(this.product2.getQuantity()<=0){
				System.out.printf("\nOne Product " + this.product1.getName()+ " removed from depot "+this.name+"\n");
				this.product2.delete();
			}
		}
		else{
			this.product3.setQuantity(this.product3.getQuantity() - 1);
			System.out.printf("\nOne item of Product " + this.product3.getName()+ " removed from depot "+this.name+"\n");
			if(this.product3.getQuantity()<=0){
				System.out.printf("\nOne Product " + this.product3.getName()+ " removed from depot "+this.name+"\n");
				this.product3.delete();
			}
		}
	}
	
	public int numOfActiveProducts(){
		int cnt = 0;

		if(!this.product1.isEmpty())
			cnt++;
		if(!this.product2.isEmpty())
			cnt++;
		if(!this.product3.isEmpty())
			cnt++;
		return cnt;
	}
	
	public void displayProducts(){
		if(this.product1.isEmpty() && this.product2.isEmpty() && this.product3.isEmpty()){
			System.out.println("No products in depot");
		}

		if(!this.product1.isEmpty()){
			System.out.printf("\nProduct "+this.product1.getName()+" has price $"+this.product1.getPrice()+", weight "+this.product1.getWeight()+"kg, and quantity "+this.product1.getQuantity()+"\n");
		}
		if(!this.product2.isEmpty()){
			System.out.printf("\nProduct "+this.product2.getName()+" has price $"+this.product2.getPrice()+", weight "+this.product2.getWeight()+"kg, and quantity "+this.product2.getQuantity()+"\n");
		}
		if(!this.product3.isEmpty()){
			System.out.printf("\nProduct "+this.product3.getName()+" has price $"+this.product3.getPrice()+", weight "+this.product3.getWeight()+"kg, and quantity "+this.product3.getQuantity()+"\n");
		}
	}
	
	public boolean isEmpty(){
		if(this.name.equals("")){
			return true;
		}
		return false;
	}

	public void displayCumulativeValue(){
		double value = 0;
		if(!this.product1.isEmpty()){
			value += (this.product1.getPrice() * this.product1.getQuantity());
		}
		if(!this.product2.isEmpty()){
			value += (this.product2.getPrice() * this.product2.getQuantity());
		}
		if(!this.product3.isEmpty()){
			value += (this.product3.getPrice() * this.product3.getQuantity());
		}
		System.out.printf("\nDepot "+this.name+" has cumulative product value $"+value+"\n");
	}


	//DeleteDepot
	public void delete(){
		this.name = "";
		this.product1.delete();
		this.product2.delete();
		this.product3.delete();
	}
	//add other methods
}
