import java.time.LocalDate;

public class SistemMonitorizare {
    //parametri
    //private TipAlarma alarma;
    private int nrCamere;
    private String tipCamere;
    private LocalDate dataAchizitie;

    //constructori
    SistemMonitorizare(){
        //this.alarma = ...
        this.nrCamere = 0;
        this.tipCamere = "-";
        this.dataAchizitie = LocalDate.now();
    }

    SistemMonitorizare(int nrCamere, String tipCamere, LocalDate dataAchizitie/*,TipAlarma alarma*/){
        this.nrCamere = nrCamere;
        this.tipCamere = tipCamere;
        this.dataAchizitie = dataAchizitie;
        //this.alarma = alarma;
    }

    public void afisare(){
        System.out.println("Nr camere : " + this.nrCamere + " tip camere: " + this.tipCamere + " data achizitie: " + this.dataAchizitie /* + " alarma: " + this.alarma*/ + "\n");
    }

    //public Robot DiagnosticRobot(Robot r){}

    //public Robot TrimisComanda(Robot r){}

    //public TipPachet IdentificareCategorie(TipPachet p){}

    //public StarePachet DiagnosticPachet(TipPachet p){}


    //getteri/setteri
    public int getNrCamere() {
        return this.nrCamere;
    }
    public String getTipCamere() {
        return this.tipCamere;
    }
    public LocalDate getDataAchizitie() {
        return this.dataAchizitie;
    }
    public void setNrCamere(int nrCamere) {
        this.nrCamere = nrCamere;
    }
    public void setTipCamere(String tipCamere) {
        this.tipCamere = tipCamere;
    }
    public void setDataAchizitie(LocalDate dataAchizitie) {
        this.dataAchizitie = dataAchizitie;
    }
    //set/get pt alarma ...
}
