package Vlad;
import java.time.LocalDate;

public class SistemMonitorizare {
    //parametri
    private TipAlarma alarma;
    private int nrCamere;
    private String tipCamere;
    private LocalDate dataAchizitie;

    //constructori
    SistemMonitorizare(){
        this.alarma = TipAlarma.Functionare_normala;
        this.nrCamere = 0;
        this.tipCamere = "-";
        this.dataAchizitie = LocalDate.now();
    }

    SistemMonitorizare(int nrCamere, String tipCamere, LocalDate dataAchizitie, TipAlarma alarma){
        this.nrCamere = nrCamere;
        this.tipCamere = tipCamere;
        this.dataAchizitie = dataAchizitie;
        this.alarma = alarma;
    }

    public void afisare(){
        System.out.println("Nr camere : " + this.nrCamere + " tip camere: " + this.tipCamere + " data achizitie: " + this.dataAchizitie /* + " alarma: " + this.alarma*/ + "\n");
    }

    //public Robot DiagnosticRobot(Robot r){}
    // verifica starea robotului si seteaza alarme
    
    
    //public Robot TrimisComanda(Robot r, Pachet p){}
    // switch case de implementat + verifica daca greutatea pachetului depaseste capacitatea sau nu
    
    
    //public TipPachet IdentificareCategorie(TipPachet p){}
    // verifica dimensiuni => Stare mic/mare
    
    
    //public StarePachet DiagnosticPachet(TipPachet p){}
    // verifica Valid/Rebut la pachet

    
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
    
    public TipAlarma GetAlarma() {
    	return this.alarma;
    }
    public void SetAlarma(TipAlarma alarma) { this.alarma = alarma;}
}
