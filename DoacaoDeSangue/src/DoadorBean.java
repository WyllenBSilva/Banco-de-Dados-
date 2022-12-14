public class DoadorBean {
    private String Documento;
    private char Sexo;
    private String nome;
    private float peso;
    private int idade;
    private boolean apto;
    private int tipoSanguineo;
    private TipoSanguineo tipoSanguineo2;

    public TipoSanguineo getTipoSanguineo2() {
        return tipoSanguineo2;
    }

    public void setTipoSanguineo2(TipoSanguineo tipoSanguineo2) {
        this.tipoSanguineo2 = tipoSanguineo2;
    }

    public DoadorBean(String nome) {
        this.nome = nome;
    }

    public DoadorBean(String documento, char sexo, String nome, float peso, int idade, boolean apto,
            int tipoSanguineo) {
        Documento = documento;
        Sexo = sexo;
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.apto = apto;
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public DoadorBean(String documento, String nome, float peso, int idade, boolean apto, int tipoSanguineo) {
        Documento = documento;
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.apto = apto;
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
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public boolean isApto() {
        return apto;
    }
    public void setApto(boolean apto) {
        this.apto = apto;
    }
    public int getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(int tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(Documento == null) {
            sb.append("Nome Doador: " + nome + " Tipo Sanguíneo: " + tipoSanguineo2);
            return sb.toString();
        }

        sb.append("[Doador: " + nome + " Doc: " + Documento + ", Sexo: " + Sexo + ", peso=" + peso
        + ", idade:" + idade + ", apto: " + apto + ", tipoSanguineo: " + tipoSanguineo  +"]");
        return sb.toString();
      
        
    }
    

    
    
    

    
}
