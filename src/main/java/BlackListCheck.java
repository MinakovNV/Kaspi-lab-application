
import main.java.database.DBConnection;
import main.java.logic.CreditApprover;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLException;

@WebServlet(name = "/home")
public class BlackListCheck extends HttpServlet {

    static final String result_1 = "Credit request approved";
    static final String result_2 = "Credit request is not approved";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp;

        String fnameV = request.getParameter("fname");
        String lnameV = request.getParameter("lname");
        String snameV = request.getParameter("sname");
        String iinV = request.getParameter("iin");

        try {
            CreditApprover ca = new CreditApprover();
            // boolean flagIIN = ca.approveByIin(iinV);
            // boolean flagID = ca.approveById(fnameV, snameV, lnameV);
            boolean flagIDIIN = ca.approveByIdIIN(fnameV, snameV, lnameV, iinV);

            if (flagIDIIN){
                // одобрен
                System.out.println(result_1);
                request.setAttribute("flag", 1);
                request.setAttribute("result", result_1);
                disp = request.getRequestDispatcher("/pages/creditResultForm.jsp");
            }else {
                // не одобрен
                System.out.println(result_2);
                request.setAttribute("flag", 0);
                request.setAttribute("result", result_2);
                request.setAttribute("cause", ca.getCause());
                disp = request.getRequestDispatcher("/pages/creditDeniedForm.jsp");
            }
            disp.forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher disp = request.getRequestDispatcher("/pages/creditRequestForm.jsp");
        disp.forward(request, response);

    }
}
