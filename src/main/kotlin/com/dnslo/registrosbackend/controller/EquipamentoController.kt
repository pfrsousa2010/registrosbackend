package com.dnslo.registrosbackend.controller

import com.dnslo.registrosbackend.model.equipamento.Equipamento
import com.dnslo.registrosbackend.service.EquipamentoService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/equipamento")
class EquipamentoController(

    @Autowired
    private val equipamentoService: EquipamentoService,
    @Autowired
    private val modalMapper: ModelMapper

) {

    @GetMapping("")
    @ResponseStatus(OK)
    fun buscarTodos(): List<Equipamento> {
        return equipamentoService.encontraTodos()
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    fun buscarPorId(@PathVariable("id") id: String): Equipamento {
        return equipamentoService.buscarPorId(id)
            .orElseThrow {
                ResponseStatusException(NOT_FOUND, "Equipamento não encontrado.")
            }

    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    fun adicionar(@RequestBody equipamento: Equipamento): Equipamento {
        return equipamentoService.salvar(equipamento)
    }

    @PutMapping("atualizar/{id}")
    @ResponseStatus(NO_CONTENT)
    fun atualizar(
        @PathVariable("id") id: String,
        @RequestBody equipamento: Equipamento
    ) {
        equipamentoService.buscarPorId(id)
            .map {
                modalMapper.map(equipamento, it)
                equipamentoService.salvar(it)
            }
            .orElseThrow {
                ResponseStatusException(NOT_FOUND, "Equipamento não encontrado.")
            }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(OK)
    fun excluir(@PathVariable("id") id: String) {
        equipamentoService.buscarPorId(id)
            .map { equipamentoService.removerPorId(it.id) }
            .orElseThrow {
                ResponseStatusException(NOT_FOUND, "Equipamento não encontrado.")
            }
    }
}