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

import model.Informacoes;
import model.Maquina;
import service.InformacoesService;
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
		
		//String mIdMaquinas = request.getParameter("idMaquinas");
		// Request de maquinas
		String mHostname ;
		String mSO = request.getParameter("SO");
		String mDescricao = request.getParameter("descricao");
		if(request.getParameter("hostname") != null) {
			mHostname = request.getParameter("hostname");
		}else {
			mHostname = null;
		}
		
		//Request de informacoes
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
		
		
		
		Maquina maquina = new Maquina();
		//maquina.setIdMaquinas(idMaquinas);
		maquina.setHostname(mHostname);
		maquina.setSO(mSO);
		maquina.setDescricao(mDescricao);
		
		Informacoes informacoes = new Informacoes();
		
		//informacoes.setIdInformacoes(idInformacoes);
		//informacoes.setIdMaquina(idMaquina);
		//informacoes.setCPU(CPU);
		//informacoes.setHDTotal(HDTotal);
		//.setHDDisponivel(HDDisponivel);
		//informacoes.setHDUtilizado(HDUtilizado);
		//informacoes.setRamTotal(RamTotal);
		//informacoes.setRamDisponivel(RamDisponivel);
		//informacoes.setRamUtilizada(RamUtilizada);
		
		
		MaquinaService ms = new MaquinaService();
		ms.criar(maquina);
		maquina = ms.carregar();
		
		request.setAttribute("maquina", maquina);
		
		InformacoesService is = new InformacoesService();
		informacoes = is.carregar();
		
		request.setAttribute("informacoes", informacoes);	
		
		RequestDispatcher view = request.getRequestDispatcher("Visualizar.jsp");		
		
		view.forward(request, response);
		
	}
	
	/*
	 * String pNome = request.getParameter("nome");
	long pPopulacao = Long.parseLong(request.getParameter("populacao"));
	double pArea = Double.parseDouble(request.getParameter("area"));
	
	//instanciar o javabean
	Pais pais = new Pais();
	pais.setNome(pNome);
	pais.setPopulacao(pPopulacao);
	pais.setArea(pArea);
	
	//instanciar o service
	PaisService cs = new PaisService();
	cs.criar(pais);
	pais = cs.carregar(pais.getId());
	
	request.setAttribute("Pais", pais);
	
	RequestDispatcher view =
			request.getRequestDispatcher("Pais.jsp");
	 */

}
