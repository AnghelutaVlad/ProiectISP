package RZ;

public class Pachet {
	int Greutate;
	StarePachet Stare;
	int Lungime;
	int Latime;
	TipPachet Tip;
	
	Pachet(int gr, int lung, int lat)
	{
		Greutate = gr;
		Lungime = lung;
		Latime = lat;
		Stare = StarePachet.Valid;
	}
	
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
	
	public void SetStare(StarePachet s)
	{
		Stare = s;
	}
	
	public int Volum()
	{
		return Lungime * Latime * Latime;
	}
	
	public void Afisare_Pachet()
	{
		System.out.println("Detalii Pachet:");
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
