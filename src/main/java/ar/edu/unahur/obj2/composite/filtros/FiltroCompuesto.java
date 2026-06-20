package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.agrupable.Agrupable;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto implements Agrupable {
    private List<Agrupable> filtros = new ArrayList<>();

    public FiltroCompuesto(List<Agrupable> filtros) {
        this.filtros = filtros;
    }

    public void agregarFiltro(Agrupable filtro) {
        filtros.add(filtro);
    }

    @Override
    public Boolean aplicar() {
        return filtros.stream().allMatch(f -> f.aplicar());
    }
    // recursividad 
    // fin

}
