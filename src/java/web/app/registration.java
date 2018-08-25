package web.app;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registration extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>To enter details into database</title>\n"
                + "    </head>\n"
                + "    <body bgcolor='skyblue'>\n"
                + "    <center>\n"
                + "        <form action='s4' method='post'>\n"
                + "        <table>\n"
                + "            <tr> <td>Name</td>          <td> <input type='text' name='NAME'> </td> </tr>\n"
                + "            <tr> <td>Address</td>       <td> <textarea rows='4' cols='50' name='ADDRESS'> </textarea> </td></tr>\n"
                + "            <tr> <td>Gender</td>        <td> <input type='radio' name='GENDER' value='M'> Male <br>\n"
                + "                                             <input type='radio' name='GENDER' value='F'> Female <br></td></tr>\n"
                + "            <tr> <td>Membership</td>    <td> <select name='MTYPE'> \n"
                + "                                             <option value='1'> Select </option>\n"
                + "                                             <option value='1'> Platinum </option>\n"
                + "                                             <option value='2'> Gold </option>\n"
                + "                                             <option value='3'> Silver </option> </select> </td></tr> \n"
                + "            <tr> <td>Age</td>               <td> <input type='number' name='AGE' > </td></tr>\n"
                   + "            <tr> <td>Salary</td>      <td> <input type='text' name='SALARY'></td></tr>\n"
                + "            <tr> <td>Username</td>      <td> <input type='text' name='USERNAME'> </td></tr>\n"
                + "            <tr> <td>Password</td>      <td> <input type='password' name='PASSWORD'></td></tr>\n"
                + "            <tr> <td></td>      <td> <input type='submit' name='SUBMIT' value='save' > </td></tr>\n"
                + "\n"
                + "\n"
                + "        </table>\n"
                + "        </form>\n"
                + "\n"
                + "    </center>\n"
                + "</body>\n"
                + "\n"
                + "</html>");
        out.close();

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String n = request.getParameter("NAME");
            String a = request.getParameter("ADDRESS");
            String g = request.getParameter("GENDER");
            String m = request.getParameter("MTYPE");
            String age = request.getParameter("AGE");
            String username = request.getParameter("USERNAME");
            String password = request.getParameter("PASSWORD");
            String salary = request.getParameter("SALARY");
            int mtype1= Integer.parseInt(m);
            int age1= Integer.parseInt(age);
            int salary1= Integer.parseInt(salary);
            userdetails r = new userdetails();
            int id =r.saveregistration(n,g,age1,a,mtype1,salary1,username,password);
            if (id != 0) {
                out.println("<html>\n"
                        + "    <head>\n"
                        + "        <title>data insertion</title>\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "       \n"
                        + "    <center>\n"
                        + "        <h1> Your message has been saved in data </h1>\n"
                        + "        \n"
                        + "    </center>\n"
                        + "      \n"
                        + "    </body>\n"
                        + "</html>");
            } else {
                out.println("<html>\n"
                        + "    <head>\n"
                        + "        <title>data insertion</title>\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "       \n"
                        + "    <center>\n"
                        + "        <h1> Your message not has been saved in data </h1>\n"
                        + "        \n"
                        + "    </center>\n"
                        + "      \n"
                        + "    </body>\n"
                        + "</html>"); 
            }
        } catch (SQLException | ClassNotFoundException ex) {
     ex.printStackTrace();
        }
               
    }

}
