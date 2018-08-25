
package web.app;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class loginpage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>abc Showroom</title>\n"
                + "        </head>\n"
                + "        \n"
                + "    <body bgcolor=antiquewhite>\n"
                + "    <center>\n"
                + "        <font color='red' size='8'>WELCOME TO SHOPPING HOUSE </font>\n"
                + "        <hr>\n"
                + "        <font color='blue' size='6'>Login</font><br>\n"
                + "    <br>    <form action='login' method='post'>\n"
                + "         ENTER USERNAME  <input type='text' name='USERNAME'>\n"
                + "      <br><br>   ENTER PASSWORD <input type='password' name='PASSWORD'>\n"
                + "         <br><br><input type='submit' value='login' name='submitbutton'>                                             "
                + "        </form>\n"
                + "    </center>\n"
                + "    </body>\n"
                + "</html>");
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String username = request.getParameter("USERNAME");
            String password = request.getParameter("PASSWORD");
            userdetails r = new userdetails();
            int id = r.checklogin(username, password);
            if (id == 0) {
                out.println("<html>\n"
                        + "    <head>\n"
                        + "       <title>LOGIN ERROR</title>\n"
                        + "    </head>\n"
                        + "    <body bgcolor='cayan'>\n"
                        + "    <center>\n"
                        + "        <font size='6'>Please check your username or password</font>\n"
                        + " <a href='login' >home</a>  <br>      "
                        + "\n"
                        + "    </center>\n"
                        + "    </body>\n"
                        + "</html>");
                out.close();
            }
            else{
                response.sendRedirect("s2");
            }
        } catch (ClassNotFoundException | SQLException ex) {
      ex.printStackTrace();
        }
    }

}
