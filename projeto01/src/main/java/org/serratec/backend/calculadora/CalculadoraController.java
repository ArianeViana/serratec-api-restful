package org.serratec.backend.calculadora;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
		
	    @RequestMapping("/soma")
		public float soma(@RequestParam float n1, float n2) {
			return n1 + n2;
		}
	    
	    @RequestMapping("/subtracao")
		public float subtracao(@RequestParam float n1, float n2) {
			return n1 - n2;
		}
	    
	    @RequestMapping("/multiplicacao")
		public float multiplicacao(@RequestParam float n1, float n2) {
			return n1 * n2;
		}
	    
	    @RequestMapping("/divisao")
		public float divisao(@RequestParam float n1, float n2) {
			return n1 / n2;
		}
}
