package org.serratec.backend.projeto03.controller;

import javax.mail.MessagingException;

import org.serratec.backend.projeto03.dto.CartaoDTO;
import org.serratec.backend.projeto03.exception.EmailException;
import org.serratec.backend.projeto03.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("/enviar")
	public void enviarEmail(CartaoDTO cartaoDTO) throws EmailException, MessagingException {
		emailService.emailTeste(cartaoDTO);
	}
	
}
