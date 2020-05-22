package logic;

import java.sql.SQLException;
import java.util.logging.Logger;

import static database.DBConnection.*;

public class CreditApprover {

    private String cause = "No cause";
    public MessageLogger lg = new MessageLogger();

    public CreditApprover() throws SQLException, ClassNotFoundException {
        lg.message("Credit Approver started!");
        dbConnector();
        uploadBlackList();
        showBlackList();
    }

    public boolean approveByIdIIN(String fname, String sname, String lname, String IIN){
        for (int i = 0; i<getArr().size(); i++){
            if(getArr().get(i).getFname().equalsIgnoreCase(fname) && getArr().get(i).getSname().equalsIgnoreCase(sname)
                    && getArr().get(i).getLname().equalsIgnoreCase(lname) && getArr().get(i).getIin().equalsIgnoreCase(IIN)){
                lg.message("Match Found: ID and IIN");
                lg.message("Cause : " + getArr().get(i).getCause());
                cause = getArr().get(i).getCause();
                return false;
            }
        }
        return true;
    }

    public boolean approveByIin(String IIN){
        for (int i = 0; i<getArr().size(); i++){
            if(getArr().get(i).getIin().equalsIgnoreCase(IIN)){
                lg.message("Match Found: IIN");
                lg.message("Cause : " + getArr().get(i).getCause());
                return false;
            }
        }
        return true;
    }

    public boolean approveById(String fname, String sname, String lname){
        for (int i = 0; i<getArr().size(); i++){
            if(getArr().get(i).getFname().equalsIgnoreCase(fname) && getArr().get(i).getSname().equalsIgnoreCase(sname)
                    && getArr().get(i).getLname().equalsIgnoreCase(lname) ){
                lg.message("Match Found: ID");
                lg.message("Cause : " + getArr().get(i).getCause());
                return false;
            }
        }
        return true;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}