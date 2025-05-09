package Ambalare;
import java.time.LocalDate;
import java.util.ArrayList;

public class SistemMonitorizare {
    //parametri
    private TipAlarma alarma;
    private int nrCamere;
    private String tipCamere;
    private LocalDate dataAchizitie;

    //constructori
    public SistemMonitorizare(){
        this.alarma = TipAlarma.Functionare_normala;
        this.nrCamere = 0;
        this.tipCamere = "-";
        this.dataAchizitie = LocalDate.now();
    }

    public SistemMonitorizare(int nrCamere, String tipCamere, LocalDate dataAchizitie, TipAlarma alarma){
        this.nrCamere = nrCamere;
        this.tipCamere = tipCamere;
        this.dataAchizitie = dataAchizitie;
        this.alarma = alarma;
    }

    public void afisare(){
        System.out.println("Nr camere : " + this.nrCamere + " tip camere: " + this.tipCamere + " data achizitie: " + this.dataAchizitie /* + " alarma: " + this.alarma*/ + "\n");
    }

    public int DiagnosticRobot(Robot r){
    	if(r.GetStare()==StareRobot.Defect) {
    		switch(r.getClass().getName()) {
    		     case "Ambalare.BratRobotic":
    		    	 this.SetAlarma(TipAlarma.Brat_defect);
    		    	 break;
    		     case "Ambalare.RobotMobil":
    		    	 this.SetAlarma(TipAlarma.Robot_mobil_defect);
    		    	 break;
    		     case "Ambalare.Conveior":
    		    	 this.SetAlarma(TipAlarma.Conveior_defect);
    		    	 break;
    		     
    		}
    		return r.GetID();
    	}
    	else return -1;
    	
    }
    // verifica starea robotului si seteaza alarme
    
    
    public void TrimisComanda(BratRobotic r, Pachet p){
    	r.DeplasareObiecte();
    	r.AmbalarePachet(p);
    	r.SetStare(StareRobot.Inactiv);
    }
    
    public void TrimisComanda(BratRobotic r, Pachet p, Conveior c_out, Conveior c_in){
    	r.DeplasareObiecte();
    	r.SortareObiect(p, c_out, c_in);
    	r.SetStare(StareRobot.Inactiv);
    }
    public void TrimisComanda(BratRobotic r, Pachet p, RobotMobil m, ArrayList<Pachet> vr){
    	r.DeplasareObiecte();
    	r.EliminaRebut(p, m, vr);
    	r.SetStare(StareRobot.Inactiv);
    }
    
    public void TrimisComanda(BratRobotic r, Conveior c, ArrayList<Pachet> vp) {
    	r.DeplasareObiecte();
    	r.PlasarePachet(c, vp);
    	r.SetStare(StareRobot.Inactiv);
    }
    
    public void TrimisComanda(Conveior c) {
    	if(c.GetNrPachete() > 0) {
    		c.DeplasareObiecte();
    	}
    	else c.SetStare(StareRobot.Inactiv);
    }
    
    public void TrimisComanda(RobotMobil r, Pachet p, ArrayList<Pachet> dep) {
    	r.DeplasareObiecte();
    	r.DeplasarePachet(p, dep);
    	r.SetStare(StareRobot.Inactiv);
    }
    
    // switch case de implementat + verifica daca greutatea pachetului depaseste capacitatea sau nu
    
    
    public TipPachet IdentificareCategorie(Pachet p){
    	if(p.Volum() <= Constante.VolumPrag) {
    		return TipPachet.Mic;
    	}
    	else return TipPachet.Mare;
    }
    // verifica dimensiuni => Stare mic/mare
    
    
    public StarePachet DiagnosticPachet(Pachet p){
    	if(p.Volum() < Constante.VolumMin || p.Volum() > Constante.VolumMax || p.GetGreutate() < Constante.Greutate_Min ||  p.GetGreutate() > Constante.Greutate_Max) {
    		p.SetStare(StarePachet.Rebut);
    		return p.GetStare();
    	}
    	else {
    		p.SetTip(this.IdentificareCategorie(p));
    		p.SetStare(StarePachet.Valid);
    		return p.GetStare();
    	}
    	
    }

    
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
