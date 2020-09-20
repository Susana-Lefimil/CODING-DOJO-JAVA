package cl.demo.cal.contrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.demo.cal.models.Calculadora;

/**
 * Servlet implementation class Cal
 */
@WebServlet({ "/Cal", "/cal" })
public class Cal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Calculadora c= (Calculadora) session.getAttribute("currentCalculator");
		if(c==null) {
			c=new Calculadora();
		}
		
		session.setAttribute("currentCalculator", c);
		request.setAttribute("currentCalculator", c);
		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/calculadora.jsp");
		view.forward(request, response);
		
	}

	/**
	 * POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Calculadora c= (Calculadora) session.getAttribute("currentCalculator");
		if(c==null) {
			c= new Calculadora();
		}
		
		String input=request.getParameter("txt");
		if(input.equals(c.getCurrentNumber())) {
			c.setCurrentNumber(input);
		}
		
		
		
		String btn=request.getParameter("btn");
		if("1234567890.".contains(btn)) {
			c.addCurrentNumber(btn);
			
			
		}else if("/x+-".contains(btn)) {
			c.operation(btn);
		}else if("=".contains(btn)) {
			c.calculate();
	    }else if("cl".contains(btn)) {
	    	c= new Calculadora();
	    }
			
		
		session.setAttribute("currentCalculator", c);
		response.sendRedirect(request.getContextPath() + "/cal");
		
		
		
	}

}
