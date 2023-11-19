package bowling;

import java.util.ArrayList;

public class Tour {
	private int numTour;
	private ArrayList<Lancer> lancers = new ArrayList<>();
	private int numCoup = 1;
	private boolean estFini = false;

	public Tour(int numTour) {
		this.numTour = numTour;
	}

	public boolean estUnStrike() {
		return lancers.size() == 1 && lancers.get(0).getNombreDeQuillesAbattues() == PartieMonoJoueur.nbQuilles;
	}

	public boolean estUnSpare() {
		return numCoup == 2 && getScoreLancer(1) + getScoreLancer(2) == PartieMonoJoueur.nbQuilles && numTour != PartieMonoJoueur.nbTours;
	}

	public boolean estFini() {
		return estFini;
	}

	public int getScore() {
		int score = 0;
		for (Lancer lancer : lancers) {
			score += lancer.getNombreDeQuillesAbattues();
		}
		return score;
	}

	public int getScoreLancer(int numLancer) {
		if (numLancer >= 1 && numLancer <= lancers.size()) {
			return lancers.get(numLancer - 1).getNombreDeQuillesAbattues();
		} else {
			return 0;
		}
	}

	public int getProchainNumCoup() {
		return numCoup;
	}

	public boolean enregistreLancer(Lancer lancer) {
		if (numCoup == 1) {
			lancers.add(lancer);
			if (getScore() == PartieMonoJoueur.nbQuilles && numTour != PartieMonoJoueur.nbTours) {
				estFini = true;
			} else if (getScore() == PartieMonoJoueur.nbQuilles) {
				numCoup += 1;
			} else {
				numCoup++;
			}
		} else if (numCoup == 2) {
			lancers.add(lancer);
			estFini = true;
			if (numTour == PartieMonoJoueur.nbTours && !(getScore() < PartieMonoJoueur.nbQuilles)) {
				numCoup++;
				estFini = false;
			}
		} else if (numCoup == 3) {
			lancers.add(lancer);
			estFini = true;
		}

		return !estFini;
	}
}

