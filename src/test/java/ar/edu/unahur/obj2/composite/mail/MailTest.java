package ar.edu.unahur.obj2.composite.mail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.agrupable.Agrupable;
import ar.edu.unahur.obj2.composite.filtros.Adjunto;
import ar.edu.unahur.obj2.composite.filtros.AsuntoContiene;
import ar.edu.unahur.obj2.composite.filtros.FiltroCompuesto;
import ar.edu.unahur.obj2.composite.filtros.Tamanio;

public class MailTest {
    @Test
    void dadoUnMailConAsuntoMuyImportanteYTamanio250Cumple() {
        Mail mail = new Mail("Jony", "Test", "Muy Importante", 
            250, true, "Reunión consorcio");

        Agrupable tam = new Tamanio (mail,230);
        Agrupable adj = new Adjunto (mail);
        Agrupable contiene = new AsuntoContiene(mail, "importante");

        Agrupable compuesto = new FiltroCompuesto(Arrays.asList(tam,adj,contiene));
        
        mail.setFiltro(compuesto);

        assertTrue(mail.filtrate());

    }
}
