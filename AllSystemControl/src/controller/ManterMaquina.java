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
		String mAcao = request.getParameter("acao");
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
		MaquinaService ms = new MaquinaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (mAcao.equals("Criar")) {
			ms.criar(maquina);
			ArrayList<Maquina> lista = new ArrayList<>();
			
			lista.add(maquina);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarPaises.jsp");
		} else if (mAcao.equals("Excluir")) {
			ms.excluir(maquina.getIdMaquinas());
			ArrayList<Maquina> lista = (ArrayList<Maquina>)session.getAttribute("lista");
			lista.remove(busca(maquina, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarPaises.jsp");
		} else if (mAcao.equals("Alterar")) {
			ms.atualizar(maquina);
			ArrayList<Maquina> lista = (ArrayList<Maquina>) session.getAttribute("lista");
			int pos = busca(maquina, lista);
			lista.remove(pos);
			lista.add(pos, maquina);
			session.setAttribute("lista", lista);
			request.setAttribute("pais", maquina);
			view = request.getRequestDispatcher("VisualizarMaquina.jsp");
		} else if (mAcao.equals("Visualizar")) {
			maquina = ms.carregar(maquina.getIdMaquinas());
			request.setAttribute("maquina", maquina);
			view = request.getRequestDispatcher("VisualizarMaquina.jsp");
		} else if (mAcao.equals("Editar")) {
			maquina = ms.carregar(maquina.getIdMaquinas());
			request.setAttribute("maquina", maquina);
			view = request.getRequestDispatcher("AlterarMaquina.jsp");
		}
		view.forward(request, response);
	}
	
	public int busca(Maquina maquina, ArrayList<Maquina> lista) {
		Maquina to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdMaquinas() == maquina.getIdMaquinas()) {
				return i;
			}
		}
		return -1;
	}

}
