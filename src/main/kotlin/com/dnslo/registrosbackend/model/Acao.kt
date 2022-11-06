package com.dnslo.registrosbackend.model

import java.time.LocalDateTime

class Acao(
    var id: String,
    var descricao: String,
    var dataAcao: LocalDateTime,
    var statusAcao: StatusEnum,
    var prazoAcao: LocalDateTime
) {}