package com.dnslo.registrosbackend.model.equipamento

import com.dnslo.registrosbackend.model.StatusEnum
import java.time.LocalDateTime

class AcaoEquipamento(
    var descricao: String,
    var inicio: LocalDateTime,
    var fim: LocalDateTime,
    var historicoLocalizacao: List<Localizacao>? = emptyList(),
    var status: StatusEnum,
    var responsavel: String? = null,
    var prazo: LocalDateTime? = null,
    var observacao: String? = null,
    var historicoStatus: List<StatusAcao>? = emptyList()
)