package principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ModeloSalaEstudio {

    @Autowired
    private SalaEstudioRepository salaEstudioRepository;

    public void eliminarAforo(SalaEstudio s) {
        int aforoActual = s.getAforoActual();
        s.setAforoActual(aforoActual - 1);
        salaEstudioRepository.save(s);
    }

    public void aumentarAforo(SalaEstudio s) {
        int aforoActual = s.getAforoActual();
        s.setAforoActual(aforoActual + 1);
        salaEstudioRepository.save(s);
    }
}
