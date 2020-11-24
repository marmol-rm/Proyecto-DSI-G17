package com.qyf.model;

public class DeptoResponse {
	
	private int deptartamento;
	private int jefe;
	
	public DeptoResponse() {
		super();
	}

	public DeptoResponse(int id_depto, int id_jefe) {
		super();
		this.deptartamento = id_depto;
		this.jefe = id_jefe;
	}

	public int getId_depto() {
		return deptartamento;
	}

	public void setId_depto(int id_depto) {
		this.deptartamento = id_depto;
	}

	public int getId_jefe() {
		return jefe;
	}

	public void setId_jefe(int id_jefe) {
		this.jefe = id_jefe;
	}
}
