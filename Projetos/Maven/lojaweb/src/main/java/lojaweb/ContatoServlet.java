package lojaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.maven.Produto;

@WebServlet(urlPatterns={"/contato"})
public class ContatoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        Produto produto = new Produto("bala", 15.0);    	
    	PrintWriter writer = resp.getWriter();
        writer.println("<html><h2>Entre em Contato</h2></html>");
        writer.close();
    }
}