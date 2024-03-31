package logic;

import database.BlackListRepository;
import logging.MessageLogger;
import model.BlackListEntry;

public class CreditApprover {

    private final BlackListRepository blackListRepository;
    private final MessageLogger logger;
    private String cause = "No cause";

    public CreditApprover(BlackListRepository blackListRepository, MessageLogger logger) {
        this.blackListRepository = blackListRepository;
        this.logger = logger;
        this.logger.message("Credit Approver started!");
    }

    public boolean approveByIdIIN(String fname, String sname, String lname, String IIN) {
        for (BlackListEntry entry : blackListRepository.getAllEntries()) {
            if (entry.matchesIdAndIin(fname, sname, lname, IIN)) {
                logger.message("Match Found: ID and IIN");
                logger.message("Cause : " + entry.getCause());
                cause = entry.getCause();
                return false;
            }
        }
        return true;
    }

    public boolean approveByIin(String IIN) {
        for (BlackListEntry entry : blackListRepository.getAllEntries()) {
            if (entry.getIin().equalsIgnoreCase(IIN)) {
                logger.message("Match Found: IIN");
                logger.message("Cause : " + entry.getCause());
                return false;
            }
        }
        return true;
    }

    public boolean approveById(String fname, String sname, String lname) {
        for (BlackListEntry entry : blackListRepository.getAllEntries()) {
            if (entry.matchesId(fname, sname, lname)) {
                logger.message("Match Found: ID");
                logger.message("Cause : " + entry.getCause());
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
