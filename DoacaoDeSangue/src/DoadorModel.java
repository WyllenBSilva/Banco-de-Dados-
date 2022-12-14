
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DoadorModel {
    static int pegaId(Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "Select Max(id_doador) from doador";
        ResultSet result = st.executeQuery(sql);
        int id = 0;
        
            while(result.next()) {
                id = result.getInt(1);
            }
        id = id + 1;
        //System.out.println("Id+doador: "+id);
        return id;
    
    }
    static void create(DoadorBean d, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO doador (Documento, sexo,nome, peso, idade, apto, id_tiposanguineo,id_doador) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?,?)");
            st.setString(1, d.getDocumento());
            st.setString(2, String.valueOf(d.getSexo()));
            st.setString(3, d.getNome());
            st.setFloat(4, d.getPeso());
            st.setInt(5, d.getIdade());
            st.setBoolean(6, d.isApto());
            st.setInt(7, d.getTipoSanguineo());
            st.setInt(8, pegaId(con));
            st.execute();
            st.close();
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT documento, sexo , nome, peso, idade, apto, id_tiposanguineo FROM doador ";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new DoadorBean(result.getString(1),result.getString(2).charAt(0), result.getString(3), result.getFloat(4), 
                result.getInt(5), result.getBoolean(6), result.getInt(7)));
            }
        return list;
    }    

    
    static HashSet listAllNomeDosDoadores(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "select doadores.nome,t.tipo,t.fator_rh from (select d.* from bolsadesangue b join doador d on d.Id_Doador = b.Id_Doador group by d.Id_Doador) as doadores join tiposanguineo t on t.Id_tiposanguineo = doadores.Id_tiposanguineo";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            DoadorBean dt = new DoadorBean(result.getString(1));
            TipoSanguineo ts = new TipoSanguineo(result.getString(2), result.getString(3).charAt(0));
            dt.setTipoSanguineo2(ts);
            list.add(dt);
        }
        return list;
    }
    
    
}
