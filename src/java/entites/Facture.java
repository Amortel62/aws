
package entites;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement


public class Facture {
    
    private Long    numFact;
    private String  dateFact;   // date au format JJ/MM/AA
    private Float   montantFact;
    private Client  leClient;
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    
    public Long getNumFact() {
        return numFact;
    }
    
    public void setNumFact(Long numFact) {
        this.numFact = numFact;
    }
    
    public Float getMontantFact() {
        return montantFact;
    }
    
    public void setMontantFact(Float montantFact) {
        this.montantFact = montantFact;
    }
    
    
     public String getDateFact() {
        return dateFact;
    }

    public void setDateFact(String dateFact) {
        this.dateFact = dateFact;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }
    
    
    //</editor-fold> 
}
