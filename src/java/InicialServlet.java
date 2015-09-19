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
public class InicialServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void questions(String[][] quizz){
      
      
quizz[0][0]="Uma das respostas abaixo NÃO está correta";
quizz[0][1]="Fidalgo é o mesmo que Nobre";
quizz[0][2]="Fedelho quer dizer, criança de pouca idade";
quizz[0][3]="Fiança é a mesma coisa que Garantia";
quizz[0][4]="Soror é uma solução mineral ou orgânica usada nos hospitais";
quizz[0][5]="Cuscuz, prato regional brasileiro feito com farinha de milho";

quizz[1][0]="Fulano é o mesmo que";
quizz[1][1]="Indivíduo, pessoa";
quizz[1][2]="Espécie de canibal africano";
quizz[1][3]="É o mesmo que estar com raiva";
quizz[1][4]="Designação genérica para gato novo";
quizz[1][5]="Termo como são conhecidos os atores de pouco talento";
        
quizz[2][0]="O vocábulo Carapaça significa";
quizz[2][1]="Um tipo de touca para cabeça";
quizz[2][2]="Um tipo de touca para cabeça";
quizz[2][3]="No jogo de bilhar, buraco onde são jogadas as bolinhas";
quizz[2][4]="Revestimento que protege animais, como, cágados e tartarugas";
quizz[2][5]="É a película protetora usada em unhas; o mesmo que esmalte";
        
        
  quizz[3][0]="Garapa é o mesmo que";
quizz[3][1]="Tipo de objeto pontudo usado para furar gelo";
quizz[3][2]="Refresco de qualquer fruta, mel ou açúçar";
quizz[3][3]="Dança tradicional do norte do Brasil";
quizz[3][4]="Uma fruta da região amazônica";
quizz[3][5]="Coisa muito difícil de conseguir, ou incerta";


quizz[4][0]="A palavra Quilombo significa";
quizz[4][1]="Pequeno morro ou monte de terra";
quizz[4][2]="É como são conhecidas as contusões que apresentam inchaços";
quizz[4][3]="É o outro nome para as Lombadas usadas nas estradas ou ruas";
quizz[4][4]="É quando alguma coisa aumenta de volume";
quizz[4][5]="Esconderijo onde os escravos se refugiavam";
        
    

        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int c;

             HttpSession session = request.getSession();

         String[][] quizz= (String[][]) session.getAttribute("quizz");
         
            System.err.print("ta aqui");
          if(session.getAttribute("quizz")==null){
            
              quizz= new  String[5][6];
            questions(quizz);}
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IndexServlet</title>");            
            out.println("</head>");
            out.println("<body>");
               out.println("<h1>Trabalho sobre Tecnologias Servlet</h1>");
                
 out.println("<h1>BLALBABLA</h1>");
  

 session.invalidate();
  if (session.getAttribute("hits")==null){
    //  session.invalidate();
          c= new Integer(0);      
  
            session.setAttribute("hits",c);
  }
  else   {c= (Integer) session.getAttribute("hits");
           
  }
   
  //c=0; // ativar caso haja +5...
                   
                 
                      out.println("<h1>"+quizz[c][0]+"</h1>");
           out.println(
                   
                   
                "<form method=\"get\">"
                        
                        
                + "<input type=\"radio\" name=\"resp\"  value=\"1\">"+quizz[c][1]
                             + "<br><input type=\"radio\" name=\"resp\"  value=\"2\">"+quizz[c][2]
                             + "<br><input type=\"radio\" name=\"resp\"  value=\"3\">"+quizz[c][3]
                             + "<br><input type=\"radio\" name=\"resp\"  value=\"4\">"+quizz[c][4]
                          + "<br><input type=\"radio\" name=\"resp\"  value=\"5\">"+quizz[c][5]
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">");
           
            out.println(
                   
                   
                "<form method=\"get\">" + "<input type=\"submit\" name=\"button1\" value=\"Volta Inicio\">" + "</form>");
         
           
            
      

         
           
             int resposta =Integer.parseInt(request.getParameter("resp"));
             // request.getSession().invalidate();
     
             
             
              if ((resposta != 0)) {
            RequestDispatcher dispatcher = getServletContext()
                                               .getRequestDispatcher(
                        "/process");

            
            
            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
   
        }
               //session.invalidate();
        System.out.println("---->"+session.getAttribute("hits"));
             
              
              
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
