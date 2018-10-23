package com.empresa.model.dto;

public class DtoVendedor {

		private String nombre;
		
		private String telefono;
		
		private int idempresa;
		
		public DtoVendedor() {}
		
		public DtoVendedor(String nombre, String telefono, int idempresa) {
			super();
			this.nombre = nombre;
			this.telefono = telefono;
			this.idempresa = idempresa;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public int getIdempresa() {
			return idempresa;
		}

		public void setIdempresa(int idempresa) {
			this.idempresa = idempresa;
		}

		
	
}
