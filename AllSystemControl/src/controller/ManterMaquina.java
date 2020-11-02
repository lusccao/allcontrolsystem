package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Maquina;
import service.MaquinaService;

/**
 * Servlet implementation class ManterMaquina
 */
@WebServlet("/ManterMaquina")
public class ManterMaquina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterMaquina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		
		String mIdMaquinas = request.getParameter("idMaquinas");
		String mHostname = request.getParameter("hostname");
		String mSO = request.getParameter("SO");
		String mDescricao = request.getParameter("descricao");
		
		int idMaquinas = -1;
		try {
			idMaquinas = Integer.parseInt(mIdMaquinas);
			
		} catch (NumberFormatException e) {

		}		
		
		
		Maquina maquina = new Maquina();
		maquina.setIdMaquinas(idMaquinas);
		maquina.setHostname(mHostname);
		maquina.setSO(mSO);
		maquina.setDescricao(mDescricao);
		
		
		MaquinaService ms = new MaquinaService();
		ms.criar(maquina);
		maquina = ms.carregar();
		
		request.setAttribute("Maquina", maquina);
		
		RequestDispatcher view = request.getRequestDispatcher("Visualizar.jsp");		
		
		view.forward(request, response);
	}
	
	

}
