package com.dnslo.registrosbackend.model.equipamento

import java.time.LocalDateTime

class Calibracao(
    var datahora: LocalDateTime,
    var vencimento: LocalDateTime? = null,
    var responsavel: String? = null,
    var descricao: String? = null,
    var statusCalibracao: StatusCalibracaoEnum
)