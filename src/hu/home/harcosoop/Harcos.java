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
    public Harcos(String nev, int statuszSablon){
        this.nev = nev;
        this.szint = 1;
        this.tapasztalat = 0;
        switch (statuszSablon){
            case 1:
                this.alapEletero = 15;
                this.alapSebzes = 3;
                break;
            case 2:
                this.alapEletero = 12;
                this.alapSebzes = 4;
                break;
            case 3:
                this.alapEletero = 8;
                this.alapSebzes = 5;
                break;
        }
        this.eletero = getMaxEletero();
    }

    //getters
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

    //setters
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
        return this.alapSebzes + this.szint;
    }

    public int getSzintLepeshez(){
        return 10 + this.szint*5;
    }

    public int getMaxEletero(){
        return this.alapEletero + szint*3;
    }

    public void megkuzd(Harcos masikHarcos){
        if (this == masikHarcos){
            System.out.println("Hiba! A megadott harcos nem megfelelő");
            return;
        }
        if (this.getEletero() == 0 ||masikHarcos.getEletero() == 0){
            System.out.println("Valamelyik harcos már elesett a harcban");
            return;
        }
        boolean kihivoTamad = true;
        boolean kihivoGyozott = true;
        while (this.getEletero() > 0 && masikHarcos.getEletero() > 0){
            if (kihivoTamad){
                masikHarcos.setEletero(masikHarcos.getEletero() - this.getSebzes());
                kihivoTamad = false;
            }else if (!kihivoTamad){
                this.setEletero(this.getEletero() - masikHarcos.getSebzes());
                kihivoTamad = true;
            }
            if (this.getEletero() > 0){
                this.setTapasztalat(this.getTapasztalat() + 5);
            }
            if (masikHarcos.getEletero() > 0){
                masikHarcos.setTapasztalat(masikHarcos.getTapasztalat() + 5);
            }
        }
        if (masikHarcos.getEletero() > 0){
            kihivoGyozott = false;
            masikHarcos.setTapasztalat(masikHarcos.getTapasztalat() + 10);
        }else {
            this.setTapasztalat(this.getTapasztalat() + 10);
        }
    }

    public void gyogyul(){

    }

    //overrides

    @Override
    public String toString() {
        return this.nev + " - LVL: " + this.szint
                + " - EXP: " + this.tapasztalat + "/" + this.getSzintLepeshez()
                + " - HP: " + this.eletero + "/" + this.getMaxEletero() + " - DMG: " + this.getSebzes();
    }
}
