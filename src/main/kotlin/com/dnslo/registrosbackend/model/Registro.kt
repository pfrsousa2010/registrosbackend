package com.dnslo.registrosbackend.model

import java.time.LocalDateTime

class Registro(
    var id: String,
    var fonteDemanda: String,
    var descricao: String,
    var objetivo: String,
    var historicoAcao: List<Acao>,
    var statusRegistro: StatusEnum,
    var prazoFinal: LocalDateTime
) {}