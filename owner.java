public class owner extends Person {
    String password;

    public owner () {
    }
    public owner (String name, Address address, String phoneNo, String email, String password){
        super(name, address, phoneNo, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}