package com.dnslo.registrosbackend.model.processos

import com.dnslo.registrosbackend.model.StatusEnum
import java.time.LocalDateTime
import javax.persistence.Id

data class AcaoRegistro(
    var descricao: String,
    var dataAcao: LocalDateTime,
    var statusAcao: StatusEnum,
    var prazoAcao: LocalDateTime
) {
    @Id
    lateinit var id: String
}