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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author crist
 */
public class Eliminar extends HttpServlet {
    
    //variables globales
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor del servlet
    //nos va a ayudar a inicializar la conexion con la base de datos
    
    public void init(ServletConfig cfg) throws ServletException{
        //lo primero que necesitamos es trazar la ruta al servidor de la bd
        String URL = "jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_227d7237f19c8f4";
        //driver:gestor:puerto//ip/nombreBD
        String userName = "b44bfb41dfa2d9";
        String password = "e06e1848";
                
        try{
            //tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Conexión no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //para eliminar necesitamos obtener el id
            
            String contrasena;
            contrasena = request.getParameter("contrasena");
            if(contrasena.equals("bebeconmetralleta")){
                int id;

                id = Integer.parseInt(request.getParameter("ideliminar"));

                //preparo mi sentencia: delete from tabla where atributo = valor

                String q = "delete from heladeriaschalco where id_usu = "+id;

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Eliminar</title>");
                out.println("<link rel=\"stylesheet\" href=\"./CSS/style.css\">");
                out.println("</head>");
                out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
                
 out.println("<style>"
                        + ".table{\n"
                        + "margin-right; 4 rem;\n"
  
                        + "}\n"
                                    + "a{\n" +
                                    "  color: #58f0f0;\n" +
                                    "  font-family: 'Montserrat', sans-serif;\n" +
                                    "  text-decoration: none;\n" +
                                    "}\n" +
                                    "a:hover{\n" +
                                    "  color: #a0d5f3;\n" +
                                    "}"
                                    + ".boton{\n" +
                                    "    width: 100%;\n" +
                                    "    background: none;\n" +
                                    "    border: 2px solid rgb(0, 225, 255);\n" +
                                    "    border-radius: 3px;\n" +
                                    "    color: white;\n" +
                                    "    margin-top: 10px;\n" +
                                    "    font-size: 18px;\n" +
                                    "}\n" +
                                    ".boton:hover{\n" +
                                    "    background-color: rgb(0, 225, 255);\n" +
                                    "}"
                                    + ".login-box{\n" +
"    width: 280px;\n" +
"    position: absolute;\n" +
"    top: 50%;\n" +
"    left: 50%;\n" +
"    transform: translate(-50%,-50%);\n" +
"    color: white;\n" +
"}\n" +
".login-box h1{\n" +
"    float: left;\n" +
"    font-size: 40px;\n" +
"    border-bottom: 6px solid rgb(0, 225, 255);\n" +
"    margin-bottom: 50px;\n" +
"}"
                                    
                                    + "</style>");              
                
                out.println("<div class = 'login-box'>");
                try{
                    //update hay una modificacion/actualizacion a la tabla
                    set.executeUpdate(q);
                    System.out.println("Registro Eliminado");
                    out.println("<h1 >Usuario Eliminado</h1>");
                    set.close();
                }catch(Exception e){
                    out.println("<h1>Usuario NO Eliminado</h1>");
                    System.out.println("No se pudo eliminar el usuario");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                }
                out.println("<br>");
                out.println("<hr>");
                out.println("<a href=\"Admin.html\"><input class=\"boton\" type=\"button\" name=\"Volver\" value=\"Volver\"></a>"
                            + "<br>");
                out.println("<hr>"
+ "  <footer style=\"padding-top: 300px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> ");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                
            }else{
                
                                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>BEN AND JERRY’S</title>");
                out.println("<link rel='stylesheet' href='./CSS/style.css'>");
                out.println("<link href=\'https://fonts.googleapis.com/css2?family=Lemonada:wght@300&family=Merriweather:ital@1&family=Montserrat:wght@500&display=swap' rel='stylesheet\'>");
                out.println("</head>");
                out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
                
              out.println("<style>"
                        + ".table{\n"
                        + "margin-right; 4 rem;\n"
  
                        + "}\n"
                                    + "a{\n" +
                                    "  color: #58f0f0;\n" +
                                    "  font-family: 'Montserrat', sans-serif;\n" +
                                    "  text-decoration: none;\n" +
                                    "}\n" +
                                    "a:hover{\n" +
                                    "  color: #a0d5f3;\n" +
                                    "}"
                                    + ".boton{\n" +
                                    "    width: 100%;\n" +
                                    "    background: none;\n" +
                                    "    border: 2px solid rgb(0, 225, 255);\n" +
                                    "    border-radius: 3px;\n" +
                                    "    color: white;\n" +
                                    "    margin-top: 10px;\n" +
                                    "    font-size: 18px;\n" +
                                    "}\n" +
                                    ".boton:hover{\n" +
                                    "    background-color: rgb(0, 225, 255);\n" +
                                    "}"
                                    + ".login-box{\n" +
"    width: 280px;\n" +
"    position: absolute;\n" +
"    top: 50%;\n" +
"    left: 50%;\n" +
"    transform: translate(-50%,-50%);\n" +
"    color: white;\n" +
"}\n" +
".login-box h1{\n" +
"    float: left;\n" +
"    font-size: 40px;\n" +
"    border-bottom: 6px solid rgb(0, 225, 255);\n" +
"    margin-bottom: 50px;\n" +
"}"
                                    
                                    + "</style>");
                
                out.println("<div class = 'login-box'>");
                out.println("<h1>Contraseña incorrecta</h1>");
                

                out.println("<br>"
                        + "<hr>");
                out.println("<a href=\"Admin.html\"><input class=\"boton\" type=\"button\" name=\"Volver\" value=\"Volver\"></a>");
                out.println("<br>");
                       out.println("<br>"
                               + "<hr>"); 

        out.println("  <footer style=\"padding-top: 300px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> "
                + "</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}