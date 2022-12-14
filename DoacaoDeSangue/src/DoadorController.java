import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class DoadorController {
    public void createDoador(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        // (Documento, sexo,nome, peso, idade, apto, id_tiposanguineo) "
        System.out.println("Insira os seguintes dados para a criar um novo Doador: ");
        System.out.print("Documento: ");
        String Documento = input.next();
        clearBuffer(input);
        System.out.print("Sexo (H - Homem ou M - Mulher): ");
        char sexo = input.next().charAt(0);
        clearBuffer(input);
        System.out.print("nome: ");
        String nome = input.nextLine();
        //input.nextLine();
        input.useLocale(Locale.US);
        System.out.println("Peso (use ponto ao inves de virgula): ");
        float peso = input.nextFloat();
        clearBuffer(input);
        System.out.print("idade: ");
        int idade = input.nextInt();
        System.out.print("Apto? (true or false): ");
        boolean apto = input.nextBoolean();    
        System.out.print("tipoSanguineo (podendo ser 1 a 8): ");
        int tipoSanguineo = input.nextInt();        
        
        DoadorBean db = new DoadorBean(Documento, sexo,nome,peso, idade, apto, tipoSanguineo);
        DoadorModel.create(db, con);
        System.out.println("Doador criado com sucesso!!");     
    }

    void listarDoadores(Connection con) throws SQLException {
        HashSet all = DoadorModel.listAll(con);
        Iterator<DoadorBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    
    void listarMedicosAmbulatorios(Connection con) throws SQLException {
        HashSet all = DoadorModel.listAllNomeDosDoadores(con);
        Iterator<DoadorBean> it = all.iterator();
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




