package model;

public class Member extends User {

    public Member(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Member: " + name + " | ID: " + id);
    }

    public Object getRole() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
