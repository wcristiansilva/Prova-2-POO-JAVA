import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeSQliteDAO implements TimeDAO {
    @Override
    public void salvar(Time T) {
        String sql = "INSERT INTO time values (?)";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,T.getPais());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Time T) {
        String sql = "UPDATE time SET pais=? WHERE idTime=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,T.getPais());
            stmt.setString(2,T.getIdTime());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Time T) {
        String sql = "DELETE FROM time WHERE idTime=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,T.getIdTime());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Time buscar(int idTime) {
        String sql = "SELECT * FROM time WHERE idTime=?";
        Partido P = null;
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,idTime);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                T = new Time(rs.getInt("idTime"), rs.getString("pais"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return P;
    }

    @Override
    public List<Time> listarTime() {
        String sql = "SELECT * FROM time";
        List<Time> listarTime = new ArrayList<>();
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time T = new Time(rs.getInt("idTime"), rs.getString("pais"));
                listarTime.add(T);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listarTime;
    }
}
