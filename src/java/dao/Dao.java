
package dao;

import entites.Client;
import entites.Facture;
import entites.Region;
import java.util.LinkedList;
import java.util.List;


public final class Dao {

    public Dao() {
        
        reinitCacheData();
    }
   
    
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Initialisation des Données">
    
    private List<Region>    lesRegions; 
    private List<Client>    lesClients;
    private List<Facture>   lesFactures;

    public  Client getClient(Long numcli ){
         
           reinitCacheData(); 
        
           int index= (int) (numcli-101);
           Client c=lesClients.get(index);
         
           System.out.println(c.getLesFactures());
           
           return c;
        
    }
    
  public  List<Client> getAllClients(){
        
        reinitCacheData();    
        return lesClients;
    
    }
    
   public  List<Region> getAllRegions(){
         reinitCacheData();  
        return lesRegions;
    }
    
   public  Region getRegion(String codeReg){
     
         reinitCacheData();  
        
         Region r=new Region();
    
         if (codeReg.equals("HDF")) r= lesRegions.get(0);
         if (codeReg.equals("GE"))   r= lesRegions.get(1);
    
         
         return r;
    }
    
    
   public Facture getFacture(Long numFact){
    
          reinitCacheData();  
          int index= (int) (numFact-1001L);
          
          return lesFactures.get(index); 
    
    
    }
    
    
   public  List<Facture> getAllFactures(){
         
          reinitCacheData(); 
          
          return lesFactures;
    }
    
    
    void reinitCacheData() {
        
      lesRegions= new LinkedList<Region>();   
      lesClients= new LinkedList<Client>();
      lesFactures= new LinkedList();
        
      Region  r1=new Region();   
      r1.setCodeRegion("HDF");
      r1.setNomRegion("Hauts de France"); 
      
      Region  r2=new Region();   
      r2.setCodeRegion("GE");
      r2.setNomRegion("Grand Est");
        
        
      lesRegions.add(r1);lesRegions.add(r2);  
      
      Client c1= new Client();  
      c1.setNumCli(101L);
      c1.setNomCli("Dupont");
      c1.setAdrCli("Arras");
      c1.setLaRegion(r1);
      lesClients.add(c1);
      
      Client c2= new Client();  
      c2.setNumCli(102L);
      c2.setNomCli("Durant");
      c2.setAdrCli("Lille");
      c2.setLaRegion(r1);
      lesClients.add(c2);
        
      Client c3= new Client();  
      c3.setNumCli(103L);
      c3.setNomCli("Leroy");
      c3.setAdrCli("Hirson");
      
      c3.setLaRegion(r2);
      lesClients.add(c3);
      
      
      r1.getLesClients().add(c1);
      r1.getLesClients().add(c2);
      r2.getLesClients().add(c3);
      
      
       Facture f1= new Facture();
       
       f1.setNumFact(1001L);
       
       f1.setDateFact("15/10/17");
       f1.setMontantFact(1250f);
       f1.setLeClient(c1);
       c1.getLesFactures().add(f1);
       
       
       Facture f2= new Facture();
       
       f2.setNumFact(1002L);
       
       f2.setDateFact("15/10/17");
       f2.setMontantFact(347f);
       f2.setLeClient(c2);
       c2.getLesFactures().add(f2);
       
      
       Facture f3= new Facture();
       
       f3.setNumFact(1003L);
       
       f3.setDateFact("20/10/17");
       f3.setMontantFact(522f);
       f3.setLeClient(c1);
       c1.getLesFactures().add(f3);
       
       
       Facture f4= new Facture();
       
       f4.setNumFact(1004L);
       
       f4.setDateFact("21/10/17");
       f4.setMontantFact(730f);
       f4.setLeClient(c3);
       c3.getLesFactures().add(f4);
       
       Facture f5= new Facture();
       
       f5.setNumFact(1005L);
       
       f5.setDateFact("25/10/17");
       f5.setMontantFact(133f);
       f5.setLeClient(c1);
       c1.getLesFactures().add(f5);
       
       
       
        Facture f6= new Facture();
       
        f6.setNumFact(1006L);
       
        f6.setDateFact("25/10/17");
        f6.setMontantFact(857f);
        f6.setLeClient(c3);
        c3.getLesFactures().add(f6);
      
        
        lesFactures.add(f1);lesFactures.add(f2);lesFactures.add(f3);
        lesFactures.add(f4);lesFactures.add(f5);lesFactures.add(f6);
       
    }
    
  
    //</editor-fold>
         
}
