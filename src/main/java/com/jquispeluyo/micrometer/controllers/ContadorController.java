package com.jquispeluyo.micrometer.controllers;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ContadorController {

	private Counter counter1;
	private Counter counter2;

	public ContadorController(MeterRegistry registry) {
		this.counter1 = Counter.builder("contador.test").tag("N", "1").description("Contador del EndPoint 1").register(registry);
		this.counter2 = Counter.builder("contador.test").tag("N", "2").description("Contador del EndPoint 2").register(registry);
	}

	@GetMapping("/contador1")
	public String home() throws Exception {
		counter1.increment();
		return String.format("Cantidad de veces que se ha invocado el contador1 (%s)", counter1.count());
	}
	
	@GetMapping("/contador2")
	public String other() throws Exception {
		counter2.increment();
		return String.format("Cantidad de veces que se ha invocado el contador2 (%s)", counter2.count());
	}
	
}
