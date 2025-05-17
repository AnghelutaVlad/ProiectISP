package Ambalare;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Supervizor {

    //parametri
    private String nume;
    private String prenume;
    private int varsta;
    private String CNP;
    private int Salariu;
    private LocalDate dataAngajarii;

    //constructori
    public Supervizor() {
        this.nume = "-";
        this.prenume = "-";
        this.varsta = 0;
        this.CNP = "-";
        this.Salariu = 0;
        this.dataAngajarii = LocalDate.now();
    }

    public Supervizor(String nume, String prenume, int varsta, String CNP, int Salariu, LocalDate dataAngajarii) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.CNP = CNP;
        this.Salariu = Salariu;
        this.dataAngajarii = dataAngajarii;
    }

    public void afisare(){
        System.out.println(this.nume + " " + this.prenume + " varsta: " + this.varsta + " CNP: " + this.CNP + " salariu: " + this.Salariu + " data angajarii: " + this.dataAngajarii + "\n");
    }
    
    public void salvare(String numeFisier, File logFile) {
    	PrintWriter filePrint;

    	
    	FileWriter testWriter;
    	try {
    		testWriter = new FileWriter(logFile, true);
    		filePrint = new PrintWriter(testWriter, true);
    		filePrint.println("Supervizor: ");
    		filePrint.println("      Nume: " + this.nume);
    		filePrint.println("      Prenume: " + this.prenume);
    		filePrint.println("      Varsta: " + this.varsta);
    		filePrint.println("      CNP: " + this.CNP);
    		filePrint.println("      Salariu: " + this.Salariu);
    		filePrint.println("      Data angajarii: " + this.dataAngajarii);
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    public void interventie(Robot r){
    	r.SetStare(StareRobot.In_mentenanta);
    }
    

    public <T extends Robot> void revalidareSistem(ArrayList<T> vr){
        //pune robotii pe Inactiv deocamdata
    	for(int i = 0; i < vr.size(); i++)
    		vr.get(i).SetStare(StareRobot.Inactiv);
    }

    //getteri/setteri
    public String getNume() {
        return this.nume;
    }
    public String getPrenume() {
        return this.prenume;
    }
    public int getVarsta() {
        return this.varsta;
    }
    public String getCNP() {
        return this.CNP;
    }
    public int getSalariu() {
        return this.Salariu;
    }
    public LocalDate getDataAngajarii() {
        return this.dataAngajarii;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    public void setSalariu(int Salariu) {
        this.Salariu = Salariu;
    }
    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

}
