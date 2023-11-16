package bowling;
import java.util.ArrayList;

public class Tours {
	private ArrayList<Lancer> lesLancers;
	private int score;

	private int num;

	public Tours(int num,ArrayList lesLancers){
		this.num=num;
		this.lesLancers=lesLancers;
		this.score=0;
	}
	public Tours(int num){
		this.num=num;
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

}
