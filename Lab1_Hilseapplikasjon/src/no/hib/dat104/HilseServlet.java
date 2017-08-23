package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HilseServlet
 */
@WebServlet("/HilseServlet")
public class HilseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String serverInfo;
	
	@Override
	public void init() throws ServletException {
		serverInfo = getServletContext().getServerInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String navn = request.getParameter("navn");
		if(navn == null || navn.isEmpty()) {
			navn = "Verden";
		}
		Date naa = new Date();
		String dato = DateFormat.getDateInstance(DateFormat.LONG).format(naa);
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Lab1_Hilseapplikasjon</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Velkommen "+navn+"!</h1>");
		out.println("<p>Denne siden ble produsert " + dato + ".</p>");
		out.println("<p>Server Info: "+serverInfo);
		out.println("</body>");
		out.println("</html>");
	}
}
