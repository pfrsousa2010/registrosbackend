package com.dnslo.registrosbackend.model.equipamento

import com.dnslo.registrosbackend.model.StatusEnum
import java.time.LocalDate
import java.time.LocalDateTime

data class AcaoEquipamento(
    var descricao: String,
    var dataCriacao: LocalDateTime? = null,
    var inicio: LocalDate,
    var fim: LocalDate?,
    var localizacao: String? = null,
    var status: StatusEnum,
    var responsavel: String? = null,
    var prazo: LocalDate?,
    var observacao: String? = null,
    var historicoStatus: MutableList<StatusAcao>? = mutableListOf()
) {

}