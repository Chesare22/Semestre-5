package controller;

import utilities.Listener;
import view.ShowVotesCLI;

public class ViewsCreator {

  public static Listener[] createListeningViews() {
    ViewUpdater[] viewUpdaters = {
      new ViewUpdater(new ShowVotesCLI())
    // new ViewUpdater(new PieChart()),
    // new ViewUpdater(new BarChart())
    };
    return viewUpdaters;
  }
}
