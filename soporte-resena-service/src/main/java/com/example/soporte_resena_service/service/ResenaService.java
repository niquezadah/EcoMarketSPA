package com.example.soporte_resena_service.service;

import com.example.soporte_resena_service.dto.ResenaDTO;
import com.example.soporte_resena_service.model.Resena;
import com.example.soporte_resena_service.repository.ResenaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResenaService {

    private final ResenaRepository resenaRepository;

    public ResenaService(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    public List<ResenaDTO> listarResenas() {
        return resenaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public Optional<ResenaDTO> buscarResenaPorId(Long id) {
        return resenaRepository.findById(id)
                .map(this::convertirADTO);
    }

    public ResenaDTO guardarResena(ResenaDTO resenaDTO) {
        Resena resena = convertirAEntidad(resenaDTO);
        Resena resenaGuardada = resenaRepository.save(resena);
        return convertirADTO(resenaGuardada);
    }

    public boolean existeResenaPorId(Long id) {
        return resenaRepository.existsById(id);
    }

    public void eliminarResena(Long id) {
        resenaRepository.deleteById(id);
    }

    public List<ResenaDTO> listarResenasPorProducto(Long idProducto) {
        return resenaRepository.findByIdProducto(idProducto)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ResenaDTO> listarResenasActivas() {
        return resenaRepository.findByActiva(true)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ResenaDTO> listarResenasPorCalificacion(Integer calificacion) {
        return resenaRepository.findByCalificacion(calificacion)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private ResenaDTO convertirADTO(Resena resena) {
        return new ResenaDTO(
                resena.getIdResena(),
                resena.getIdProducto(),
                resena.getNombreCliente(),
                resena.getCalificacion(),
                resena.getComentario(),
                resena.getActiva()
        );
    }

    private Resena convertirAEntidad(ResenaDTO resenaDTO) {
        return new Resena(
                resenaDTO.getIdResena(),
                resenaDTO.getIdProducto(),
                resenaDTO.getNombreCliente(),
                resenaDTO.getCalificacion(),
                resenaDTO.getComentario(),
                resenaDTO.getActiva()
        );
    }
}