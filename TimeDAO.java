import java.util.list;

public interface TimeDAO {
    void salvar(Time T);
    void atualizar(Time T);
    void excluir(Time T);
    Time buscar(int idTime);
    List<Time> listarTime();
}
