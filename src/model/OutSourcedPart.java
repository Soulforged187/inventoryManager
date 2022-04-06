package model;
// logical model for parts built out of house.
public class OutSourcedPart extends Part {
    private String companyName;
// constructor for parts built out of house
    public OutSourcedPart (int id, String name, double price, int stock, int min, int max, String companyName){
        super(id,name,price,stock,min,max);
        this.companyName=companyName;
    }
    //getters for companyName
    public String getCompanyName() {
        return companyName;
    }
    //setters for CompanyName
    public void setCompanyName(String companyName){
        this.companyName=companyName;


    }
}

