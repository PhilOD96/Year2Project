package controllers;


import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

import models.users.*;

public class AccountController extends Controller {

    private FormFactory formFactory;
    private Environment env;

    @Inject
    public AccountController(Environment e, FormFactory f){
        this.env = env;
        this.formFactory = f;
    }


    public Result login() {

        Form<Login> loginForm = formFactory.form(Login.class);

        return ok(login.render(loginForm, User.getUserById(session().get("email"))));
    }

    public Result loginSubmit() {

        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm, User.getUserById(session().get("email"))));
        }
        else {

            session().clear();

            session("email", loginForm.get().getEmail());

        }

        return redirect(controllers.routes.HomeController.index());

    }

    public Result logout(){

        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.AccountController.login());

    }


    public Result signUp(){

    Form<SignUp> signUpForm = formFactory.form(SignUp.class);

    return ok(signUp.render(signUpForm, User.getUserById(session().get("email"))));

    }

    public Result signUpSubmit() {

        Form<SignUp> signUpForm = formFactory.form(SignUp.class).bindFromRequest();

        if (signUpForm.hasErrors()) {
            return badRequest(signUp.render(signUpForm, User.getUserById(session().get("email"))));
        }
        else {

            session().clear();

            session("email", signUpForm.get().getEmail());

        }

        return redirect(controllers.routes.HomeController.index());

    }


}
