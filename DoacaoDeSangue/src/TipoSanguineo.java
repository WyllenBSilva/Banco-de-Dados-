public class TipoSanguineo {
    private String tipo;
    private char fator_rh;
    
    public TipoSanguineo(String tipo, char fator_rh) {
        this.tipo = tipo;
        this.fator_rh = fator_rh;
    }
    public String getTipo() {
        return tipo;
    }
    @Override
    public String toString() {
        return tipo + fator_rh;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public char getFator_rh() {
        return fator_rh;
    }
    public void setFator_rh(char fator_rh) {
        this.fator_rh = fator_rh;
    }
}
