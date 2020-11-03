package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Informacoes;
import service.InformacoesService;


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
		String mRamDisponivel = request.getParameter("RamDiponivel");
		String mData = request.getParameter("Data");
		
		int idInformacoes = 0;
		try {
			idInformacoes = Integer.parseInt(mIdInformacoes);
			
		} catch (NumberFormatException e) {

		}
		
		int idMaquina = 0;
		try {
			idMaquina = Integer.parseInt(mIdMaquina);
			
		} catch (NumberFormatException e) {

		}
		
		double CPU = 0;
		try {
			CPU = Double.parseDouble(mCPU);
			
		} catch (NumberFormatException e) {

		}
		
		double HDTotal = 0;
		try {
			HDTotal = Double.parseDouble(mHDTotal);
			
		} catch (NumberFormatException e) {

		}
		
		double HDDisponivel = 0;
		try {
			HDDisponivel = Double.parseDouble(mHDDisponivel);
			
		} catch (NumberFormatException e) {

		}
		
		double HDUtilizado = 0;
		try {
			HDUtilizado = Double.parseDouble(mHDUtilizado);
			
		} catch (NumberFormatException e) {

		}
		
		double RamTotal = 0;
		try {
			RamTotal = Double.parseDouble(mRamTotal);
			
		} catch (NumberFormatException e) {

		}
		
		double RamDisponivel = 0;
		try {
			RamDisponivel = Double.parseDouble(mRamDisponivel);
			
		} catch (NumberFormatException e) {

		}
		
		double RamUtilizada = 0;
		try {
			RamUtilizada = Double.parseDouble(mRamUtilizada);
			
		} catch (NumberFormatException e) {

		}
		
		Informacoes informacoes = new Informacoes();
		
		informacoes.setIdInformacoes(idInformacoes);
		informacoes.setIdMaquina(idMaquina);
		informacoes.setCPU(CPU);
		informacoes.setHDTotal(HDTotal);
		informacoes.setHDDisponivel(HDDisponivel);
		informacoes.setHDUtilizado(HDUtilizado);
		informacoes.setRamTotal(RamTotal);
		informacoes.setRamDisponivel(RamDisponivel);
		informacoes.setRamUtilizada(RamUtilizada);
		
		
		InformacoesService is = new InformacoesService();
		informacoes = is.carregar();
		
		request.setAttribute("informacoes", informacoes);		
		
		RequestDispatcher view = request.getRequestDispatcher("Visualizar.jsp");
		
		
		view.forward(request, response);
	}

}
