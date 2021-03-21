package com.platzi.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {

    @GetMapping("/hola")
    public String saludar(){
        return "nunca pares de aprender! \uD83E\uDDD1\uD83C\uDFFC\u200D\uD83D\uDE80";
    }
}
