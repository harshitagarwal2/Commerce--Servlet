package web.app;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class update extends HttpServlet {

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
                + "        <form action='update' method='post'>\n"
                + "        <table>\n"
                + "            <tr> <td>NAME</td>       <td><input type='text' name='NAME'></td> </tr>\n"
                + "            <tr> <td>Gender</td>        <td> <input type='radio' name='GENDER' value='M'> Male <br>\n"
                + "                                             <input type='radio' name='GENDER' value='F'> Female <br></td></tr>\n"
                + "            <tr> <td>Membership</td>    <td> <select name='MTYPE'> \n"
                + "                                             <option> Select </option>\n"
                + "                                             <option value='1'> Platinum </option>\n"
                + "                                             <option value='2'> Gold </option>\n"
                + "                                             <option value='3'> Silver </option> </select> </td></tr>"
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
                    + "        <form action='update2' method='post'> \n"
                    + "            <font color='red' size='10'>RECORD REPORT</font> <br> <br>\n"
                    + "            <table align='center' border='1'>\n"
                    + "                <tr> <th> </th> <th>ID</th> <th>NAME</th> <th>GENDER</th> <th>AGE</th> <th>ADDRESS</th> <th>MTYPE</th> <th>SALARY</th> <th>USERNAME</th> <th>PASSWORD</th> </tr>");
            String name = request.getParameter("NAME");
            String gender = request.getParameter("GENDER");
            String m = request.getParameter("MTYPE");
            int mtype = Integer.parseInt(m);
            userdetails r = new userdetails();
            ArrayList<Customer> c1 = r.getreport(name, gender, mtype);
            for (Customer c : c1) {
                out.println("<tr> <td> <input type='radio' name='ID' value=" + c.id + "> </td> <td>" + c.id + "</td> <td>" + c.name + "</td> <td>" + c.gender + "</td> <td>" + c.age + "</td> <td>" + c.addr + "</td> <td>" + c.mtype + "</td> <td>" + c.salary + "</td> <td>" + c.username + "</td> <td>" + c.password + "</td> </tr>");
            }
            out.println("     </table><br><br>\n"
                    + "            <input type='submit' value='show'>\n"
                    + "            </form>\n"
                    + "            <br><br><a href='report'>home</a><br><br></center>\n"
                    + "            </body>\n"
                    + "</html>");
            out.close();
                } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
