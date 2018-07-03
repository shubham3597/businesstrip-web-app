/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author shubham
 */
public class register extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         String full_name=request.getParameter("fullname");
         String email= request.getParameter("email");
         String password= request.getParameter("password");
         String cpassword = request.getParameter("cpassword");
         int designation= Integer.parseInt(request.getParameter("designation"));
         

         if(password.toString().toLowerCase() == cpassword.toString().toLowerCase()){
         
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/businesstrip","root","shubham3597");              
         Statement stmt = conn.createStatement();
         String qry = "insert into user_register values('"+full_name+"','"+email+"','"+password+"',"+designation+")";
         int r = stmt.executeUpdate(qry);
         
         if(r ==1){
             response.setContentType("text/html");  
         
             out.println("<script type=\"text/javascript\">");  

             out.println("alert('Congratulations, you have been Registered!Kindly use your email to login');");  

             out.println("</script>");
             
             RequestDispatcher rd = request.getRequestDispatcher("index.html");
             rd.include(request, response);
             
             
              
             
         }
         
         else{
              out.println("<script type=\"text/javascript\">");  

             out.println("alert('Registration failed, please try again!');");  

             out.println("</script>");
             
             RequestDispatcher rd = request.getRequestDispatcher("register.html");
             rd.include(request, response);
             
         
         
         }
         
         }
         
         else if(password != cpassword){
             out.println("<script type=\"text/javascript\">");  

             out.println("alert('Password not matched, please try again!');");  

             out.println("</script>");
             
             RequestDispatcher rd = request.getRequestDispatcher("register.html");
             rd.include(request, response);
             
             
            
         
         }
         
         
         // response.sendRedirect("index.html");
         
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
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
