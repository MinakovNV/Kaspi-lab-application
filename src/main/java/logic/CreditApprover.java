package main.java.logic;

import com.mysql.cj.jdbc.JdbcConnection;
import main.java.database.DBConnection;

import java.sql.SQLException;

import static main.java.database.DBConnection.*;

public class CreditApprover {

    private String cause = "No cause";

    public CreditApprover() throws SQLException, ClassNotFoundException {
        System.out.println("Credit Approver started!");
        dbConnector();
        uploadBlackList();
        showBlackList();
    }

    public boolean approveByIdIIN(String fname, String sname, String lname, String IIN){
        for (int i = 0; i<getArr().size(); i++){
            if(getArr().get(i).getFname().equalsIgnoreCase(fname) && getArr().get(i).getSname().equalsIgnoreCase(sname)
                    && getArr().get(i).getLname().equalsIgnoreCase(lname) && getArr().get(i).getIin().equalsIgnoreCase(IIN)){
                System.out.println("Match Found: ID and IIN");
                System.out.println("Cause : " + getArr().get(i).getCause());
                cause = getArr().get(i).getCause();
                return false;}
        }
        return true;
    }

    public boolean approveByIin(String IIN){
        for (int i = 0; i<getArr().size(); i++){
            if(getArr().get(i).getIin().equalsIgnoreCase(IIN)){
                System.out.println("Match Found: IIN");
                System.out.println("Cause : " + getArr().get(i).getCause());
                return false;
            }
        }
        return true;
    }

    public boolean approveById(String fname, String sname, String lname){
        for (int i = 0; i<getArr().size(); i++){
            if(getArr().get(i).getFname().equalsIgnoreCase(fname) && getArr().get(i).getSname().equalsIgnoreCase(sname)
                    && getArr().get(i).getLname().equalsIgnoreCase(lname) ){
                System.out.println("Match Found: ID");
                System.out.println("Cause : " + getArr().get(i).getCause());
                return false;}
        }
        return true;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause_1) {
        this.cause = cause;
    }
}