package principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ModeloSalaEstudio {

    private final SalaEstudioRepository salaEstudioRepository;

    @Autowired
    public ModeloSalaEstudio(SalaEstudioRepository salaEstudioRepository) {
        this.salaEstudioRepository = salaEstudioRepository;
    }

    public void aumentarAforo(int idSala) {
        SalaEstudio salaEstudio = salaEstudioRepository.findById(idSala).orElse(null);
        if (salaEstudio != null) {
            int aforoActual = salaEstudio.getAforoActual();
            salaEstudio.setAforoActual(aforoActual + 1);
            salaEstudioRepository.save(salaEstudio);
        }
    }

    public void disminuirAforo(int idSala) {
        SalaEstudio salaEstudio = salaEstudioRepository.findById(idSala).orElse(null);
        if (salaEstudio != null) {
            int aforoActual = salaEstudio.getAforoActual();
            salaEstudio.setAforoActual(aforoActual - 1);
            salaEstudioRepository.save(salaEstudio);
        }
    }

    /*public void aumentarAforo() {
        // Incrementar el aforo y actualizar la etiqueta
        salaEstudioRepository.findAll().forEach(salaEstudio -> {
            salaEstudio.setAforoActual(salaEstudio.getAforoActual() + 1);
            salaEstudioRepository.save(salaEstudio);
        });

    }

    public void disminuirAforo() {
        // Disminuir el aforo y actualizar la etiqueta
        salaEstudioRepository.findAll().forEach(salaEstudio -> {
            salaEstudio.setAforoActual(salaEstudio.getAforoActual() - 1);
            salaEstudioRepository.save(salaEstudio);
        });

    }

    public void eliminarAforo(SalaEstudio s) {
        int aforoActual = s.getAforoActual();
        s.setAforoActual(aforoActual - 1);
        salaEstudioRepository.save(s);
    }

    public void aumentarAforo(SalaEstudio s) {
        int aforoActual = s.getAforoActual();
        s.setAforoActual(aforoActual + 1);
        salaEstudioRepository.save(s);
    }*/
}
