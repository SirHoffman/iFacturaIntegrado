
<table id="tabla_telefono" class="display well" cellspacing="0"
	width="100%">
	<thead>
		<tr>
			<th>Factura</th>
			<th>Fecha Facturacion</th>
			<th>Datos Contratados</th>
			<th>Datos Consumidos</th>
			<th>Voz Contratada</th>
			<th>Voz Consumida</th>
			<th>Importe</th>
			<th>Es Tarde</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${facturasTelefono}" var="item">
			<tr>
				<td>${item.idFactura}</td>
				<td>${item.fechaFacturacion}</td>
				<td>${item.datosContratados}</td>
				<td>${item.datosConsumidos}</td>
				<td>${item.vozContratada}</td>
				<td>${item.vozConsumida}</td>
				<td>${item.importeTotal}</td>
				<td>${item.esTarde}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
