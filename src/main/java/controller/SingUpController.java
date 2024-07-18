package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

@WebServlet("/SingUpController")
public class SingUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SingUpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/views/singUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			UsuarioDAO uDAO = new UsuarioDAOImpl();
			Usuario u = null;
			String nick = request.getParameter("nick");
			String correo = request.getParameter("email");
			String nombre = request.getParameter("name");
			String password = request.getParameter("password");
			int peso = Integer.parseInt(request.getParameter("weight"));
			int rolId = Integer.parseInt(request.getParameter("rolId"));
			String calle = request.getParameter("calle");
			String numeracion = request.getParameter("numeracion");
			// System.out.println(rolId);
			u = new Usuario(correo, nick, nombre, password, peso, rolId, calle, numeracion);
			Usuario uRSU = uDAO.read(u);
			if (uRSU.getId() != 0) {
				request.setAttribute("usuarioSU", u);
				getServletContext().getRequestDispatcher("/views/userAlreadyExist.jsp").forward(request, response);
			} else if (uRSU.getId() == 0 && u.getRolId() == 1) {
				List<Proveedor> proveedores = uDAO.readP();
				for (Proveedor p : proveedores) {
					System.out.println(p.toString());
				}
				;
				request.setAttribute("proveedores", proveedores);
				uDAO.create(u);
				List<Integer> idies = new ArrayList<>();
				List<Direccion> direcciones = uDAO.readD();
				for (Direccion d : direcciones) {
					int id = d.getUsuarioId();

					idies.add(id);
				}
				System.out.println(idies);
				/*List<Usuario> usuarios = new ArrayList<>();
				Usuario us = new Usuario();
				for (int id : idies) {
					us = uDAO.read(id);
					usuarios.add(us);
				}
				for(Usuario user: usuarios) {
					System.out.println(user);
				}*/
				List<Direccion>direccionesUsuarios= uDAO.readDU();
				request.setAttribute("usuario", u);
				request.setAttribute("direcciones", direccionesUsuarios);
				//request.setAttribute("usuarios", usuarios);
				getServletContext().getRequestDispatcher("/views/home.jsp").forward(request, response);
			} else if (uRSU.getId() == 0 && u.getRolId() != 1) {
				request.setAttribute("usuario", u);
				getServletContext().getRequestDispatcher("/views/home2.jsp").forward(request, response);
			}

		} catch (NumberFormatException e) {
			System.out.println("ERROR");
			getServletContext().getRequestDispatcher("/SingUpController").forward(request, response);
		}
	}

}
