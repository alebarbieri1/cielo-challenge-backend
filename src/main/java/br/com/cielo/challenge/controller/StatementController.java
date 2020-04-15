package br.com.cielo.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.challenge.model.Statement;
import br.com.cielo.challenge.service.StatementService;

@RestController
@RequestMapping("/statement")
@CrossOrigin
public class StatementController {

	@Autowired
	private StatementService statementService;

	@GetMapping
	public ResponseEntity<List<Statement>> findStatement() {

		List<Statement> statement = statementService.findStatement();

		return ResponseEntity.ok(statement);
	}

}
