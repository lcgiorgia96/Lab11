package it.polito.tdp.bar.model;

import java.time.LocalTime;

public class Tavolo implements Comparable<Tavolo>{

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
		result = prime * result + (occupato ? 1231 : 1237);
		result = prime * result + ((oraArrivo == null) ? 0 : oraArrivo.hashCode());
		result = prime * result + ((oraVia == null) ? 0 : oraVia.hashCode());
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
		if (occupato != other.occupato)
			return false;
		if (oraArrivo == null) {
			if (other.oraArrivo != null)
				return false;
		} else if (!oraArrivo.equals(other.oraArrivo))
			return false;
		if (oraVia == null) {
			if (other.oraVia != null)
				return false;
		} else if (!oraVia.equals(other.oraVia))
			return false;
		if (posti != other.posti)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return posti+" "+occupato+" "+oraArrivo+" "+oraVia;
	}

	@Override
	public int compareTo(Tavolo o) {
		
		return (this.posti-o.posti);
	}
	
	
}
