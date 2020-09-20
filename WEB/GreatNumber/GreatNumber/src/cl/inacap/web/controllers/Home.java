package cl.inacap.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.inacap.web.models.Funciones;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer number = (Integer) session.getAttribute("numeroRandom");
		if (number == null) {
			Integer numberoAleatorio = Funciones.aleatorio();
			session.setAttribute("numeroRandom", numberoAleatorio);
		}
		request.setAttribute("class", "hidden");
		request.setAttribute("clases", "hidden");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeroUsuarioString = request.getParameter("numero");
		if (numeroUsuarioString != "") {
			try {
				int numero = Integer.parseInt(numeroUsuarioString);
				if( numero > 100 || numero < 1) {
					request.setAttribute("mensaje", "Numero fuera de rango");
					request.setAttribute("clase", "rojo");
					request.setAttribute("clases", "hidden");
				}
				else {
					HttpSession session = request.getSession();
					Integer number = (Integer) session.getAttribute("numeroRandom");
					
					Integer numeroUsuario = Integer.parseInt(numeroUsuarioString);
					if(number.equals(numeroUsuario)) {
						request.setAttribute("mensaje", "Usted acerto al numero!!");
						request.setAttribute("clase", "verde");
						request.setAttribute("number", number);
						request.setAttribute("clases", "");
					
					}
					else if(numeroUsuario > number){
						request.setAttribute("mensaje", "Too High!!");
						request.setAttribute("clase", "rojo");
						request.setAttribute("clases", "hidden");
					}
					else if (numeroUsuario < number){
						request.setAttribute("mensaje", "Too Low!!");
						request.setAttribute("clase", "rojo");
						request.setAttribute("clases", "hidden");
					}
				}
			}
			catch(Exception e){
				System.out.println(e);
				request.setAttribute("mensaje", "Numbero invalido");
				request.setAttribute("clase", "rojo");
				request.setAttribute("clases", "hidden");
			}
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

}
