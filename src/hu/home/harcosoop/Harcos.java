package hu.home.harcosoop;

public class Harcos {

    //data fields
    private String nev;
    private int szint;
    private int tapasztalat;
    private int eletero;
    private int alapEletero;
    private int alapSebzes;


    //constructors
    public void Harcos(String nev, int statuszSablon){


    }

    //getters and setters
    public String getNev() {
        return nev;
    }

    public int getSzint() {
        return szint;
    }

    public int getTapasztalat() {
        return tapasztalat;
    }

    public int getEletero() {
        return eletero;
    }

    public int getAlapEletero() {
        return alapEletero;
    }

    public int getAlapSebzes() {
        return alapSebzes;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public void setTapasztalat(int tapasztalat) {
        this.tapasztalat = tapasztalat;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    //methods
    public int getSebzes(){

    }

    public int getSzintLepeshez(){

    }

    public int getMaxEletero(){

    }

    public void megkuzd(Harcos masikHarcos){

    }

    public void gyogyul(){

    }

    //overrides

    @Override
    public String toString() {
        return "Harcos{}";
    }
}
