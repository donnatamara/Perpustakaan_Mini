package model;

public class Admin extends User {

    public Admin(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Admin: " + name + " | ID: " + id);
    }
}