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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder={"nomReg", "lesClients"})
public class Region implements Serializable {
    
    @XmlAttribute(name="id")
    private String codeReg;
    
    @XmlElement(name="nomregion")
    private String nomReg;
   
    @XmlElement(name="client") 
    private List<Client> lesClients=new LinkedList<Client>();
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    
    public String getCodeRegion() {
        return codeReg;
    }
    public void   setCodeRegion(String codeRegion) {
        this.codeReg = codeRegion;
    }
    public String getNomRegion() {
        return nomReg;
    }
    public void   setNomRegion(String nomRegion) {
        this.nomReg = nomRegion;
    }
    
  
    public List<Client> getLesClients() {
        return lesClients;
    }
    public void         setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }
    //</editor-fold>
}


