public class ReceptorBean {
    private String Documento;
    private char Sexo;
    private String nome;
    private int tipoSanguineo;
    private Doacao doacao;
    
    public Doacao getDoacao() {
        return doacao;
    }
    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(Documento == null) {
            sb.append("Nome Receptor: " + nome + " Dt de Recebimento da Doacao: " + doacao);
            return sb.toString();
        }

        sb.append("[Receptor: " + nome + ", Doc: " + Documento + ", Sexo: " + Sexo + ", tipoSanguineo: "
        + tipoSanguineo + "]");
        return sb.toString();
    }
    public ReceptorBean(String nome) {
        this.nome = nome;
    }
    public ReceptorBean(String documento, char sexo, String nome, int tipoSanguineo) {
        Documento = documento;
        Sexo = sexo;
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
    }
    public String getDocumento() {
        return Documento;
    }
    public void setDocumento(String documento) {
        Documento = documento;
    }
    public char getSexo() {
        return Sexo;
    }
    public void setSexo(char sexo) {
        Sexo = sexo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(int tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    
}
