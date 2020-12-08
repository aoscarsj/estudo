package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Essa classe eh um servlet
@WebServlet(urlPatterns = "/oi") //OiMundoServlet se chama /oi
public class OiMundoServlet extends HttpServlet{ 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		// req: obj de requisição, resp: obj que representa/gera a resposta
		
		//vai ser binario (getOutputStream) ou caracteres(getWriter)? 
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Hello World! Parabéns! Você escreveu seu primeiro código servlet.</h2>");
		out.println("<h2>Hello World! Parabéns! Você escreveu seu primeiro código servlet.</h2>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet OiMundoServlet foi chamado");
	}
}
