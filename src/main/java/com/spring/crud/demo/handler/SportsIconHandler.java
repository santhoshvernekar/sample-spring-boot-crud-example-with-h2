package com.spring.crud.demo.handler;


import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.service.ReactiveSportsIconService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SportsIconHandler {

    private final ReactiveSportsIconService reactiveSportsIconService;


    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        Flux<?> list = reactiveSportsIconService.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(list, SportsIcon.class);
    }


    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<SportsIcon> superHeroMono = reactiveSportsIconService.findById(id);
        return ServerResponse.ok().body(superHeroMono, SportsIcon.class);
    }


    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<SportsIcon> superHero = serverRequest.bodyToMono(SportsIcon.class);
        Mono<SportsIcon> superHeroMono = reactiveSportsIconService.save(superHero.block());
        return ServerResponse.ok().body(superHeroMono, SportsIcon.class);
    }


    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<SportsIcon> superHero = serverRequest.bodyToMono(SportsIcon.class);
        Mono<SportsIcon> superHeroMono = reactiveSportsIconService.update(id, superHero.block());
        return ServerResponse.ok().body(superHeroMono, SportsIcon.class);
    }


    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Void> superHeroMono = reactiveSportsIconService.delete(id);
        return ServerResponse.ok().body("Deleted successfully...!", String.class);
    }

}
