package it.polito.tdp.bar.model;

import java.time.LocalTime;

public class Tavolo {

	private int posti;
	private boolean occupato;
	private LocalTime oraArrivo;
	private LocalTime oraVia;
	
	public Tavolo(int posti, boolean occupato, LocalTime oraArrivo, LocalTime oraVia) {
		super();
		this.posti = posti;
		this.occupato = occupato;
		this.oraArrivo = oraArrivo;
		this.oraVia = oraVia;
	}
	
	public LocalTime getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(LocalTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public LocalTime getOraVia() {
		return oraVia;
	}

	public void setOraVia(LocalTime oraVia) {
		this.oraVia = oraVia;
	}

	public boolean getOccupato() {
		return occupato;
	}
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	public int getPosti() {
		return posti;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + posti;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (posti != other.posti)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return posti+" "+occupato+" "+oraArrivo+" "+oraVia;
	}
	
	
}
