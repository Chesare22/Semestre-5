package model;


import controller.Notifier;
import java.util.Arrays;

public class PollingPlace {

  private final int[] votes;
  private final Candidate[] candidates;
  private Notifier notifier = null;

  public PollingPlace(String[] candidatesNames) {
    votes = new int[candidatesNames.length];
    Arrays.fill(votes, 0);

    candidates = new Candidate[candidatesNames.length];
    for (int i = 0; i < candidatesNames.length; i++) {
      candidates[i] = new Candidate(i, candidatesNames[i]);
    }
  }

  public void vote(int candidateId) {
    votes[candidateId]++;
    callNotifier();
  }

  public Candidate[] getCandidates() {
    return candidates.clone();
  }

  public CandidateAndVotes[] candidatesAndVotes() {
    CandidateAndVotes[] cav = new CandidateAndVotes[candidates.length];
    for (int i = 0; i < candidates.length; i++) {
      cav[i] = new CandidateAndVotes(candidates[i], votes[i]);
    }
    return cav;
  }

  public void setNotifier(Notifier n) {
    this.notifier = n;
  }
  
  private void callNotifier(){
    if(notifier != null){
      notifier.updateAll();
    }
  }

}
