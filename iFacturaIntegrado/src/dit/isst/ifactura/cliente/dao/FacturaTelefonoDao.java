package dit.isst.ifactura.cliente.dao;

import java.util.List;

import dit.isst.ifactura.model.FacturaTelefono;

public interface FacturaTelefonoDao {

	/**
	 * Creates the.
	 *
	 * @param FacturaTelefono
	 *            the usuario cliente
	 * @return the usuario cliente
	 */
	FacturaTelefono create(FacturaTelefono facturaTelefono);

	/**
	 * Removes the.
	 *
	 * @param idUsario
	 *            the id usario
	 */
	void remove(Long idFactura);

	/**
	 * Merge.
	 *
	 * @param FacturaTelefono
	 *            the usuario cliente
	 * @return the usuario cliente
	 */
	FacturaTelefono merge(FacturaTelefono facturaTelefono);

	/**
	 * Gets the usuario.
	 *
	 * @param idFactura
	 *            the id factura
	 * @return the usuario
	 */
	FacturaTelefono getUsuario(Long idFactura);

	/**
	 * Gets the facturas by id.
	 *
	 * @param idUsuario
	 *            the id usuario
	 * @return the facturas by id
	 */
	List<FacturaTelefono> getFacturasById(Long idUsuario);

}
