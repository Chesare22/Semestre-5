package controller;


import model.PollingPlace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Voter implements ActionListener {

  private final int candidateId;
  private static PollingPlace pollingPlace;

  public Voter(int candidateId) {
    this.candidateId = candidateId;
  }
  
  // Can be called only once
  public static boolean setPollingPlace(PollingPlace pp) {
    if(pollingPlace == null){
      pollingPlace = pp;
      return true;
    }
    return false;
  }
  
  public void vote(){
    pollingPlace.vote(candidateId);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    vote();
  }

}
