package dit.isst.ifactura.cliente.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dit.isst.ifactura.cliente.dao.UsuarioClienteDao;
import dit.isst.ifactura.emf.EMFService;
import dit.isst.ifactura.model.UsuarioCliente;

public class UsuarioClienteDaoImpl implements UsuarioClienteDao {

	/** The instance. */
	private static UsuarioClienteDaoImpl instance;

	/**
	 * Instantiates a new i factura dao impl.
	 */
	private UsuarioClienteDaoImpl() {
	}

	/**
	 * Gets the single instance of IFacturaDaoImpl.
	 *
	 * @return single instance of IFacturaDaoImpl
	 */
	public static UsuarioClienteDaoImpl getInstance() {
		if (instance == null) {
			instance = new UsuarioClienteDaoImpl();
		}
		return instance;
	}

	@Override
	public UsuarioCliente create(UsuarioCliente usuarioCliente) {
		EntityManager em = EMFService.get().createEntityManager();
		em.persist(usuarioCliente);
		em.close();
		return usuarioCliente;
	}

	@Override
	public void remove(Long idUsario) {
		EntityManager em = EMFService.get().createEntityManager();
		UsuarioCliente userToRemove = em.find(UsuarioCliente.class, idUsario);
		if (userToRemove != null) {
			em.remove(userToRemove);
		}
		em.close();
	}

	@Override
	public UsuarioCliente merge(UsuarioCliente usuarioCliente) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(usuarioCliente);
		em.close();
		return usuarioCliente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UsuarioCliente getUsuario(Long idUsuario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select u from UsuarioCliente u where idUsuario = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<UsuarioCliente> usuarios = query.getResultList();
		UsuarioCliente usuarioReturn = null;
		if (!usuarios.isEmpty() && usuarios.size() == 1) {
			usuarioReturn = usuarios.get(0);
		} else {
			// Si llega a este punto tenemos un problema
		}
		em.close();
		return usuarioReturn;
	}

	@Override
	public UsuarioCliente getUsuarioByMail(String usuario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select u from UsuarioCliente u where usuario = :usuario");
		query.setParameter("usuario", usuario);
		List<UsuarioCliente> usuarios = query.getResultList();
		UsuarioCliente usuarioReturn = null;
		if (!usuarios.isEmpty() && usuarios.size() == 1) {
			usuarioReturn = usuarios.get(0);
		} else {
			// Si llega a este punto tenemos un problema
		}
		em.close();
		return usuarioReturn;
	}

}
