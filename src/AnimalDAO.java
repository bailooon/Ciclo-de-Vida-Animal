
import java.sql.SQLException;
import java.util.Scanner;

public class AnimalDAO extends DAO {

    Scanner entrada = new Scanner(System.in);

    public AnimalDAO() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    //Método para o nascimento de um Animal
    public void nascer(Animal animal) {
        int idAnimal = 0;
        try {
            connection.setAutoCommit(false);
            sql = "select max(id) as maior from animais";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idAnimal = rs.getInt("maior");
            }
            sql = "insert into animais values(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idAnimal == 0 ? 1 : idAnimal + 1);
            System.out.println("Digite o nome do animal:");
            String nome = entrada.next();
            animal.setNome(nome);
            ps.setString(2, animal.getNome());
            System.out.println("Digite a classe do animal:");
            String classe = entrada.next();
            animal.setClasse(classe);
            ps.setString(3, animal.getClasse());
            System.out.println("Digite a família do animal:");
            String familia = entrada.next();
            animal.setFamilia(familia);
            ps.setString(4, animal.getFamilia());
            ps.setInt(5, 10);
            ps.setInt(6, 10);
            ps.setInt(7, 0);
            ps.setBoolean(8, true);
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("erro ao cadastrar animal\n" + e);
        }
    }

    //Método para a morte de um Animal
    public void morrer(Animal animal) {
        try {
            connection.setAutoCommit(false);
            sql = "update animais set forca = 0, caloria = 0, estado = 0 where id = (?)";
            ps = connection.prepareStatement(sql);
            System.out.println("Insira o ID do Animal que vai morrer:");
            int id = entrada.nextInt();
            animal.setId(id);
            ps.setInt(1, animal.getId());
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("erro ao matar animal\n" + e);
        }
    }

    //Método para o animal comer
    public void comer(Animal animal) {
        int caloria = 0;
        boolean estado = false;
        try {
            System.out.println("Insira o ID do Animal que vai comer:");
            int id = entrada.nextInt();
            animal.setId(id);
            connection.setAutoCommit(false);
            sql = "select caloria, estado from animais where id = (?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, animal.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                caloria = rs.getInt("caloria");
                estado = rs.getBoolean("caloria");
            }
            if (caloria >= 100 || estado == false) {
                System.out.println("O animal não pode comer");
            } else {
                sql = "update animais set caloria = animais.caloria + 10, forca = animais.forca - 2 where id = (?)";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, animal.getId());
                ps.execute();
                connection.commit();
                sql = "select caloria from animais where id = (?)";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, animal.getId());
                rs = ps.executeQuery();
                if (rs.next()) {
                    caloria = rs.getInt("caloria");
                }
                if (caloria > 100) {
                    sql = "update animais set caloria = 100 where id = (?)";
                    ps = connection.prepareStatement(sql);
                    ps.setInt(1, animal.getId());
                    ps.execute();
                    connection.commit();
                }
            }

        } catch (SQLException e) {
            System.out.println("erro ao alimentar animal\n" + e);
        }

    }

}
