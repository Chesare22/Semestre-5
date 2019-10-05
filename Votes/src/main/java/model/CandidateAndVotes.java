package model;

public class CandidateAndVotes extends Candidate {

  private final int votes;

  public CandidateAndVotes(Candidate candidate, int votes) {
    super(candidate.id(), candidate.name());
    this.votes = votes;
  }

  public int votes() {
    return votes;
  }

}
