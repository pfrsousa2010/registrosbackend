package com.dnslo.registrosbackend

import com.dnslo.registrosbackend.model.processos.Registro
import com.dnslo.registrosbackend.repository.EquipamentoRepository
import org.modelmapper.ModelMapper
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class RegistrosBackendApplication {
    private val logger: org.slf4j.Logger? = org.slf4j.LoggerFactory.getLogger(Registro::class.java)

    @Bean
    fun modelMapper(): ModelMapper? {
        val modelMapper = ModelMapper()
        modelMapper.configuration.isSkipNullEnabled = true
        return modelMapper
    }

    @Bean
    fun runner(equipamentoRepository: EquipamentoRepository) = CommandLineRunner {
         //registro
        /*val acoes = listOf(
                AcaoRegistro(
                    descricao = "Esta é uma ação #1",
                    prazoAcao = LocalDateTime.now().plusMonths(2),
                    statusAcao = StatusEnum.EM_ANDAMENTO,
                    dataAcao = LocalDateTime.now()
                ),
                AcaoRegistro(
                    descricao = "Esta é uma ação #2",
                    prazoAcao = LocalDateTime.now().plusMonths(1),
                    statusAcao = StatusEnum.AGUARDANDO,
                    dataAcao = LocalDateTime.now().plusHours(1)

                )
            )
            val registro = Registro(
                fonteDemanda = "Relatorio xxx",
                descricao = "Exemplo de um registro #1",
                objetivo = "Adicionar este registro",
                historicoAcaoRegistro = acoes,
                statusRegistro = StatusEnum.AGUARDANDO,
                prazoFinal = LocalDateTime.now().plusMonths(4)
            )
            registroRepository.insert(registro)*/

        //equipamento
        /*val calibracao = Calibracao(
            datahora = LocalDateTime.now().minusDays(10),
            vencimento = LocalDateTime.now().plusMonths(1),
            responsavel = "Téc. Kimura",
            descricao = "Foi realizada a calibração.",
            statusCalibracao = StatusCalibracaoEnum.CALIBRADO
        )
        val acoes = listOf<AcaoEquipamento>(
            AcaoEquipamento(
                descricao = "Enviado para calibração",
                inicio = LocalDateTime.now().minusDays(15),
                fim = LocalDateTime.now().minusDays(9),
                historicoLocalizacao = listOf<Localizacao>(
                    Localizacao(
                        local = "EMS",
                        datahora = LocalDateTime.now().minusHours(5)
                    ),
                    Localizacao(
                        local = "EMA",
                        datahora = LocalDateTime.now().minusDays(2)
                    )
                ),
                status = StatusEnum.CONCLUIDO,
                responsavel = "Philipe Torii",
                prazo = LocalDateTime.now().plusMonths(3),
                observacao = "Realização de calibração",
                historicoStatus = listOf(
                    StatusAcao(
                        status = StatusEnum.AGUARDANDO,
                        datahora = LocalDateTime.now().minusDays(10),
                        localização = "EMS",
                        observacao = "Alguma coisa"
                    ),
                    StatusAcao(
                        status = StatusEnum.EM_ANDAMENTO,
                        datahora = LocalDateTime.now().minusDays(5),
                        localização = "EMS"
                    ),
                    StatusAcao(
                        status = StatusEnum.CONCLUIDO,
                        datahora = LocalDateTime.now().minusDays(1),
                        localização = "EMA",
                        observacao = "Mudou para EMA depois de calibrado."
                    )
                )
            ),
            AcaoEquipamento(
                descricao = "Recebido da manutenção",
                inicio = LocalDateTime.now().minusDays(15),
                fim = LocalDateTime.now().minusDays(9),
                historicoLocalizacao = listOf<Localizacao>(
                    Localizacao(
                        local = "EMS",
                        datahora = LocalDateTime.now().minusHours(5)
                    ),
                    Localizacao(
                        local = "EMA",
                        datahora = LocalDateTime.now().minusDays(2)
                    )
                ),
                status = StatusEnum.CONCLUIDO,
                responsavel = "Philipe Torii",
                prazo = LocalDateTime.now().plusMonths(3),
                observacao = "Realização de calibração",
                historicoStatus = listOf(
                    StatusAcao(
                        status = StatusEnum.AGUARDANDO,
                        datahora = LocalDateTime.now().minusDays(10),
                        localização = "EMS",
                        observacao = "Alguma coisa"
                    ),
                    StatusAcao(
                        status = StatusEnum.EM_ANDAMENTO,
                        datahora = LocalDateTime.now().minusDays(5),
                        localização = "EMS"
                    ),
                    StatusAcao(
                        status = StatusEnum.CONCLUIDO,
                        datahora = LocalDateTime.now().minusDays(1),
                        localização = "EMA",
                        observacao = "Mudou para EMA depois de calibrado."
                    )
                )
            )
        )

        val equipamento = Equipamento(
            descricao = "Algum equipamento",
            ultimaAtualizacao = LocalDateTime.now(),
            ultimaLocalizacao = "EMA",
            numeroPatrimonio = "asd11901823",
            numeroSerie = "SN1311",
            calibracao = calibracao,
            historicoAcoes = acoes,
            statusOperacional = StatusOperacionalEnum.EM_USO
        )
        equipamentoRepository.save(equipamento)

        logger?.info("$equipamento")*/
    }
}


fun main(args: Array<String>) {
    runApplication<RegistrosBackendApplication>(*args)
}
