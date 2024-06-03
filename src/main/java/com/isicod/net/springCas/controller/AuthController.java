package com.isicod.net.springCas.controller;

import java.util.Collections;
import java.util.Date;

import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Cas30ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isicod.net.springCas.security.constants.SecurityConstants;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private Cas30ServiceTicketValidator ticketValidator;

	@GetMapping("jwt")
	public ResponseEntity<?> getJwt(@RequestParam("ticket") String ticket, @RequestParam("service") String service) {

		try {
			Assertion assertion = ticketValidator.validate(ticket, service);
			String username = assertion.getPrincipal().getName();

			String token = JWT.create().withSubject(username)
					.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION))
					.sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));

			return ResponseEntity.ok(Collections.singletonMap("jwt", token));

		} catch (TicketValidationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid service ticket");
		}
	}
}
