package controller;

import view.VoterViewsContainer;
import view.ShowVotesCLI;
import model.Candidate;
import model.PollingPlace;


public class AppConstructor {
  public static void main(String[] args) {
    runApp();
  }
  
  public static void runApp() {
    String[] names = {
      "Pepe", "Juan", "Andrea", "Carla", "Esteban"
    };
    PollingPlace pollingPlace = new PollingPlace(names);
    
    Notifier notifier = new Notifier();
    
//    //Create the views and add them to the notifier
//    notifier.addListener(new ViewUpdater(new PieChart(), pollingPlace));
//    notifier.addListener(new ViewUpdater(new BarChart(), pollingPlace));
    
    // Vista provisional
    notifier.addListener(new ViewUpdater(new ShowVotesCLI(), pollingPlace));
    
    pollingPlace.setNotifier(notifier);
    Voter.setPollingPlace(pollingPlace);
    
    Candidate[] candidates = pollingPlace.getCandidates();
    VoterViewsContainer.run("Votaciones",candidates);
  }
}
