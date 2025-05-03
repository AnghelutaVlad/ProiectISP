package Vlad;

public class Segment_brat {
	private int Lungime;
	private int Latime;
	private boolean Gripper;
	
	public Segment_brat(int lun, int lat, boolean st) {
		this.Lungime = lun;
		this.Latime = lat;
		this.Gripper = st;
	}
	
	public void afisare() {
		System.out.println("Lungime: "+this.Lungime);
		System.out.println("Latime: "+this.Latime);
		System.out.println("Are gheara: "+this.Gripper);
	}
	
	public int getLungime() {
		return Lungime;
	}

}
