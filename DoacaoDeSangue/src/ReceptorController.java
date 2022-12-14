import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;


public class ReceptorController {

    public void createReceptor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        // (Documento, sexo,nome, peso, idade, apto, id_tiposanguineo) "
        System.out.println("Insira os seguintes dados para a criar um novo Receptor: ");
        System.out.print("Documento: ");
        String Documento = input.next();
        clearBuffer(input);
        System.out.print("Sexo (H - Homem ou M - Mulher): ");
        char sexo = input.next().charAt(0);
        clearBuffer(input);
        System.out.print("nome: ");
        String nome = input.nextLine();
        //input.nextLine();
        System.out.print("tipoSanguineo (podendo ser 1 a 8): ");
        int tipoSanguineo = input.nextInt();        
        
        ReceptorBean db = new ReceptorBean(Documento, sexo,nome, tipoSanguineo);
        ReceptorModel.create(db, con);
        System.out.println("Receptor criado com sucesso!!");     
    }

    void listarReceptores(Connection con) throws SQLException {
        HashSet all = ReceptorModel.listAll(con);
        Iterator<ReceptorBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    
    void listarDataReceptores(Connection con) throws SQLException {
        HashSet all = ReceptorModel.listAllNomeDosDoadores(con);
        Iterator<ReceptorBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}


     
    





