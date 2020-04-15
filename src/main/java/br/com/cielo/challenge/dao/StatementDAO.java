package br.com.cielo.challenge.dao;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cielo.challenge.model.Statement;

@Repository
public class StatementDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${statement.filename}")
	private String filename;

	public List<Statement> findStatement() {
		try {
			Resource resource = new ClassPathResource(filename);
			File file = resource.getFile();
			String content = new String(Files.readAllBytes(file.toPath()));
			JSONObject json = new JSONObject(content);
			JSONArray array = json.getJSONArray("listaControleLancamento");
			ObjectMapper mapper = new ObjectMapper();
			List<Statement> statement = Arrays.asList(mapper.readValue(array.toString(), Statement[].class));

			return statement;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
	}
}