package web.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update2 extends HttpServlet 
{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {   
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String i = request.getParameter("ID");
            int id =Integer.parseInt(i);
            userdetails r = new userdetails();
            updatecust up = r.update1(id);
            
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>To enter details into database</title>\n"
                    + "    </head>\n"
                    + "    <body bgcolor='skyblue'>\n"
                    + "    <center>\n"
                    + "        <form action='update3' method='post'>  "
                    + "        id : <input type='text' name=ID value="+id+"> " 
                    + "         <font color='red' size=10>please update the required details</font> "
                    + "        <table>\n"
                    + "            <tr> <td>Name</td>          <td> <input type='text' name='NAME' value="+up.NAME + " > </td> </tr>\n"
                    + "            <tr> <td>Address</td>       <td> <textarea rows='4' cols='50' name='ADDRESS'>"+up.ADDRESS+"</textarea> </td></tr>\n"
                    + "            <tr> <td>Gender</td>        <td> <input type='radio' name='GENDER' value='M'  > Male <br>\n"
                    + "                                             <input type='radio' name='GENDER' value='F'> Female <br></td></tr>\n"
                    + "            <tr> <td>Membership</td>    <td> <select name='MTYPE'> \n"
                    + "                                             <option value='null'> Select </option>\n"
                    + "                                             <option value='1'> Platinum </option>\n"
                    + "                                             <option value='2'> Gold </option>\n"
                    + "                                             <option value='3'> Silver </option> </select> </td></tr> \n"
                    + "            <tr> <td>Age</td>               <td> <input type='number' name='AGE' value= " + up.age + " > </td></tr>\n"
                    + "            <tr> <td>Salary</td>      <td> <input type='text' name='SALARY' value=" + up.salary + "  ></td></tr>\n"
                    + "            <tr> <td>Username</td>      <td> <input type='text' name='USERNAME' value=" + up.USERNAME + " > </td></tr>\n"
                    + "            <tr> <td>Password</td>      <td> <input type='password' name='PASSWORD' value=" + up.PASSWORD + " ></td></tr>\n"
                    + "            <tr> <td></td>      <td> <input type='submit' name='SUBMIT' value='save' > </td></tr>\n"
                    + "        </table>\n"
                    + "        </form>\n"
                    + "    </center>\n"
                    + "</body>\n"
                    + "</html>");
            out.close();
             } catch (Exception ex) {
           ex.printStackTrace();
            }
     } 

}
