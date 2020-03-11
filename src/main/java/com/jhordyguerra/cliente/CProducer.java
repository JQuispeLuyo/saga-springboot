package com.jhordyguerra.cliente;

import com.jhordyguerra.cliente.service.MyKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class CProducer {

	@Autowired
	private MyKafka myKafka;

	@GetMapping(value = "/send/{message}")
	public String send(@PathVariable("message") String message) {
		try {
			myKafka.sendMessage(message);
			return "Your message was sent successfully!";
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
			return "Server error!";
		}
		
	}

	@GetMapping(value = "/receive")
	public String receive() {
		return "hola";
	}

}