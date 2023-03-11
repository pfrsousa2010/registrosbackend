package com.dnslo.registrosbackend.controller

import com.dnslo.registrosbackend.model.equipamento.AcaoEquipamento
import com.dnslo.registrosbackend.model.equipamento.Calibracao
import com.dnslo.registrosbackend.model.equipamento.Equipamento
import com.dnslo.registrosbackend.model.equipamento.Localizacao
import com.dnslo.registrosbackend.service.EquipamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestController
@RequestMapping("/equipamento")
class EquipamentoController(

    @Autowired
    private val equipamentoService: EquipamentoService

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
        val now = LocalDateTime.now()
        equipamento.ultimaLocalizacao?.let {
            Localizacao(
                local = it,
                datahora = now
            )
        }?.let {
            equipamento.historicoLocalizacao?.add(
                it
            )
        }
        equipamento.ultimaAtualizacao = now
        return equipamentoService.salvar(equipamento)
    }

    @PutMapping("atualizar/{id}")
    @ResponseStatus(OK)
    fun atualizar(
        @RequestBody @Validated equipamento: Equipamento,
        @PathVariable("id") idEquipamento: String
    ): ResponseEntity<Equipamento> {
        return if (equipamentoService.equipamentoExiste(idEquipamento)) {
            ResponseEntity.ok(
                equipamentoService.salvar(equipamento)
            )
        } else ResponseEntity.status(NOT_FOUND).body(null)
    }

    @PutMapping("atualizar/acao/{id}")
    @ResponseStatus(OK)
    fun atualizarAcao(
        @RequestBody @Validated acao: AcaoEquipamento,
        @PathVariable("id") idEquipamento: String
    ): ResponseEntity<Equipamento> {
        return if (equipamentoService.equipamentoExiste(idEquipamento)) {
            ResponseEntity.ok(
                equipamentoService.atualizarEquipamentoAcao(idEquipamento, acao)
            )
        } else ResponseEntity.status(NOT_FOUND).body(null)
    }

    @PutMapping("atualizar/status/{id}")
    @ResponseStatus(OK)
    fun atualizarStatusAcao(
        @RequestBody @Validated novoStatus: String,
        @PathVariable("id") equipamentoId: String,
        @RequestParam(value = "acaoIndex") acaoIndex: Int
    ): ResponseEntity<Equipamento> {
        return if (equipamentoService.equipamentoExiste(equipamentoId)) {
            ResponseEntity.ok(
                equipamentoService.atualizarStatusAcao(equipamentoId, acaoIndex, novoStatus)
            )
        } else ResponseEntity.status(NOT_FOUND).body(null)
    }

    @PutMapping("atualizar/calibracao/{id}")
    @ResponseStatus(OK)
    fun atualizarCalibracao(
        @RequestBody @Validated calibracao: Calibracao,
        @PathVariable("id") equipamentoId: String
    ): ResponseEntity<Equipamento> {
        return if (equipamentoService.equipamentoExiste(equipamentoId)) {
            ResponseEntity.ok(
                equipamentoService.editarCalibracao(equipamentoId, calibracao)
            )
        } else ResponseEntity.status(NOT_FOUND).body(null)
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