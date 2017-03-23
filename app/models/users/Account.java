package models.users;

/**
 * Created by wdd on 13/03/17.
 */
public class Login {

    //Login variables
    private String loginEmail;
    private String loginPassword;

    //Sign Up variables
    private String fName;
    private String lName;
    private String address;
    private String pNum;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean member;

    public String validate(){

        if(User.authenticate(getEmail(), getPassword()) == null){
            return "Invalid User or Password";
        }
        return null;

    }

    public String getLoginEmail(){
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail){
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword(){
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword){
        this.loginPassword = loginPassword;
    }

    //SignUp getters

    public String getFName(){
        return fName;
    }
    
    public String getLName(){
        return lName;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPNum(){
        return pNum;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getConfirmPassword(){
        return confirmPassword;
    }
    
    public boolean getMember(){
        return true;
    }

    //SignUp setters

    public void setFName(String fName){
        this.fName = fName;
    }

    public void setLName(String lName){
        this.lName = lName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPNum(String pNum){
        this.pNum = pNum;
    }
        
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }

    public void setMember(boolean member){
        this.member = member;
    }

}





