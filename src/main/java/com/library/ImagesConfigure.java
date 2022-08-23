package com.library;
// Esta clase la creamos para indicar a Spring la ruta que utilizaremos para guardar los archivos recibidosv

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//Anotación imprescindible
public class ImagesConfigure implements WebMvcConfigurer {
    //Implementamos la interface Web para poder inidicar donde lo guardamos
    //Esta interface tiene muchos métodos por lo que no nos aparece para implementarlos automáticamente. Tenemos que seleccionar
    //Los que nosotros necesitamos en este caso el manipulador de recursos (ResourceHandler)

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //Este método llamará al manipulador de la clase base.       
     
        WebMvcConfigurer.super.addResourceHandlers(registry);

        //a traver del objeto que se ha inyectado (registry) agregamos un manejador de recursos
        // Aquí estamos indicando que hay un nuevo recurso que se llama recursos. Los asteriscos es para que busque los recursos en la
        //propia carpeta de recursos y en sus subCarpetas. A continuación tenemos que definir la ubicación.
        registry.addResourceHandler("/recursos/**").addResourceLocations("file:///C:/Users/icasasdu/Documents/recursos/");
        

    
    }
    
}
