package dit.isst.ifactura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import dit.isst.ifactura.cliente.dao.FacturaTelefonoDao;
import dit.isst.ifactura.cliente.dao.UsuarioClienteDao;
import dit.isst.ifactura.cliente.dao.impl.FacturaTelefonoDaoImpl;
import dit.isst.ifactura.cliente.dao.impl.UsuarioClienteDaoImpl;
import dit.isst.ifactura.cliente.dto.FacturaTelefonoDto;
import dit.isst.ifactura.model.FacturaTelefono;
import dit.isst.ifactura.model.UsuarioCliente;

@SuppressWarnings("serial")
public class IFacturaIntegradoClienteLoginServlet extends HttpServlet {

	// CLASE INICIAL
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		RequestDispatcher view = null;
		if (req.getUserPrincipal() != null) {
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			UsuarioClienteDao usuarioClienteDao = UsuarioClienteDaoImpl.getInstance();
			UsuarioCliente usuarioCliente = usuarioClienteDao.getUsuarioByMail(user);
			Long idUsuario;
			if (usuarioCliente != null) {
				idUsuario = usuarioCliente.getId();
			} else {
				UsuarioCliente newUser = new UsuarioCliente();
				newUser.setUsuario(user);
				UsuarioCliente usuarioNuevo = usuarioClienteDao.create(newUser);
				idUsuario = usuarioNuevo.getId();
			}
			// Se buscan todas las facturas en BBDD relativas al usuario y se
			// envian
			// a la vista
			FacturaTelefonoDao FacturaTelefonoDao = FacturaTelefonoDaoImpl.getInstance();

			obtenerFacturasTelefono(req, FacturaTelefonoDao, idUsuario);

			req.getSession().setAttribute("idUser", idUsuario);

			view = req.getRequestDispatcher("/JSP/Home.jsp");
		} else {
			view = req.getRequestDispatcher("/JSP/Login.jsp");
		}
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);

		view.forward(req, resp);

	}

	private void obtenerFacturasTelefono(HttpServletRequest req, FacturaTelefonoDao FacturaTelefonoDao,
			Long idUsuario) {
		List<FacturaTelefono> facturasTelefono = FacturaTelefonoDao.getFacturasById(idUsuario);
		List<FacturaTelefonoDto> facturasObtenidas = new ArrayList<FacturaTelefonoDto>();
		if (facturasTelefono != null && !facturasTelefono.isEmpty()) {
			req.setAttribute("existenFacturasTelefono", true);
			for (FacturaTelefono factura : facturasTelefono) {
				FacturaTelefonoDto facturaDevuelta = new FacturaTelefonoDto();
				facturaDevuelta.setIdFactura(factura.getIdFactura());
				facturaDevuelta.setIdUsuario(factura.getIdUsuario());
				facturaDevuelta.setFechaFacturacion(factura.getFechaFacturacion().toString());
				facturaDevuelta.setDatosContratados(factura.getDatosContratados());
				facturaDevuelta.setDatosConsumidos(factura.getDatosConsumidos());
				facturaDevuelta.setImporteTotal(factura.getImporteTotal());
				facturaDevuelta.setVozConsumida(factura.getVozConsumida());
				facturaDevuelta.setVozContratada(factura.getVozContratada());
				facturaDevuelta.setEsTarde(factura.getEsTarde());

				facturasObtenidas.add(facturaDevuelta);
			}
			req.setAttribute("facturasTelefono", facturasObtenidas);
		}
	}
}
