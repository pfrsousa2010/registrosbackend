package com.dnslo.registrosbackend.model.equipamento

import java.time.LocalDateTime

class Calibracao(
    var data: LocalDateTime,
    var vencimento: LocalDateTime? = null,
    var descricao: String? = null,
    var statusCalibracao: StatusCalibracaoEnum
)