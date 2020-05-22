package logic;

import logic.Person;

public class BlackListUsers extends Person {
    private String cause;

    public BlackListUsers(int id, String fname, String sname, String lname, String iin, String cause) {
        super(id, fname, sname, lname, iin);
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    @Override
    public void display(){
        super.display();
        System.out.println(" " + getCause() + "\n");
    }
}
