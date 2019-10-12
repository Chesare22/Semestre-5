package controller;


import utilities.Listener;
import view.CandidatesAndVotesView;

public class ViewUpdater implements Listener {

  private final CandidatesAndVotesView view;

  public ViewUpdater(CandidatesAndVotesView view) {
    this.view = view;
  }
  
  @Override
  public void update() {
    view.update(Controller.getInstance().getModelCandidatesAndVotes());
  }
}
