package model;

public class Member extends User {

    public Member(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Member: " + name + " | ID: " + id);
    }
}
