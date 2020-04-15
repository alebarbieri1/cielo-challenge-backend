package br.com.cielo.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cielo.challenge.dao.StatementDAO;
import br.com.cielo.challenge.model.Statement;

@Service
public class StatementService {

	@Autowired
	private StatementDAO statementDAO;

	public List<Statement> findStatement() throws Exception {
		return statementDAO.findStatement();
	}
}