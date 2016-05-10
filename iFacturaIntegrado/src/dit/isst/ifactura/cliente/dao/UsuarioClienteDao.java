package dit.isst.ifactura.cliente.dao;

import dit.isst.ifactura.model.UsuarioCliente;

/**
 * The Interface UsuarioClienteDao.
 */
public interface UsuarioClienteDao {

	/**
	 * Creates the.
	 *
	 * @param usuarioCliente
	 *            the usuario cliente
	 * @return the usuario cliente
	 */
	UsuarioCliente create(UsuarioCliente usuarioCliente);

	/**
	 * Removes the.
	 *
	 * @param idUsario
	 *            the id usario
	 */
	void remove(Long idUsario);

	/**
	 * Merge.
	 *
	 * @param usuarioCliente
	 *            the usuario cliente
	 * @return the usuario cliente
	 */
	UsuarioCliente merge(UsuarioCliente usuarioCliente);

	/**
	 * Gets the usuario.
	 *
	 * @param idUsuario
	 *            the id usuario
	 * @return the usuario
	 */
	UsuarioCliente getUsuario(Long idUsuario);

	/**
	 * Gets the usuario by mail.
	 *
	 * @return the usuario by mail
	 */
	UsuarioCliente getUsuarioByMail(String usuario);

}
