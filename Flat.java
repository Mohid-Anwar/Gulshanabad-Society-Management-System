public class Flat extends Plot implements Taxable{
    private int price;

    public Flat (){
        //Default Argument Constructor
        super();
    }

    public Flat (String owner, int size, Address myAddress, int price){
        //Argumented Constructor
        super(owner, size, myAddress);
        if(price > 0){
            this.price = price;
        }
    }
   
    //Setter
    public void setPrice(int price){
        if(price > 0){
            this.price = price;
        }
    }


    //Getters
	public int getPrice(){
		return price;
	}

    public int getTaxAmount(){
        return (price*5)/100;
    }


    public String toString(){
        String text = super.toString() + "\nPrice: " + price + "\nTax Amount: " + getTaxAmount() + "\n\n" ;
        return text;
    }
}