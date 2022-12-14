import java.sql.Date;

public class Doacao {
    private int Id_receptor;
    private int Id_doacao;
    private int Id_bolsa;
    private Date datarecebimento;
    
    @Override
    public String toString() {
        return " " + datarecebimento;
    }

    public Doacao(Date datarecebimento) {
        this.datarecebimento = datarecebimento;
    }
    
    public int getId_receptor() {
        return Id_receptor;
    }
    public void setId_receptor(int id_receptor) {
        Id_receptor = id_receptor;
    }
    public int getId_doacao() {
        return Id_doacao;
    }
    public void setId_doacao(int id_doacao) {
        Id_doacao = id_doacao;
    }
    public int getId_bolsa() {
        return Id_bolsa;
    }
    public void setId_bolsa(int id_bolsa) {
        Id_bolsa = id_bolsa;
    }
    public Date getDatarecebimento() {
        return datarecebimento;
    }
    public void setDatarecebimento(Date datarecebimento) {
        this.datarecebimento = datarecebimento;
    }

    


}
