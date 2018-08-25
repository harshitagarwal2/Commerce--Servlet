package web.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class deletereport2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            int k=0;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String id[] = request.getParameterValues("ID");
            Connection c = moc.goc();
            Statement s =c.createStatement();
            for (String a : id) {
                k= Integer.parseInt(a);
            String sql="delete cust_mast where id =" + k ;
            s.executeQuery(sql);
            }
            response.sendRedirect("deletereport");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
