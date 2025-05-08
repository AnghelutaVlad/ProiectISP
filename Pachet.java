package Ambalare;

public class Pachet {
	int Greutate;
	StarePachet Stare;
	int Lungime;
	int Latime;
	TipPachet Tip;
	int ID;
	
	public int GetID() {
		return this.ID;
	}
	
	public Pachet(int gr, int lung, int lat,int id)
	{
		Greutate = gr;
		Lungime = lung;
		Latime = lat;
		Stare = StarePachet.Valid;
		this.ID = id;
	}
	public Pachet() {}
	public int GetGreutate()
	{
		return this.Greutate;
	}
	
	public StarePachet GetStare()
	{
		return this.Stare;
	}
	
	public TipPachet GetTip()
	{
		return this.Tip;
	}
	
	public void SetTip(TipPachet t)
	{
		this.Tip=t;
	}
	
	public void SetStare(StarePachet s)
	{
		Stare = s;
	}
	
	public int Volum()
	{
		return Lungime * Latime * Latime;
	}
	
	public void afisare()
	{
		System.out.println("Detalii Pachet:");
		System.out.print("ID: ");
		System.out.println(ID);
		System.out.print("Greutate: ");
		System.out.println(Greutate);
		System.out.print("Latime: ");
		System.out.println(Latime);
		System.out.print("Lungime: ");
		System.out.println(Lungime);
		System.out.print("Stare: ");
		System.out.println(Stare);
		System.out.print("Tip: ");
		System.out.println(Tip);
		
	}
}
