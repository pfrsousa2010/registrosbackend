package com.dnslo.registrosbackend.model.equipamento

import java.time.LocalDate

data class Calibracao(
    var data: LocalDate,
    var vencimento: LocalDate? = null,
    var responsavel: String? = null,
    var descricao: String? = null,
    var statusCalibracao: StatusCalibracaoEnum
)