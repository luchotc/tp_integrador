package ar.com.ddsutn.Comparadores;

import java.util.Comparator;

import ar.com.ddsutn.integrador.Receta;

class ComparadorCalorias implements Comparator<Receta> {
    @Override
    public int compare(Receta a, Receta b) {
    	int caloriasA = a.getTotalCalorias();
    	int caloriasB = b.getTotalCalorias();
        return caloriasA < caloriasB ? -1 : caloriasA == caloriasB ? 0 : 1;
    }
}
