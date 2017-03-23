package controllers;
import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

// Import models
import models.*;
import models.users.*;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

      // Declare a private FormFactory instance
    private FormFactory formFactory;

    //  Inject an instance of FormFactory it into the controller via its constructor
    @Inject
    public HomeController(FormFactory f) {
        this.formFactory = f;
    }
    public Result index() {
        return ok(index.render(getUserFromSession()));
    }

    // public Result login() {
    //     return ok(login.render(getUserFromSession()));
    // }

    public Result listProducts() {

        List<Product> productsList = Product.findAll1();
        return ok(listProducts.render(productsList,getUserFromSession()));
    }

    public Result addProduct() {
        Form<Product> addProductForm = formFactory.form(Product.class);

        return ok(addProduct.render(addProductForm,getUserFromSession()));
    }

    public Result addProductSubmit() {

        Form<Product> newProductForm = formFactory.form(Product.class).bindFromRequest();

        if (newProductForm.hasErrors()) {
            return badRequest(addProduct.render(newProductForm,getUserFromSession()));
        }
        Product newProduct = newProductForm.get();
            // Save to the database via Ebean (remember Product extends Model)
        if(newProduct.getProduct_id() == null)
        {

            newProduct.save();
        }
        else if(newProduct.getProduct_id()!= null){

            newProduct.update();

        }

        newProduct.save();

        flash("success", "Product" + newProduct.getProduct_name() + "has been created");

        return redirect(controllers.routes.HomeController.listProducts() );
    }

    public Result signUp() {
        return ok(signUp.render(getUserFromSession()));
    }
      public Result categories() {
        return ok(categories.render(getUserFromSession()));
    }

    public Result book_1() {
        return ok(book_1.render(getUserFromSession()));
    }

  

    public Result book_2() {
        return ok(book_2.render(getUserFromSession()));
    }
       public Result book_3() {
        return ok(book_3.render(getUserFromSession()));
    }
     public Result display_all_books() {
        return ok(display_all_books.render(getUserFromSession()));
    }

    public Result game_1() {
        return ok(game_1.render(getUserFromSession()));
    }

    public Result game_2() {
        return ok(game_2.render(getUserFromSession()));
    }

    public Result game_3() {
        return ok(game_3.render(getUserFromSession()));
    }
     public Result mobiles_1() {
        return ok(mobiles_1.render(getUserFromSession()));
    }

 public Result mobiles_2() {
        return ok(mobiles_2.render(getUserFromSession()));
    }
     public Result mobiles_3() {
        return ok(mobiles_3.render(getUserFromSession()));
    }
    public Result instrument_1() {
        return ok(instrument_1.render(getUserFromSession()));
    }

    public Result instrument_2() {
        return ok(instrument_2.render(getUserFromSession()));
    }

    public Result instrument_3() {
        return ok(instrument_3.render(getUserFromSession()));
    }

 

    public Result electronics_1() {
        return ok(electronics_1.render(getUserFromSession()));
    }

    public Result electronics_2() {
        return ok(electronics_2.render(getUserFromSession()));
    }

    public Result electronics_3() {
        return ok(electronics_3.render(getUserFromSession()));
    }

   

    public Result display_all_products() {
        return ok(display_all_products.render(getUserFromSession()));
    }

    public Result feedback() {
        return ok(feedback.render(getUserFromSession()));
    }

    public Result request_product() {
        return ok(request_product.render(getUserFromSession()));
    }
     @Transactional
    public Result updateProduct(Long id){
        Product p;
        Form<Product> productForm;

        try {

            p = Product.find.byId(id);

            productForm = formFactory.form(Product.class).fill(p);

        }catch (Exception ex){
            return badRequest("error");

        }
        return ok(addProduct.render(productForm,getUserFromSession()));

    }
    // Delete Product by id
    public Result deleteProduct(Long id) {

        // find product by id and call delete method
        Product.find.ref(id).delete();
        // Add message to flash session
        flash("success", "Product has been deleted");

        // Redirect to products page
        return redirect(routes.HomeController.listProducts());
    }

       private User getUserFromSession() {
        return User.getUserById(session().get("email"));
    }

}
