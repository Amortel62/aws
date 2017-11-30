package webservice.rest.demo;

import dao.Dao;
import entites.Client;
import entites.Facture;
import entites.Region;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("tp")
public class WsRestTP  {
   
    ///////////////////////////////////////////////////////////////
    
    @ Inject private Dao   dao;    
     
    ///////////////////////////////////////////////////////////////  
    
    @GET
    @Path("client/{numcli}")
    @Produces({"application/xml","application/json"})
    public Client getClientNumero(@PathParam("numcli")Long numcli) {
        
       Client c= dao.getClient(numcli);
       c.getLaRegion().setLesClients(null);
       for (Facture f : c.getLesFactures()){
           f.setLeClient(null);
       }
       return c;
    }
    
    /////////////////////////////////////////////////////////////// 
    
    @GET
    @Path("clients")
    @Produces({"application/xml","application/json"})
    public List<Client> getTousLesClients() {
    
       List<Client> lc=new LinkedList(); 
        
       for (Client c : dao.getAllClients()) {
       
             c.getLaRegion().setLesClients(null);
             
             for (Facture f : c.getLesFactures()){f.setLeClient(null);}
             
             lc.add(c);
       }
        
       return lc;
    }
   
    ///////////////////////////////////////////////////////////////
       
    @GET
    @Path("region/{codereg}")
    @Produces({"application/xml","application/json"})
     public Region getRegionCode(@PathParam("codereg") String codereg) {
            
      Region  r= dao.getRegion(codereg);
      for (Client c : r.getLesClients()) {
          c.setLaRegion(null);
          for (Facture f : c.getLesFactures()){f.setLeClient(null);}
      }
      return r;
    }
    
    /////////////////////////////////////////////////////////////// 
    
    @GET
    @Path("regions")
    @Produces("application/xml")
    public List<Region> getToutesLesRegions() {
    
       List<Region> lr= new LinkedList();
       
       for (Region r : dao.getAllRegions()) {
       
               for (Client c : r.getLesClients()) {
                   
                   c.setLaRegion(null);
                   for (Facture f : c.getLesFactures()){f.setLeClient(null);}
                   
               }
               lr.add(r);
       } 
        
       return lr;
    } 
    
    ///////////////////////////////////////////////////////////////////////// 
    
    @GET
    @Path("totalfactures")
    @Produces({"text/plain"})
    public String totalFactures() {
        
       Float somme = 0F; 
      
       for (Facture f : dao.getAllFactures()) {
       
             somme = somme + f.getMontantFact();
             
       }
        
       return somme.toString();
       
    
    }
        
    ///////////////////////////////////////////////////////////////////////// 
    
    @GET
    @Path("totalfactures/region/{codereg}")
    @Produces({"text/plain"})
    public String totalFacturesRegion(@PathParam("codereg") String codereg) {
        
       Float somme = 0F; 
       Region  r= dao.getRegion(codereg);
      
        for(Client c : r.getLesClients()){   
            
            for (Facture f : c.getLesFactures() ) {   
           
                 somme = somme + f.getMontantFact();
             
           }
            
         }
        
         return somme.toString();
         
       }
        
           ///////////////////////////////////////////////////////////////////////// 
    
    @GET
    @Path("totalfactures/client/{numcli}")
    @Produces({"text/plain"})
    public String totalFacturesClient(@PathParam("numcli") Long numcli) {
        
       Float somme = 0F; 
       Client  c = dao.getClient(numcli);
      
        for(Facture f : c.getLesFactures()){
        
            somme += f.getMontantFact();
        
        }
        
         return somme.toString();
         
       }   

///////////////////////////////////////////////////////////////
       
    @GET
    @Path("facture/{numfact}")
    @Produces({"application/xml","application/json"})
     public Facture getNumFact(@PathParam("numfact") Long numfact) {
            
      Facture f = dao.getFacture(numfact);
     f.getLeClient().setLaRegion(null);
     f.setLeClient(null);
      
      return f;
    }    
    

}