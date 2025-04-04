import java.sql.SQLException;

public class AnimalDAO extends DAO{

    public AnimalDAO() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    public void nascer(Animal animal){
        try {
            connection.setAutoCommit(false);
        sql = "insert into animais values(?, ?, ?, ?, ?, ?, ?, ?)";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, 02);
        ps.setString(2, animal.getNome());
        ps.setString(3, animal.getClasse());
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
        

}

    
