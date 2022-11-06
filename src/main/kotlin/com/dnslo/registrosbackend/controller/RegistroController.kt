package com.dnslo.registrosbackend.controller

import com.dnslo.registrosbackend.service.RegistroService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/registro")
class RegistroController(
    private val registroService: RegistroService
) {
}