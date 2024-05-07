package com.alura.screenmatch.main;

import com.alura.screenmatch.model.DadosSerie;
import com.alura.screenmatch.model.DadosTemporada;
import com.alura.screenmatch.service.ConverterDados;
import com.alura.screenmatch.service.ObterDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ObterDados dadosApi = new ObterDados();
    private ConverterDados conversorDados = new ConverterDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=c7bc87e0";

    public void exibirMenu(){
        System.out.println("Digite o nome da serie:");
        var serie = scanner.nextLine().replace(" ", "+");
        var json = dadosApi.obterDados(ENDERECO + serie + API_KEY);
        DadosSerie dadosSerie = conversorDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dadosSerie.totalDeTemporadas(); i++) {
			var jsonTemporada = dadosApi.obterDados( ENDERECO + serie + "&Season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversorDados.obterDados(jsonTemporada, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.episodio() + " " + e.titulo())));
    }
}
