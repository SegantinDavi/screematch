package com.alura.screenmatch.main;

import com.alura.screenmatch.model.DadosSerie;
import com.alura.screenmatch.service.ConverterDados;
import com.alura.screenmatch.service.ObterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var dadosApi = new ObterDados();
		var endereco = "https://www.omdbapi.com/?t=Game%20of%20Thrones&apikey=c7bc87e0";
		var json = dadosApi.obterDados(endereco);
		System.out.println(json);
		ConverterDados conversorDados = new ConverterDados();
		DadosSerie dadosSerie = conversorDados.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
