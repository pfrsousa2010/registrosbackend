package com.dnslo.registrosbackend.service

import com.dnslo.registrosbackend.model.equipamento.Equipamento
import com.dnslo.registrosbackend.repository.EquipamentoRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class EquipamentoService(
    private val equipamentoRepository: EquipamentoRepository
) {
    fun salvar(equipamento: Equipamento): Equipamento {
        return equipamentoRepository.save(equipamento)
    }

    fun encontraTodos(): List<Equipamento> {
        return equipamentoRepository.findAll()
    }

    fun buscarPorId(id: String): Optional<Equipamento> {
        return equipamentoRepository.findById(id)
    }

    fun removerPorId(id: String) {
        equipamentoRepository.deleteById(id)
    }
}