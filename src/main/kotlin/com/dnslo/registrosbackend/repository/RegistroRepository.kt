package com.dnslo.registrosbackend.repository

import com.dnslo.registrosbackend.model.processos.Registro
import org.springframework.data.mongodb.repository.MongoRepository

interface RegistroRepository : MongoRepository<Registro, String> {
}