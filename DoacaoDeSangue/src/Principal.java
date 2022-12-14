import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author rebeca
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new DoadorController().createDoador(con);
                            break;
                    case 2: new ReceptorController().createReceptor(con);
                            break;
                    case 3: new DoadorController().listarDoadores(con);
                            break;
                    case 4: new ReceptorController().listarReceptores(con);
                            break;
                    case 5: new ReceptorController().listarDataReceptores(con);
                            break;
                    case 6: new DoadorController().listarMedicosAmbulatorios(con);
                            break;
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<7);  
        con.close();
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o número da opção que desejas executar: ");
        System.out.println("1 - Inserir um novo Doador");
        System.out.println("2 - Inserir um novo Receptor");
        System.out.println("3 - Exibir todos os Doadores");
        System.out.println("4 - Exibir todos os Receptores");
        System.out.println("5 - Listar o nome e a data de recebimento de todos os receptores que receberam uma doacao de bolsa de sangue");
        System.out.println("6 - Listar o nome, tipo sanguíneo e fator rh dos doadores que fizeram uma doação de sangue");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
