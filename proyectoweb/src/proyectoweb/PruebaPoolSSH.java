package proyectoweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PruebaPoolSSH
 */
@WebServlet("/PruebaPoolSSH")
public class PruebaPoolSSH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaPoolSSH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String select_pat = "select id_patol from Patologias where nom_patol = 'Queratocono'";
		ResultSet rs = null;
		Pool pool = null;
		pool = Pool.getInstance();
		Connection conn = pool.getConnection();
		int idpatol = -5;
		Statement st = null;
		
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(select_pat);
			rs.next();
			System.out.println("Conexion correcta");
			idpatol=rs.getInt("id_patol");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				st.close();
				conn.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		response.getWriter().append("id QUERATOCONO: ").append(String.valueOf(idpatol));
		
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
