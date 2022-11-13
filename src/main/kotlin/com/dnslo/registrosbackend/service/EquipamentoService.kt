package com.dnslo.registrosbackend.service

import com.dnslo.registrosbackend.model.equipamento.Equipamento
import com.dnslo.registrosbackend.repository.EquipamentoRepository
import org.springframework.stereotype.Service

@Service
class EquipamentoService(
    private val equipamentoRepository: EquipamentoRepository
) {
    fun salvar(equipamento: Equipamento): Equipamento? {
        return equipamentoRepository.save(equipamento)
    }

    fun findAll(): List<Equipamento> {
        return equipamentoRepository.findAll()
    }

    fun removerPorId(id: String) {
        equipamentoRepository.deleteById(id)
    }
}