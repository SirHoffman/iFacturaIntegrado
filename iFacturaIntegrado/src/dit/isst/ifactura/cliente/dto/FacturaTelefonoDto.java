package dit.isst.ifactura.cliente.dto;

/**
 * The Class FacturaTelefonoDto.
 */
public class FacturaTelefonoDto {

	/** The id factura. */
	private Long idFactura;

	/** The fecha facturacion. */
	private String fechaFacturacion;

	/** The datos contradados. */
	private Float datosContratados;

	/** The datos consumidos. */
	private Float datosConsumidos;

	/** The voz contradada. */
	private Float vozContratada;

	/** The voz consumida. */
	private Float vozConsumida;

	/** The importe total. */
	private Float importeTotal;

	/** The id usuario. */
	private Long idUsuario;

	/** The es tarde. */
	private Boolean esTarde;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * Sets the id.
	 *
	 * @param idFactura
	 *            the id to set
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * Gets the fecha facturacion.
	 *
	 * @return the fechaFacturacion
	 */
	public String getFechaFacturacion() {
		return fechaFacturacion;
	}

	/**
	 * Sets the fecha facturacion.
	 *
	 * @param fechaFacturacion
	 *            the fechaFacturacion to set
	 */
	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	/**
	 * Gets the datos contradados.
	 *
	 * @return the datosContradados
	 */
	public Float getDatosContratados() {
		return datosContratados;
	}

	/**
	 * Sets the datos contradados.
	 *
	 * @param datosContradados
	 *            the datosContradados to set
	 */
	public void setDatosContratados(Float datosContradados) {
		this.datosContratados = datosContradados;
	}

	/**
	 * Gets the datos consumidos.
	 *
	 * @return the datosConsumidos
	 */
	public Float getDatosConsumidos() {
		return datosConsumidos;
	}

	/**
	 * Sets the datos consumidos.
	 *
	 * @param datosConsumidos
	 *            the datosConsumidos to set
	 */
	public void setDatosConsumidos(Float datosConsumidos) {
		this.datosConsumidos = datosConsumidos;
	}

	/**
	 * Gets the voz contradada.
	 *
	 * @return the vozContradada
	 */
	public Float getVozContratada() {
		return vozContratada;
	}

	/**
	 * Sets the voz contradada.
	 *
	 * @param vozContradada
	 *            the vozContradada to set
	 */
	public void setVozContratada(Float vozContradada) {
		this.vozContratada = vozContradada;
	}

	/**
	 * Gets the voz consumida.
	 *
	 * @return the vozConsumida
	 */
	public Float getVozConsumida() {
		return vozConsumida;
	}

	/**
	 * Sets the voz consumida.
	 *
	 * @param vozConsumida
	 *            the vozConsumida to set
	 */
	public void setVozConsumida(Float vozConsumida) {
		this.vozConsumida = vozConsumida;
	}

	/**
	 * Gets the importe total.
	 *
	 * @return the importeTotal
	 */
	public Float getImporteTotal() {
		return importeTotal;
	}

	/**
	 * Sets the importe total.
	 *
	 * @param importeTotal
	 *            the importeTotal to set
	 */
	public void setImporteTotal(Float importeTotal) {
		this.importeTotal = importeTotal;
	}

	/**
	 * Gets the id usuario.
	 *
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Gets the es tarde.
	 *
	 * @return the esTarde
	 */
	public Boolean getEsTarde() {
		return esTarde;
	}

	/**
	 * Sets the es tarde.
	 *
	 * @param esTarde
	 *            the esTarde to set
	 */
	public void setEsTarde(Boolean esTarde) {
		this.esTarde = esTarde;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datosConsumidos == null) ? 0 : datosConsumidos.hashCode());
		result = prime * result + ((datosContratados == null) ? 0 : datosContratados.hashCode());
		result = prime * result + ((esTarde == null) ? 0 : esTarde.hashCode());
		result = prime * result + ((fechaFacturacion == null) ? 0 : fechaFacturacion.hashCode());
		result = prime * result + ((idFactura == null) ? 0 : idFactura.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((importeTotal == null) ? 0 : importeTotal.hashCode());
		result = prime * result + ((vozConsumida == null) ? 0 : vozConsumida.hashCode());
		result = prime * result + ((vozContratada == null) ? 0 : vozContratada.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaTelefonoDto other = (FacturaTelefonoDto) obj;
		if (datosConsumidos == null) {
			if (other.datosConsumidos != null)
				return false;
		} else if (!datosConsumidos.equals(other.datosConsumidos))
			return false;
		if (datosContratados == null) {
			if (other.datosContratados != null)
				return false;
		} else if (!datosContratados.equals(other.datosContratados))
			return false;
		if (esTarde == null) {
			if (other.esTarde != null)
				return false;
		} else if (!esTarde.equals(other.esTarde))
			return false;
		if (fechaFacturacion == null) {
			if (other.fechaFacturacion != null)
				return false;
		} else if (!fechaFacturacion.equals(other.fechaFacturacion))
			return false;
		if (idFactura == null) {
			if (other.idFactura != null)
				return false;
		} else if (!idFactura.equals(other.idFactura))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (importeTotal == null) {
			if (other.importeTotal != null)
				return false;
		} else if (!importeTotal.equals(other.importeTotal))
			return false;
		if (vozConsumida == null) {
			if (other.vozConsumida != null)
				return false;
		} else if (!vozConsumida.equals(other.vozConsumida))
			return false;
		if (vozContratada == null) {
			if (other.vozContratada != null)
				return false;
		} else if (!vozContratada.equals(other.vozContratada))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FacturaTelefonoDto [idFactura=" + idFactura + ", fechaFacturacion=" + fechaFacturacion
				+ ", datosContradados=" + datosContratados + ", datosConsumidos=" + datosConsumidos + ", vozContradada="
				+ vozContratada + ", vozConsumida=" + vozConsumida + ", importeTotal=" + importeTotal + ", idUsuario="
				+ idUsuario + ", esTarde=" + esTarde + "]";
	}

}
