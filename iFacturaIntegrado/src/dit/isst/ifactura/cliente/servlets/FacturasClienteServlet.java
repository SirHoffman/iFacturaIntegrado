package dit.isst.ifactura.cliente.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dit.isst.ifactura.cliente.dao.FacturaTelefonoDao;
import dit.isst.ifactura.cliente.dao.impl.FacturaTelefonoDaoImpl;
import dit.isst.ifactura.cliente.dto.FacturaTelefonoDto;
import dit.isst.ifactura.model.FacturaTelefono;

@SuppressWarnings("serial")
public class FacturasClienteServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		FacturaTelefonoDao FacturaTelefonoDao = FacturaTelefonoDaoImpl.getInstance();

		Long idUsuario = (Long) req.getSession().getAttribute("idUser");
		saveFacturaTelefono(req, FacturaTelefonoDao, idUsuario);

		obtenerFacturasTelefono(req, FacturaTelefonoDao, idUsuario);

		RequestDispatcher view = req.getRequestDispatcher("/JSP/Home.jsp");

		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save factura telefono.
	 *
	 * @param req
	 *            the req
	 * @param FacturaTelefonoDao
	 *            the i factura dao
	 * @param idUsuario
	 */
	private void saveFacturaTelefono(HttpServletRequest req, FacturaTelefonoDao FacturaTelefonoDao, Long idUsuario) {
		Float importeTotal = Float.parseFloat(req.getParameter("importeTotal"));
		Float datosContratados = Float.parseFloat(req.getParameter("datosContratados"));
		Float datosConsumidos = Float.parseFloat(req.getParameter("datosConsumidos"));
		Boolean esTarde = Boolean.parseBoolean("esTarde");
		Float vozContratada = Float.parseFloat(req.getParameter("vozContratada"));
		Float vozConsumida = Float.parseFloat(req.getParameter("vozConsumida"));

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaFacturacion = new Date();
		try {
			fechaFacturacion = formatter.parse(req.getParameter("fechaFacturacion"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		FacturaTelefono newFacturaTelefono = new FacturaTelefono();
		newFacturaTelefono.setIdUsuario(idUsuario);
		newFacturaTelefono.setImporteTotal(importeTotal);
		newFacturaTelefono.setDatosContratados(datosContratados);
		newFacturaTelefono.setDatosConsumidos(datosConsumidos);
		newFacturaTelefono.setEsTarde(esTarde);
		newFacturaTelefono.setVozContratada(vozContratada);
		newFacturaTelefono.setVozConsumida(vozConsumida);
		newFacturaTelefono.setFechaFacturacion(fechaFacturacion);

		FacturaTelefonoDao.create(newFacturaTelefono);

	}

	/**
	 * Obtener facturas telefono.
	 *
	 * @param req
	 *            the req
	 * @param FacturaTelefonoDao
	 *            the ifactura dao
	 * @param idUsuario
	 */
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
