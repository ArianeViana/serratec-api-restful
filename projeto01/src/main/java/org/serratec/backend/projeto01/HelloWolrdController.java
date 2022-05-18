package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/teste")
@RestController
public class HelloWolrdController {
	
	@RequestMapping("/ola")
	public String olaMundo() {
		return "olá mundo!";
	}
	
	@RequestMapping("/maiuscula")
	public String toUpper(@RequestParam String valor) {
		return valor.toUpperCase();
	}
}
