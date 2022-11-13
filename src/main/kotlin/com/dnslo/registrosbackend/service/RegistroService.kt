package com.dnslo.registrosbackend.service

import com.dnslo.registrosbackend.model.processos.Registro
import com.dnslo.registrosbackend.repository.RegistroRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RegistroService(
    private val registroRepository: RegistroRepository
) {

    fun salvar(registro: Registro): Registro? {
        return registroRepository.save(registro)
    }

    fun listarRegistros(): List<Registro>? {
        return registroRepository.findAll()
    }

    fun buscarPorId(id: String): Optional<Registro>? {
        return registroRepository.findById(id)
    }

    fun removerPorId(id: String) {
        registroRepository.deleteById(id)
    }

}