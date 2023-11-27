import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Interface
{
	private Depot[] depotArr;

	//Default Contructor
	public Interface(){
		// this.depot1 = new Depot();
		// this.depot2 = new Depot();
		this.depotArr = new Depot[4];
		for(int i = 0;i<4;i++){
			this.depotArr[i] = new Depot();
		}
	}

	private int printMenuandgetChoice(Scanner scannerObj){
		int choice = -1;
		while(choice<0 || choice>9){
			System.out.println("Menu");
			System.out.println("--------------");
			System.out.println("1.Add a depot");
			System.out.println("2.Remove a depot");
			System.out.println("3.Add a product to a depot");
			System.out.println("4.Remove an item of a product");
			System.out.println("5.Display list of depots");
			System.out.println("6.Display list of products of a specific depot");
			System.out.println("7.Check if a product exists in a depot");
			System.out.println("8.Cumulative value of all products in a depot");
			System.out.println("9.Export depot and product information to a text file");
			System.out.println("0.EXIT");
			System.out.print("\t\tCHOICE: ");	
			choice = scannerObj.nextInt();
		}
		return choice;
	}
	private void addDepot(Scanner scannerObj){
		
		System.out.print("\nDepot Name: ");
		String DName ="";
		if(scannerObj.hasNext())
			DName = scannerObj.next();
		DName = DName.toLowerCase();
		//System.out.println(this.depot1.getName());;
		if(DName.equals(this.depotArr[0].getName())){
			System.out.println("ERROR: depot with this name exists already!!!");
		} 
		else if(DName.equals(this.depotArr[1].getName())){
			System.out.println("ERROR: depot with this name exists already!!!");
		}
		else if(DName.equals(this.depotArr[2].getName())){
			System.out.println("ERROR: depot with this name exists already!!!");
		}
		else if(DName.equals(this.depotArr[3].getName())){
			System.out.println("ERROR: depot with this name exists already!!!");
		}
		else{
			if(this.depotArr[0].isEmpty()){
				this.depotArr[0].setName(DName);
				System.out.println("Depot added succesfully");
			}
			else if(this.depotArr[1].isEmpty()){
				this.depotArr[1].setName(DName);
				System.out.println("Depot added succesfully");
			}
			else if(this.depotArr[2].isEmpty()){
				this.depotArr[2].setName(DName);
				System.out.println("Depot added succesfully");
			}
			else if(this.depotArr[3].isEmpty()){
				this.depotArr[3].setName(DName);
				System.out.println("Depot added succesfully");
			}
			else{
				System.out.println("ERROR: All of the slots are filled. please delete a depot to add a new one");
			}
		}

	}

	private void removeDepot(Scanner scannerObj){
		if(this.depotArr[0].isEmpty() && this.depotArr[1].isEmpty() && this.depotArr[2].isEmpty() && this.depotArr[3].isEmpty()){
			System.out.println("\nNo depot to delete as all depots are empty\n");
			return;
		}
		System.out.print("\nDepot Name: ");
		String DName ="";
		if(scannerObj.hasNext())
			DName = scannerObj.next();
		DName = DName.toLowerCase();

		if(DName.equals(this.depotArr[0].getName())){
			this.depotArr[0].delete();
			System.out.println("\nDepot deleted Succesfully!\n");
		}
		else if(DName.equals(this.depotArr[1].getName())){
			this.depotArr[1].delete();
			System.out.println("\nDepot deleted Succesfully!\n");
		}
		else if(DName.equals(this.depotArr[2].getName())){
			this.depotArr[2].delete();
			System.out.println("\nDepot deleted Succesfully!\n");
		}
		else if(DName.equals(this.depotArr[3].getName())){
			this.depotArr[3].delete();
			System.out.println("\nDepot deleted Succesfully!\n");
		}
		else{
			System.out.println("\nERROR: There is no depot with such name\n");
		}
		
	}

	private boolean isDepotPresent(String Dname){
		if(Dname.equals(this.depotArr[0].getName()) || Dname.equals(this.depotArr[1].getName()) || Dname.equals(this.depotArr[2].getName()) || Dname.equals(this.depotArr[3].getName())){
			return true;
		}
		return false;
	}

	private void addProduct(Scanner scannerObj){
		System.out.print("\nDepot Name: ");
		String DName ="";
		if(scannerObj.hasNext())
			DName = scannerObj.next();
		DName = DName.toLowerCase();
		if(!this.isDepotPresent(DName)){
			System.out.println("\nERROR: No depot exists with such name\n");
			return;
		}
		// if(DName.equals(this.depot1.getName())){
		// 	this.depot1.addProduct(scannerObj);
		// }
		// else{
		// 	this.depot2.addProduct(scannerObj);
		// }
		for(int i = 0;i<4;i++){
			if(DName.equals(this.depotArr[i].getName())){
				this.depotArr[i].addProduct(scannerObj);
				return;
			}
		}
	}

	private void removeOneProduct(Scanner scannerObj){
		System.out.print("\nDepot Name: ");
		String DName ="";
		if(scannerObj.hasNext())
			DName = scannerObj.next();
		DName = DName.toLowerCase();
		if(!this.isDepotPresent(DName)){
			System.out.println("\nERROR: No depot exists with such name\n");
			return;
		}
		System.out.print("\nProduct Name: ");
		String PName ="";
		if(scannerObj.hasNext())
			PName = scannerObj.next();
		PName = PName.toLowerCase();
		// if(DName.equals(this.depot1.getName())){
		// 	this.depot1.removeItem(PName);
		// }
		// else{
		// 	this.depot2.removeItem(PName);
		// }
		for(int i = 0;i<4;i++){
			if(DName.equals(this.depotArr[i].getName())){
				this.depotArr[i].removeItem(PName);
			}
		}
	}

	private void DisplayListOfDepots(){
		if(this.depotArr[0].isEmpty() && this.depotArr[1].isEmpty() && this.depotArr[2].isEmpty()&& this.depotArr[2].isEmpty() && this.depotArr[3].isEmpty()){
			System.out.println("\nNo depots exist\n");
			return;
		}
		// if(!this.depot1.isEmpty()){
		// 	System.out.printf("\nDepot "+this.depot1.getName()+" has "+this.depot1.numOfActiveProducts()+" products\n");
		// }
		// if(!this.depot2.isEmpty()){
		// 	System.out.printf("\nDepot "+this.depot2.getName()+" has "+this.depot2.numOfActiveProducts()+" products\n");
		// }
		for(int i = 0;i<4;i++){
			if(!this.depotArr[i].isEmpty()){
				System.out.printf("\nDepot "+this.depotArr[i].getName()+" has "+this.depotArr[i].numOfActiveProducts()+" products\n");
			}
		}
	}
	
	private void displayProductsOfSpecificDepot(Scanner scannerObj){
		System.out.print("\nDepot Name: ");
		String DName ="";
		if(scannerObj.hasNext())
			DName = scannerObj.next();
		DName = DName.toLowerCase();

		if(!isDepotPresent(DName)){
			System.out.println("This Depot Doesn't exist");
			return;
		}
		// if(DName.equals(this.depot1.getName())){
		// 	this.depot1.displayProducts();
		// }
		// else{
		// 	this.depot2.displayProducts();
		// }
		for(int i = 0;i<4;i++){
			if(DName.equals(this.depotArr[i].getName())){
				this.depotArr[i].displayProducts();
				break;
			}
		}
	}
	
	private void checkProductExistance(Scanner scannerObj){
		System.out.print("\nProduct Name: ");
		String PName ="";
		if(scannerObj.hasNext())
			PName = scannerObj.next();
		PName = PName.toLowerCase();

		if((this.depotArr[0].isProductpresent(PName) == -1)  &&  (this.depotArr[1].isProductpresent(PName) == -1) &&  (this.depotArr[2].isProductpresent(PName) == -1) &&  (this.depotArr[3].isProductpresent(PName) == -1)){
			System.out.println("This product does not exist in any depot");
		}
	}
	
	private void cumulativeValueOfDepot(Scanner scannerObj){
		System.out.print("\nDepot Name: ");
		String DName ="";
		if(scannerObj.hasNext())
			DName = scannerObj.next();
		DName = DName.toLowerCase();
		if(!this.isDepotPresent(DName)){
			System.out.println("\nERROR: No depot exists with such name\n");
			return;
		}
		// if(DName.equals(this.depot1.getName())){
		// 	this.depot1.displayCumulativeValue();
		// }
		// else{
		// 	this.depot2.displayCumulativeValue();
		// }
		for(int i = 0;i<4;i++){
			if(DName.equals(this.depotArr[i].getName())){
				this.depotArr[i].displayCumulativeValue();
				break;
			}
		}
	}


	private void printDepotsToFile(){
		try {
			FileWriter myWriter = new FileWriter("Depots.txt");
			//myWriter.write("Files in Java might be tricky, \nbut it is fun enough!");
			for(int i = 0;i<4;i++){
				if(!this.depotArr[i].isEmpty()){
					myWriter.write(this.depotArr[i].toString());
				}
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}

	public void run(){
		int choice = 0;
		boolean checc = true;
		Scanner scannerObj = new Scanner(System.in);
		while(checc){
			choice = printMenuandgetChoice(scannerObj);
			switch(choice){
				case 1:
					this.addDepot(scannerObj);
					break;
				case 2:
					this.removeDepot(scannerObj);
					break;
				case 3:
					addProduct(scannerObj);
					break;
				case 4:
					removeOneProduct(scannerObj);
					break;
				case 5:
					DisplayListOfDepots();
					break;
				case 6:
					displayProductsOfSpecificDepot(scannerObj);
					break;
				case 7:
					checkProductExistance(scannerObj);
					break;
				case 8:
					cumulativeValueOfDepot(scannerObj);
					break;
				case 9:
					printDepotsToFile();
					break;
				case 0:
					checc = false;
					break;
			}
		}

		scannerObj.close();
	}



	public static void main(String[] args) {
		Interface intFace = new Interface();
		intFace.run();
	}
}

