package com.dnslo.registrosbackend.repository

import com.dnslo.registrosbackend.model.Registro
import org.springframework.data.mongodb.repository.MongoRepository

interface RegistroRepository : MongoRepository<Registro, String> {
}