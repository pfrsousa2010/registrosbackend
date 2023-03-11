package com.dnslo.registrosbackend.model.equipamento

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document
data class Equipamento(
    var descricao: String,
    var ultimaAtualizacao: LocalDateTime? = null,
    var ultimaLocalizacao: String? = null,
    var numeroPatrimonio: String? = null,
    var marcaModelo: String? = null,
    var numeroSerie: String? = null,
    var calibracao: Calibracao? = null,
    var historicoAcoes: MutableList<AcaoEquipamento>? = mutableListOf(),
    var historicoLocalizacao: MutableList<Localizacao>? = mutableListOf(),
    var statusOperacional: StatusOperacionalEnum

) {
    @Id
    lateinit var id: String
}