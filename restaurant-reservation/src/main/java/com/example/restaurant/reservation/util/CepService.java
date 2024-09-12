package com.example.restaurant.reservation.util;

import com.example.restaurant.reservation.entities.Location;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CepService {
    private final WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws/").build();
    }

    public Mono<Location> buscarLocalizacaoPorCep(String cep) {
        return this.webClient.get()
                .uri(cep + "/json/")
                .retrieve()
                .bodyToMono(Location.class);
    }
}

