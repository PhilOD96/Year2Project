package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Product extends Model{

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Category> categories = new ArrayList<Category>();

    //@OneToOne(mappedBy="product")
    //public OrderItem item = new OrderItem();
    
    // List of category ids - this will be bound to checkboxes in the view form
    private List<Long> catSelect = new ArrayList<Long>();

    @Id
private Long productID;
@Constraints.Required
private String product_Name;
@Constraints.Required
private String category;
@Constraints.Required
private double product_price;
@Constraints.Required
private String manufacturer;
@Constraints.Required
private int quantity;


    // Default constructor
    public  Product() {
    }
    //constructor
public Product(Long productID, String product_Name,String category,double product_price,String manufacturer,
int quantity){


    this.productID = productID;
    this.product_Name = product_Name;
    this.category = category;
    this.product_price = product_price;
    this.manufacturer = manufacturer;
    this.quantity = quantity;
}


	
	//Generic query helper for entity Computer with id Long
    public static Finder<Long,Product> find = new Finder<Long,Product>(Product.class);

    // Find all Products in the database
    // Filter product name 
       public static List<Product> findAll1() {
        return Product.find.all();
    }
    public static List<Product> findAll(String filter) {
        return Product.find.where()
                        // name like filter value (surrounded by wildcards)
                        .ilike("name", "%" + filter + "%")
                        .orderBy("name asc")
                        .findList();
    }
    
    // Find all Products for a category
    // Filter product name 
    public static List<Product> findFilter(Long catID, String filter) {
        return Product.find.where()
                        // Only include products from the matching cat ID
                        // In this case search the ManyToMany relation
                        .eq("categories.id", catID)
                        // name like filter value (surrounded by wildcards)
                        .ilike("name", "%" + filter + "%")
                        .orderBy("name asc")
                        .findList();
    }


public void setQuantity(int quantity){
    this.quantity = quantity;
}
public void setManufacturer(String manufacturer){
  this.manufacturer = manufacturer;
}
public void setPrice(double product_price){
   this.product_price = product_price;
}
public void setCategory(String category){
 this.category = category;

}
public Long getProduct_id(){
    return productID;
}
public String getProduct_name(){
    return product_Name;
}
public String getCategory(){
    return category;
}
public double getPrice(){
    return product_price;
}
public String getManufacturer(){
    return manufacturer;
}
public int getQuantity(){
    return quantity;
}
public void setProduct_id(Long productID){
     this.productID = productID;

}
public void setProduct_name(String product_Name){
      this.product_Name = product_Name;

}


}