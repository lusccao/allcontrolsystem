package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ManterInformacoes
 */
@WebServlet("/ManterInformacoes")
public class ManterInformacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterInformacoes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	
		
		String mIdInformacoes = request.getParameter("idInformacoes");
		String mIdMaquina = request.getParameter("idMaquina");
		String mCPU = request.getParameter("CPU");
		String mHDTotal = request.getParameter("HDTotal");
		String mHDUtilizado = request.getParameter("HDUtilizado");
		String mHDDisponivel = request.getParameter("HDDisponivel");
		String mRamTotal = request.getParameter("RamTotal");
		String mRamUtilizada = request.getParameter("RamUtilizada");
		String mRamDiponivel = request.getParameter("RamDiponivel");
		String mData = request.getParameter("Data");		
		
		//Informacoes informacoes = new Informacoes();
		
		//informacoes.set
		//maquina.setHostname(mHostname);
		//maquina.setSO(mSO);
		//maquina.setDescricao(mDescricao);
		//MaquinaService ms = new MaquinaService();
		//ms.criar(maquina);
		//maquina = ms.carregar(maquina.getIdMaquinas());
		
		//request.setAttribute("maquina", maquina);
		
		RequestDispatcher view = request.getRequestDispatcher("Visualizar.jsp");
		
		
		view.forward(request, response);
	}

}
