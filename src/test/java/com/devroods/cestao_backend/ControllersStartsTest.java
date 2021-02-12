package com.devroods.cestao_backend;

import static org.assertj.core.api.Assertions.assertThat;

import com.devroods.cestao_backend.controllers.CestaoController;
import com.devroods.cestao_backend.controllers.NotaController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

class ControllersStartsTest {

	@Autowired
	private CestaoController cestaoController;
	@Autowired
	private NotaController notaController;

	
	void cestaoControllerLoads() {
		assertThat(cestaoController).isNotNull();
	}

}
