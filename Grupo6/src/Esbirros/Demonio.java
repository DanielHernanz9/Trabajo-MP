package Grupo6.src.Esbirros;

public class Demonio extends EsbirroBase {
    private String pacto;
    private EsbirrosComposite subordinados;

    public Demonio(String nombre, String pacto) {
        super(nombre);
        this.pacto = pacto;
        this.subordinados = new EsbirrosComposite(nombre + "_Subordinados");
    }

    public void addSubordinado(EsbirroBase esbirro) {
        subordinados.add(esbirro);
    }

    public void removeSubordinado(EsbirroBase esbirro) {
        subordinados.remove(esbirro);
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
}