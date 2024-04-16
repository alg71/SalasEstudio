package principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class SalasEstudioApplication implements CommandLineRunner {

    @Autowired
    SalaEstudioRepository salaEstudioRepository;

    public static void main(String[] args) {
        SpringApplication.run(SalasEstudioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("");
        int numSalas = (int) salaEstudioRepository.count();
        System.out.println("Número de salas de estudio: " + numSalas);
        System.out.println("");

        /*SalaEstudio salaEstudio = new SalaEstudio(50);
        // Guardar            
        salaEstudioRepository.save(salaEstudio);
        System.out.println("Sala guardada en base de datos");

        System.out.println("");
        numSalas = (int) salaEstudioRepository.count();
        System.out.println("Número de salas de estudio: " + numSalas);
        System.out.println("");*/

        List<SalaEstudio> aforoActual = salaEstudioRepository.findAll();

        for (Object salaEstudio1 : aforoActual) {
            System.out.println(salaEstudio1);
        }

        System.out.println("");

    }
}
