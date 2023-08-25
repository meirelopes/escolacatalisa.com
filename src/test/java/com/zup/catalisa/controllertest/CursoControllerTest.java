package com.zup.catalisa.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zup.catalisa.api.controller.CursoController;
import com.zup.catalisa.model.Curso;
import com.zup.catalisa.service.CursoService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.Optional;

@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CursoController cursoController;
    @MockBean
    CursoService cursoService;

    @BeforeEach
    public void setup() {

        RestAssuredMockMvc.standaloneSetup(this.cursoController);

    }

    @Test
    public void deveRetornarSucessoEUmCurso_QuandoBuscarCurso() {
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNome("Engenharia Civil");
        curso.setCargaHoraria(3600);


        Mockito.when(this.cursoService.listarPorId(1L)).thenReturn(Optional.of(curso));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/cursos/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornarNaoEncontrado_QuandoBuscarCursoInexistente() {

        Mockito.when(this.cursoService.listarPorId(5L))
                .thenReturn(Optional.empty());

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/cursos/{id}", 5L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveRetornarUmCursoEStatusOk_QuandoBuscarUmCurso() throws Exception {

        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNome("Engenharia Civil");
        curso.setCargaHoraria(3600);

        Mockito.when(cursoService.listarPorId(Mockito.anyLong()))
                .thenReturn(Optional.of(curso));

        mockMvc.perform(get("/cursos/{id}", 1L)) // Substitua 1L pelo ID desejado
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(curso.getId()))
                .andExpect(jsonPath("$.nome").value(curso.getNome()))
                .andExpect(jsonPath("$.cargaHoraria").value(curso.getCargaHoraria()));

    }

    @Test
    public void deveRetornarStatusOkEUmCurso_QuandoCadastrarUmCurso() throws Exception {

        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNome("Engenharia Civil");
        curso.setCargaHoraria(3600);

        Mockito.when(cursoService.cadastrar(curso)).thenReturn(curso);

        mockMvc.perform(MockMvcRequestBuilders.post("/cursos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(curso)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))  // Verifica o ID retornado
                .andExpect(jsonPath("$.nome").value("Engenharia Civil"))  // Verifica o nome retornado
                .andExpect(jsonPath("$.cargaHoraria").value(3600));  // Verifica a cargaHoraria retornado
    }

}

