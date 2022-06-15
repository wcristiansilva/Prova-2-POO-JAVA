import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidaSQliteDAO implements PartidaDAO {

    @Override
    public void salvar(Partida P) {
        String sql = "INSERT INTO partida values (?,?,?,?,?)";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,P.getDataJogo());
            stmt.setString(2,P.getTime1().getPais());
            stmt.setString(3,P.getTime2().getPais());
            stmt.setInt(4,P.getPlacarTime1());
            stmt.setInt(5,P.getPlacarTime2());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Partida P) {
        String sql = "UPDATE partida SET dataJogo=?, time1=?, time2=?, PlacarTime1=?, PlacarTime2=? WHERE idPartida=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,P.getDataJogo());
            stmt.setInt(2,P.getTime1().getIdTime());
            stmt.setInt(3,P.getTime2().getIdTime());
            stmt.setInt(4,P.getPlacarTime1());
            stmt.setInt(5,P.getPlacarTime2());
            stmt.setInt(6,P.getIdPartida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Partida P) {
        String sql = "DELETE FROM partida WHERE idPartida=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,P.getIdPartida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partida buscar(String dataJogo) {
        String sql = "SELECT * FROM partida WHERE idPartida=?";
        Partida P=null;
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,dataJogo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time time1 = new TimeSQliteDAO().buscar(rs.getInt("idTime"));
                Time time2 = new TimeSQliteDAO().buscar(rs.getInt("idTime"));
                P = new Partida(rs.getInt("idPartida"), rs.getString("dataJogo"), rs.getInt("PlacarTime1"), rs.getInt("PlacarTime2"), time1, time2);
                //não sabia se precisava buscar e mostrar no lugar de time mas um valor como time2.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return P;
    }

    @Override
    public List<Partida> ListarPartida() {
        String sql = "SELECT * FROM partida";
        List<Partida> ListarPartida = new ArrayList<>();
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time time1 = new TimeSQliteDAO().buscar(rs.getInt("idTime"));
                Time time2 = new TimeSQliteDAO().buscar(rs.getInt("idTime"));
                Partida P = new Partida(rs.getInt("idPartida"), rs.getString("dataJogo"), rs.getInt("placarTime1"), rs.getInt("placarTime2"), time1, time2);
                ListarPartida.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListarPartida;
    }
}
