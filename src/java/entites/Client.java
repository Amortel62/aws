package entites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"nomCli", "adrCli","laRegion","lesFactures"})

public class Client implements Serializable {
 
    @XmlAttribute(name="id")
    private Long   numCli;
   
    @XmlElement (name="nom")
    private String nomCli;
    
    @XmlElement (name="adresse")
    private String adrCli;
   
    @XmlElement (name="region")
    private Region laRegion;
    
    @XmlElement (name="facture")  
    private List<Facture> lesFactures=new LinkedList();
     
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
   
    
    
     public Long getNumCli() {
        return numCli;
    }
    
   
    public String getNomCli() {
        return nomCli;
    }
    
    
    public String getAdrCli() {
        return adrCli;
    }
    
   
    
    public void setNumCli(Long numCli) {
        this.numCli = numCli;
    }
    
    
    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }
    
    
    public void setAdrCli(String adrCli) {
        this.adrCli = adrCli;
    }
    
    
     public Region getLaRegion() {
        return laRegion;
    }

    public void setLaRegion(Region laRegion) {
        this.laRegion = laRegion;
    }

    public List<Facture> getLesFactures() {
        return lesFactures;
    }

    public void setLesFactures(List<Facture> lesFactures) {
        this.lesFactures = lesFactures;
    }
    
    
    //</editor-fold>

   
}




