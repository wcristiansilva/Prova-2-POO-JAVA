import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Time argentina = new Time(2,"Argentina");
        Time brasil = new Time(1,"Brasil");
        Time uruguai = new Time(3,"Uruguai");
        Time bolivia = new Time(4,"Bolivia");

        Partida partida = new Partida(1,"10/ABR/2022", brasil, argentina);
        Partida partida2 = new Partida(2,"11/JUN/2022", uruguai, bolivia);

        partida.mostrarDados();
        partida.atualizarResultado(2,1);
        partida.mostrarDados();

        partida2.mostrarDados();
        partida2.atualizarResultado(3,2);
        partida2.mostrarDados();

        //Mostrar as Partidas totais
        Partida[] Partida = new Partida[0];
        for (Partida p : Partida){
            p.mostrarDados();
        }
    }
}