package com.dnslo.registrosbackend.service

import com.dnslo.registrosbackend.model.StatusEnum
import com.dnslo.registrosbackend.model.equipamento.*
import com.dnslo.registrosbackend.repository.EquipamentoRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset
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

    fun equipamentoExiste(id: String): Boolean {
        return equipamentoRepository.existsById(id)
    }

    fun removerPorId(id: String) {
        equipamentoRepository.deleteById(id)
    }

    fun atualizarEquipamentoAcao(id: String, acaoEquipamento: AcaoEquipamento): Equipamento {
        val equipamento = buscarPorId(id).get()
        val acaoAtualizada = adicionaNovoStatusAcao(acaoEquipamento)
        return updateEquipAcao(equipamento, acaoAtualizada)
    }

    fun atualizarStatusAcao(equipamentoId: String, acaoIndex: Int, novoStatus: String): Equipamento {
        val statusAtualizado = StatusAcao(
            status = StatusEnum.valueOf(novoStatus),
            datahora = LocalDateTime.now()
        )
        val equipamento = buscarPorId(equipamentoId).get()
        equipamento.historicoAcoes?.get(acaoIndex)
            .also { it?.status = statusAtualizado.status }
            .also { it?.historicoStatus?.add(statusAtualizado) }
        return salvar(equipamento)
    }

    fun editarCalibracao(equipamentoId: String, calibracao: Calibracao): Equipamento {
        val novaCalibracao = Calibracao(
            data = calibracao.data,
            vencimento = calibracao.vencimento,
            responsavel = calibracao.responsavel,
            descricao = calibracao.descricao,
            statusCalibracao = StatusCalibracaoEnum.valueOf(calibracao.statusCalibracao.name)
        )
        val equipamentoCalibracao = buscarPorId(equipamentoId).get()
        equipamentoCalibracao.calibracao = novaCalibracao
        return salvar(equipamentoCalibracao)
    }

    private fun updateEquipAcao(
        equipamento: Equipamento,
        acaoEquipamento: AcaoEquipamento
    ): Equipamento {
        val now = LocalDateTime.now()
        equipamento.historicoAcoes?.add(acaoEquipamento)
        acaoEquipamento.dataCriacao = now
        acaoEquipamento.localizacao?.let {
            Localizacao(
                local = it,
                datahora = LocalDateTime.now()
            )
        }?.let {
            equipamento.ultimaLocalizacao = it.local
            equipamento.historicoLocalizacao?.add(
                it
            )
        }
        if (equipamento.historicoAcoes?.size!! > 1) {
            equipamento.historicoAcoes?.sortedBy { it.dataCriacao!!.toEpochSecond(ZoneOffset.UTC) }
        }
        salvar(equipamento)
        return equipamento
    }

    private fun adicionaNovoStatusAcao(
        acaoEquipamento: AcaoEquipamento
    ): AcaoEquipamento {
        val status = StatusAcao(
            status = StatusEnum.valueOf(acaoEquipamento.status.name),
            datahora = LocalDateTime.now()
        )
        acaoEquipamento.historicoStatus?.add(status)
        return acaoEquipamento
    }
}