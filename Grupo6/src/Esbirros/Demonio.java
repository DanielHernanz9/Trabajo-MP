package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

public class Demonio extends EsbirroBase {
    private String pacto;
    private EsbirrosComposite subordinados;

    public Demonio(){
        super();

    }

    public void registrarDemonio(String nombre, String pacto) {
        this.Nombre = nombre;
        this.pacto = pacto;
        EsbirrosComposite NewSubordinados = new EsbirrosComposite();
        NewSubordinados.setNombre(nombre + "_Subordinados");
        this.subordinados = NewSubordinados;
    }

    public EsbirrosComposite getSubordinados() {
        return subordinados;
    }

    @Override
    public int recibirDaño() {
        if (!subordinados.getChildren().isEmpty()) {
            // Aplica daño al último esbirro subordinado
            subordinados.recibirDaño();
        } else {
            // Si no hay subordinados, el demonio recibe el daño
            return super.recibirDaño();
        }
        return getSalud();
    }

    public String getPacto(){
        return this.pacto;
    }

    public void setSubordinados(EsbirrosComposite subordinados) {
        this.subordinados = subordinados;
    }

    public void setPacto(String pacto) {
        this.pacto = pacto;
    }

}