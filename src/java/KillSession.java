import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class KillSession extends HttpServlet {
        public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	// get the session, 
	HttpSession session = request.getSession(true); 



	response.setContentType("text/html");

	// session is retrieved before getting the writer

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        out.println("<head>");

	out.println("<title> Ice cream </title>");

        out.println("</head>");
        out.println("<body>");

	out.println("<h1>Resultados</h1>");

//        if(session.getAttribute("RespCertas")==null)
//        session.setAttribute("RespCertas","0");
//            
         out.println("<h1>Certas: " + session.getAttribute("RespCertas")+ "</h1>");
//         int conta=(Integer)session.getAttribute("RespCertas");
//          out.println("<h1>Conta: " +conta+ "</h1>");
//        conta=5-conta;
    //   out.println("<h1>Erradas: " + conta+ "</h1>");
	out.println("Click");
	out.println("<A HREF = \"InicialServlet\">here</A>");
	out.println("to buy more ice cream");

	out.println("</body>");
	out.println("</html>");
	// invalidate it
	session.invalidate();
	out.close();

    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	doGet(request,response);
    }
}