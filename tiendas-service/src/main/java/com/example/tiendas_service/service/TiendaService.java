package com.example.tiendas_service.service;

import com.example.tiendas_service.model.Tienda;
import com.example.tiendas_service.repository.TiendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TiendaService {

    private final TiendaRepository tiendaRepository;

    public TiendaService(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    public List<Tienda> listarTiendas() {
        return tiendaRepository.findAll();
    }

    public Optional<Tienda> buscarTiendaPorId(Long id) {
        return tiendaRepository.findById(id);
    }

    public Tienda guardarTienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    public boolean existeTiendaPorId(Long id) {
        return tiendaRepository.existsById(id);
    }

    public void eliminarTienda(Long id) {
        tiendaRepository.deleteById(id);
    }
}
