package com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Released") String lancamento,
                            @JsonAlias("Episode") Integer episodio,
                            @JsonAlias("imdbRating")  String avaliacaoImdb) {
}
