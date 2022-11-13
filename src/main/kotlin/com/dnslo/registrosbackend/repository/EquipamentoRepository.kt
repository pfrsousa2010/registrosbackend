package com.dnslo.registrosbackend.repository

import com.dnslo.registrosbackend.model.equipamento.Equipamento
import org.springframework.data.mongodb.repository.MongoRepository

interface EquipamentoRepository : MongoRepository<Equipamento, String> {
}