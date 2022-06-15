public class Time {
    private int idTime;
    private String pais;

    public Time(int idTime, String pais) {
        this.idTime = idTime;
        this.pais = pais;
    }

    public void mostrarDados(){
        System.out.println(" Id Equipe " + this.idTime + " Equipe do " + this.pais );
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }
}
