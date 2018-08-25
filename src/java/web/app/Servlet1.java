package web.app;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;  
public class Servlet1 extends HttpServlet
{
    int i=10 , j , result ;
    public void init()
    {
        System.out.println("servlet instance is created when it is called for first time");
        j = new java.util.Random() .nextInt();
    }
   
    protected  void doGet(HttpServletRequest   request,
                          HttpServletResponse  response )
                                                        throws ServletException , IOException
    {
        System.out.println("doget() of servlet1");
        response.setContentType("text/html");
        String data = request.getParameter("INPUT1");
        data = "Mr." + data;
        j = new java.util.Random().nextInt(100);
        result = i + j;
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<body><center>");
                out.println("<font color=red size=8>Servlet's doget() (" + result + ")</font>");
                out.println("<br> <font color=blue size=6>" + data + " </font> ");
            out.println("</center></body>");
              out.println("</html>");
              out.close();
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost() of servlet1");
        response.setContentType("text/html");
        String data = request.getParameter("INPUT1");
        data = "Mr." + data;
        j = new java.util.Random().nextInt(100);
        result = i + j;
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<body><center>");
                out.println("<font color=blue size=10>Servlet's doget() (" + result + ")</font>");
                out.println("<br> <font color=yellow size=6>" + data + " </font> ");
            out.println("</center></body>");
              out.println("</html>");
              out.close();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is getting out of memory");  
    }
                      
    }
            
    
