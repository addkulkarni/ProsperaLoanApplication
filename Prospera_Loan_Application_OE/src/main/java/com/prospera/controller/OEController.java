package com.prospera.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OEController
{
	@GetMapping("/")
	public String homepage()
	{
		return "OE is running";
	}
}
