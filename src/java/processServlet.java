/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Se7en
 */
public class processServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int c;
     
        HttpSession session = request.getSession();
        
            int resposta = Integer.parseInt(request.getParameter("resp"));//valor resposta vinda detras para compara resp certa
          
         
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet processServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet processServlet at " + request.getContextPath() + "</h1>");
 
            
             Integer counter_certas = (Integer)  session.getAttribute("RespCertas");
          //   Integer counter_views_session = (Integer)  session.getAttribute("hits");
             
             c= (Integer) session.getAttribute("hits");
            session.setAttribute("hits",c+1);
              
               
               
              if(resposta==1){    
             if (counter_certas != null) {
              counter_certas= (Integer) session.getAttribute("RespCertas");
            session.setAttribute("RespCertas", new Integer(counter_certas.intValue() + 1));
          
            
        } else {
          
            counter_certas = new Integer(1);
            session.setAttribute("RespCertas", counter_certas);
            
        }
            
                 }
           out.println("<h1>RESPOSTAS CERTAS: " + session.getAttribute("RespCertas") + "</h1>");
           out.println("<h1>Hits: " + session.getAttribute("hits") + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            if ((Integer)(session.getAttribute("hits"))>4) {
                // session.invalidate();
            RequestDispatcher dispatcher = getServletContext()
                                               .getRequestDispatcher(
                        "/KillSession");

            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
   
        }  
            
            
        }
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
