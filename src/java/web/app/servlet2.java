
package web.app;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;  
public class servlet2 extends HttpServlet
{
    int i, j;
        
    protected  void doGet(HttpServletRequest   request,
                          HttpServletResponse  response )
                                                        throws ServletException , IOException
   {
        System.out.println("doget() of servlet1");
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<body><center>");
                out.println("<form action=s2 method=post>");
                 out.println("input 1 : <input type= text name =INPUT1> <br>  ");
                 out.println("input 2 : <input type= text name =INPUT2 > <br>  ");
                 out.println( " <input type= submit value=ADD name=submit button ");
                 out.println("</form>");
                 out.println("</center></body>");
              out.println("</html>");
              out.close();
             
    }
    
    protected  void doPost(HttpServletRequest   request,
                          HttpServletResponse  response )
                                                        throws ServletException , IOException
    {
        response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
         String f1 = request.getParameter("INPUT1");
           String f2 = request.getParameter("INPUT2");
           
           int add = Integer.parseInt(f2) + Integer.parseInt(f1);
          out.println("<html>");
          out.println("<body><center>");
          out.println("<font color='blue' size='8' > do post method </font>");
          out.println("<font color='red' size='6'> addition = " + add + " </font> <br> ");
          out.println("<a href='s2' > call doget() </a> <br> <br> ");
          out.println("</center></body>");
          out.println("</html>");
          out.close();
    }
    
    
    
}
