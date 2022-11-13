package com.dnslo.registrosbackend

import com.dnslo.registrosbackend.model.processos.AcaoRegistro
import com.dnslo.registrosbackend.model.processos.Registro
import com.dnslo.registrosbackend.model.StatusEnum
import com.dnslo.registrosbackend.repository.RegistroRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDateTime


@SpringBootApplication
class RegistrosBackendApplication {
    private val logger: org.slf4j.Logger? = org.slf4j.LoggerFactory.getLogger(Registro::class.java)
    @Bean
    fun runner(registroRepository: RegistroRepository) = CommandLineRunner {
        val acoes = listOf(
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
        registroRepository.insert(registro)
        logger?.info("$registro")
    }
}


fun main(args: Array<String>) {
    runApplication<RegistrosBackendApplication>(*args)
}
