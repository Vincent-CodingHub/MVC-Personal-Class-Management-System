public class User {
    private String username, password, position;

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getName(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPosition(){
        return this.position;
    }
}
