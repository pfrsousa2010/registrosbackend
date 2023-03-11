package com.dnslo.registrosbackend.model.equipamento

import com.dnslo.registrosbackend.model.StatusEnum
import java.time.LocalDateTime

data class StatusAcao(
    val status: StatusEnum,
    val datahora: LocalDateTime? = null
)