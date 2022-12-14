
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceptorModel {

    static int pegaId(Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "Select Max(id_receptor) from receptor";
        ResultSet result = st.executeQuery(sql);
        int id = 0;
        
            while(result.next()) {
                id = result.getInt(1);
            }

        id = id + 1;
        //System.out.println("Id+receptor: "+id);
        return id;
    
    }
    static void create(ReceptorBean r, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO receptor (Documento, sexo,nome, id_tiposanguineo,id_receptor) "
                    + "VALUES (?, ?,?, ?,?)");
            st.setString(1, r.getDocumento());
            st.setString(2, String.valueOf(r.getSexo()));
            st.setString(3, r.getNome());
            st.setInt(4, r.getTipoSanguineo());
            st.setInt(5, pegaId(con));
            st.execute();
            st.close();
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT documento, sexo , nome, id_tiposanguineo FROM receptor ";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new ReceptorBean(result.getString(1),result.getString(2).charAt(0), result.getString(3), result.getInt(4)));
            }
        return list;
    }    

    
    static HashSet listAllNomeDosDoadores(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "select r.nome,d.datarecebimento from receptor r join doacao d on d.id_receptor = r.id_receptor";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            ReceptorBean rb = new ReceptorBean(result.getString(1));
            Doacao Dc = new Doacao(result.getDate(2));
            rb.setDoacao(Dc);
            list.add(rb);
        }
        return list;
    }
}
