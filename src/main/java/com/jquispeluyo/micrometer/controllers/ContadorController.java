package com.jquispeluyo.micrometer.controllers;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequestMapping("/")
public class ContadorController {

	private Counter counter;

	public ContadorController(MeterRegistry registry) {
		this.counter = Counter.builder("service.invocations").description("Total service invocations").register(registry);
	}

	@GetMapping
	public String home() throws Exception {
		counter.increment();
		return String.format("Hello world, cantidad de veces que se ha invocado el hola mundo (%s)", counter.count());
	}
	
}
