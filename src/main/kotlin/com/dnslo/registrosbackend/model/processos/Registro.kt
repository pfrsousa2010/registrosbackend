package com.dnslo.registrosbackend.model.processos

import com.dnslo.registrosbackend.model.StatusEnum
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document
class Registro(
    var fonteDemanda: String,
    var descricao: String,
    var objetivo: String,
    var historicoAcaoRegistro: List<AcaoRegistro>,
    var statusRegistro: StatusEnum,
    var prazoFinal: LocalDateTime
) {
    @Id
    lateinit var id: String
}