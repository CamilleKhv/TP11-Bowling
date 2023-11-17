package bowling;
import java.util.ArrayList;

public class Tours {
	private ArrayList<Lancer> lesLancers;
	private int nbTours;

	public Tours(int nbTours,ArrayList lesLancers){
		this.nbTours=nbTours;
		this.lesLancers=lesLancers;
	}
	public Tours(int nbTours){
		
		this.nbTours=nbTours;
	}
	
	public int scoreTour (){
		int score=0;
		for (Lancer l:lesLancers){
			score+=l.getnbQuillesTombees();
		}
		return score;
	}
	public Boolean estUnSpare(){
		Boolean res = false;
		if (scoreTour()==10 && lesLancers.size()==2)
			res= true;
		return res;
	}

	public Boolean estUnStrike(){
		Boolean res = false;
		if (scoreTour()==10 && lesLancers.size()==1)
			res= true;
		return res;
	}
	public ArrayList<Lancer> getLancer() {
		
		return lesLancers;
	}
	public double bonus(){
		double ret=0;
		Tours tourprecedent=new Tours(nbTours-2);
		//fais un spare
		if(tourprecedent.estUnSpare()==true) {
			ret=lesLancers.get(0).getnbQuillesTombees();
		}
		//fais un strike
		if(tourprecedent.estUnStrike()==true){
			ret=lesLancers.get(0).getnbQuillesTombees()+lesLancers.get(1).getnbQuillesTombees();
		}
		return ret;
	}

}
