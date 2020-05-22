package logic;

public class Person {
    private int id;
    private String fname;
    private String sname;
    private String lname;
    private String iin;

    public Person(int id, String fname, String sname, String lname, String iin) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.lname = lname;
        this.iin = iin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public void display(){
        System.out.print(getId() +" " + getFname() + " " + getSname() + " " + getLname() + " " + getIin());
    }

}
