import java.util.List;

public interface PartidaDAO {
    void salvar(Partida P);
    void atualizar(Partida P);
    void excluir(Partida P);
    Partida buscar(String dataJogo);
    List<Partida> ListarPartida();
}
