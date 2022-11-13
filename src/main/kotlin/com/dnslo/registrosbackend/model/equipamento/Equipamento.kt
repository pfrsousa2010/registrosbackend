package com.dnslo.registrosbackend.model.equipamento

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document
class Equipamento(
    var descricao: String,
    var ultimaAtualizacao: LocalDateTime,
    var ultimaLocalizacao: String,
    var numeroPatrimonio: String? = null,
    var marcaModelo: String? = null,
    var numeroSerie: String? = null,
    var calibracao: Calibracao? = null,
    var historicoAcoes: List<AcaoEquipamento>? = null,
    var statusOperacional: StatusOperacionalEnum

) {
    @Id
    lateinit var id: String
}