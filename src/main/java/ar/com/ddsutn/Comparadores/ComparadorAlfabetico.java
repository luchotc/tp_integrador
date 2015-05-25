package ar.com.ddsutn.Comparadores;

import java.util.Comparator;

import ar.com.ddsutn.integrador.Receta;

public class ComparadorAlfabetico implements Comparator<Receta>
{
	@Override
	public int compare(Receta r1, Receta r2) {
		return (r1.getNombre().compareTo(r2.getNombre()));
	}
}
