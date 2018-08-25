package web.app;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>data insertion</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "       \n"
                + "    <center>\n"
                + "         <h1>\n"
                + "            <font color='red' size='8' >Enter Details </font>\n"
                + "        </h1>\n"
                + "        <form action='s3' method='post'>\n"
                + "            Enter Name : <input type='text' name='Name'>\n"
                + "            <br> <br>\n"
                + "            Enter Address : <input type='text' name='Address'>\n"
                + "            <br> <br>\n"
                + "      <input type='submit' value='save' name='save'>\n"
                + "        </form>\n"
                + "        \n"
                + "    </center>\n"
                + "      \n"
                + "    </body>\n"
                + "</html>"
        );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id;
        String f1 = request.getParameter("Name");
        String f2 = request.getParameter("Address");
        try {
            userdetails r = new userdetails();
            id = r.savedata(f1, f2);
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
                        + "        <h1> Your message has not been saved in data </h1>\n"
                        + "        \n"
                        + "    </center>\n"
                        + "      \n"
                        + "    </body>\n"
                        + "</html>");
            }
        } catch(Exception e)
           {
               e.printStackTrace();
           } 
        

    }

}
