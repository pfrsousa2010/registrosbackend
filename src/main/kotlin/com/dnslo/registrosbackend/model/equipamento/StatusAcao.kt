package com.dnslo.registrosbackend.model.equipamento

import com.dnslo.registrosbackend.model.StatusEnum
import java.time.LocalDateTime

class StatusAcao(
    var status: StatusEnum,
    var datahora: LocalDateTime,
    var localização: String? = null,
    var observacao: String? = null
)