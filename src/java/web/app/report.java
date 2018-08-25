package web.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static oracle.net.aso.C01.r;
import static oracle.net.aso.C07.r;

public class report extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>DATA  SHOW REQUEST</title>\n"
                + "    </head>\n"
                + "    <body bgcolor='cornsilk'>\n"
                + "    <center>\n"
                + "        <font color='red' size='15'>Select Following Details Sort Data</font>\n"
                + "        <form action='report' method='post'>\n"
                + "        <table>\n"
                + "            <tr> <td>NAME</td>       <td><input type='text' name='NAME'></td> </tr>\n"
                + "            <tr> <td>Gender</td>        <td> <input type='radio' name='GENDER' value='M'> Male <br>\n"
                + "                                             <input type='radio' name='GENDER' value='F'> Female <br></td></tr>\n"
                + "            <tr> <td>Membership</td>    <td> <select name='MTYPE'> \n"
                + "                                             <option> Select </option>\n"
                + "                                             <option value='1'> Platinum </option>\n"
                + "                                             <option value='2'> Gold </option>\n"
                + "                                             <option value='3'> Silver </option> </select> </td></tr> \n"
                + "            <tr> <td>  </td>               <td> <input type='submit' name='submit' value='show' > </td></tr> \n"
                + "            \n"
                + "        </table>\n"
                + "        </form>\n"
                + "    </center>\n"
                + "    </body>\n"
                + "</html>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>DataBase Records</title>\n"
                    + "    </head>\n"
                    + "    <body bgcolor='cornsilk'>\n"
                    + "    <center>\n"
                    + "        <font color='red' size='10'>RECORD REPORT</font> <br> <br>\n"
                    + "        <table border='1'>\n"
                    + "            <tr> <td>ID</td> <td>NAME</td> <td>GENDER</td> <td>AGE</td> <td>ADDRESS</td> <td>MTYPE</td> <td>SALARY</td> <td>USERNAME</td> <td>PASSWORD</td> </tr>\n"
                    + "        </table>\n"
                    + "        \n"
                    + "    </center>    \n"
                    + "    </body>\n"
                    + "</html>");
            String name = request.getParameter("NAME");
            String gender = request.getParameter("GENDER");
            String m = request.getParameter("MTYPE");
            int mtype = Integer.parseInt(m);
            userdetails r = new userdetails();

            ArrayList<Customer> c1 = r.getreport(name, gender, mtype);
            for (Customer c : c1) {
                out.println("<center><table> <tr> <td>" + c.id + "</td> <td>" + c.name + "</td> <td>" + c.gender + "</td> <td>" + c.age + "</td> <td>" + c.addr + "</td> <td>" + c.mtype + "</td> <td>" + c.salary + "</td> <td>" + c.username + "</td> <td>" + c.password + "</td> </tr></table></center>");
            }
 
            
            out.println("<center><br><br><a href='report'>home</a><br><br></center>");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

    }

}
