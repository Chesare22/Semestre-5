package view;


import model.CandidateAndVotes;

public class ShowVotesCLI implements CandidatesAndVotesView {
  
  private int counter = 1;

  @Override
  public void update(CandidateAndVotes[] candidates) {
    System.out.println("\n" + counter + ":");
    for(CandidateAndVotes candidate: candidates){
      System.out.println(candidate.name() + " tiene " + candidate.votes() + " votos.");
    }
    counter++;
  }
}
