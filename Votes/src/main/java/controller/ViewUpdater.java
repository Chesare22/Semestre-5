package controller;


import view.CandidatesAndVotesView;
import model.PollingPlace;


public class ViewUpdater implements Listener {

  private final CandidatesAndVotesView view;
  private final PollingPlace pp;

  public ViewUpdater(CandidatesAndVotesView view, PollingPlace pp) {
    this.view = view;
    this.pp = pp;
  }
  
  @Override
  public void update() {
    view.update(pp.candidatesAndVotes());
  }
}
