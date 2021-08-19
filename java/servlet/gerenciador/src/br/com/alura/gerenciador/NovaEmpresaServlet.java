package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	//se eu usar o metodo doPost, ele obriga que seja so post e doGet da mesma forma.
	// eh so mudar de service para o nome que deseja. service da suporte aos 2.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa =request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco(); // simular um banco de dados
		banco.adiciona(empresa);
		
		//chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome()); //pendurando um atributo. O apelido e o objeto
		rd.forward(request, response);
		
		// forma antiga de fazer
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa "+ nomeEmpresa +" cadastrada com sucesso</body></html>");
		// para mandar parametro, eh '?' dps do link e nome do parametro e seu valor.
		// localhost:8080/gerenciador/novaEmpresa?nome=Alura
		
		//vc pode enviar parametro por URL ou de outra forma
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
/*Formas de enviar requisições
 * 1) GET, enviando por parâmetro na URL. Envia info para o servidor para receber informações.
 * 		Por exemplo, busca do alura. Nao eh ideal usá-lo para alterar informacoes no sistema.
 * 2)POST, para postar infos, para enviar infos ao servidor/ alterar!
 * 	Ele esconde os parametros dentro do corpo da URL. 
 *  Nele, eh necessario um form.
 * */
 