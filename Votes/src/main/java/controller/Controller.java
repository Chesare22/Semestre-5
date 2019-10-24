package controller;

import utilities.Notifier;
import view.VoterViewsContainer;
import model.Candidate;
import model.CandidateAndVotes;
import model.Model;
import utilities.Listener;


public class Controller {
  
  private final Model model;
  private static Controller singleController;
  
  public static void main(String[] args) {
    String[] names = {
      "Pepe", "Juan", "Andrea", "Ñurca"
    };
    Controller controller = new Controller(new Model(names));
    setSingleController(controller);
    controller.startApp();
  }
  
  private Controller(Model model) {
    this.model = model;
  }
  
  public void startApp() {
    
    Listener[] listeningViews = ViewsCreator.createListeningViews();
    Notifier notifier = new Notifier();
    
    for (Listener listeningView : listeningViews) {
      notifier.addListener(listeningView);
    }
    
    this.model.setNotifier(notifier);
    
    Candidate[] candidates = this.model.getCandidates();
    VoterViewsContainer.run("Votaciones",candidates);
  }
  
  public void vote(int id) {
    singleController.model.vote(id);
  }
  private static void setSingleController(Controller c) {
    singleController = c;
  }
  public CandidateAndVotes[] getModelCandidatesAndVotes() {
    return this.model.candidatesAndVotes();
  }
  public static Controller getInstance(){
    return singleController;
  }
}
