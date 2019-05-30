package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;

public class Evento implements Comparable<Evento>{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((durata == null) ? 0 : durata.hashCode());
		result = prime * result + num_persone;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + Float.floatToIntBits(tolleranza);
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
		Evento other = (Evento) obj;
		if (durata == null) {
			if (other.durata != null)
				return false;
		} else if (!durata.equals(other.durata))
			return false;
		if (num_persone != other.num_persone)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (tipo != other.tipo)
			return false;
		if (Float.floatToIntBits(tolleranza) != Float.floatToIntBits(other.tolleranza))
			return false;
		return true;
	}


	public enum TipoEvento{
		ARRIVO_GRUPPO_CLIENTI,
		USCITA
	}
	private LocalTime time;
	private int num_persone;
	private Duration durata;
	private float tolleranza;
	private TipoEvento tipo;
	
	
	public Evento(LocalTime time, int num_persone, Duration durata, float tolleranza,TipoEvento tipo) {
		super();
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.tipo=tipo;
	}


	public TipoEvento getTipo() {
		return tipo;
	}


	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public int getNum_persone() {
		return num_persone;
	}


	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}


	public Duration getDurata() {
		return durata;
	}


	public void setDurata(Duration durata) {
		this.durata = durata;
	}


	public float getTolleranza() {
		return tolleranza;
	}


	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}


	@Override
	public String toString() {
		return time+" "+num_persone+" "+durata.toMinutes()+" "+tolleranza+" "+tipo+"\n";
	}


	@Override
	public int compareTo(Evento o) {
		
		return this.time.compareTo(o.time);
	}
	

}
