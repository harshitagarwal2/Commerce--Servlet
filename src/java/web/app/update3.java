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

public class update3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html");
            PrintWriter out = response.getWriter();
           out.println("<html> <form action='update3' method='post' ></form> </html>");
     }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("ID"));
            String name = request.getParameter("NAME");
            String addr = request.getParameter("ADDRESS");
            String gen =  request.getParameter("GENDER");
            int age = Integer.parseInt(request.getParameter("AGE"));
            int mtype = Integer.parseInt(request.getParameter("MTYPE"));
            int sal = Integer.parseInt(request.getParameter("SALARY"));
            String user = request.getParameter("USERNAME");
            String pass = request.getParameter("PASSWORD");
            userdetails r = new userdetails();
            int id1 = r.update2(id, name, gen, age, addr, mtype, sal, user, pass);
            if (id1 != 0) {
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
                        + "    </center>\n"
                        + "      \n"
                        + "    </body>\n"
                        + "</html>"); 
            }
            out.close();
        } catch (Exception ex) {
              ex.printStackTrace();
        }
    }

}
