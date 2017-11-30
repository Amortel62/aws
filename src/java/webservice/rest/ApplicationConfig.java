package webservice.rest;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
       
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    // La  méthode ci-dessous enregistre les classe exposant des opérations du WebService REST
    // Netbeans ajoute automatiquement les lignes nécessaires ( la ligne 23 par exemple ) lors des builds
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
       
        resources.add(webservice.rest.demo.WsRestTP.class);       
    }   
}

