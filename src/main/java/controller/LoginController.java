package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.*;
import model.dto.Direccion;
import model.dto.Proveedor;
import model.dto.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO uDAO = new UsuarioDAOImpl();
		String correo = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario u = new Usuario(correo, password);
		Usuario ur = uDAO.read(u);
		int userId = ur.getId();
		System.out.println(userId);
		int rol = uDAO.readRol(userId);
		System.out.println(rol);

		if (userId != 0 && rol == 1) {
			List<Direccion> direccionesUsuarios = uDAO.readDU();
			request.setAttribute("usuario", u);
			request.setAttribute("direcciones", direccionesUsuarios);
			request.setAttribute("usuario", ur);
			List<Proveedor> proveedores = uDAO.readP();
			request.setAttribute("proveedores", proveedores);
			getServletContext().getRequestDispatcher("/views/home.jsp").forward(request, response);
		} else if (userId != 0 && rol == 2) {
			request.setAttribute("usuario", ur);
			getServletContext().getRequestDispatcher("/views/home2.jsp").forward(request, response);
		} else if (userId == 0) {
			getServletContext().getRequestDispatcher("/views/userNotFound.jsp").forward(request, response);
		}

	}

}
