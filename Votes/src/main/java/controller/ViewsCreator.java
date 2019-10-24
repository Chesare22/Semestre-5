package controller;

import utilities.Listener;
import view.BarChart;
import view.PieChart;
import view.ShowVotesCLI;

public class ViewsCreator {

  public static Listener[] createListeningViews() {
    ViewUpdater[] viewUpdaters = {
      new ViewUpdater(new ShowVotesCLI()),
      new ViewUpdater(new PieChart("Titulo")),
      new ViewUpdater(new BarChart())
    };
    return viewUpdaters;
  }
}
