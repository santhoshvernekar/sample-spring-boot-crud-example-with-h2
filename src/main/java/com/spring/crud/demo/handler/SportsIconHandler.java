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
        Mono<SportsIcon> sportsIconMono = reactiveSportsIconService.findById(id);
        return ServerResponse.ok().body(sportsIconMono, SportsIcon.class);
    }


    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<SportsIcon> sportsIcon = serverRequest.bodyToMono(SportsIcon.class);
        Mono<SportsIcon> sportsIconMono = reactiveSportsIconService.save(sportsIcon.block());
        return ServerResponse.ok().body(sportsIconMono, SportsIcon.class);
    }


    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<SportsIcon> sportsIcon = serverRequest.bodyToMono(SportsIcon.class);
        Mono<SportsIcon> sportsIconMono = reactiveSportsIconService.update(id, sportsIcon.block());
        return ServerResponse.ok().body(sportsIconMono, SportsIcon.class);
    }


    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Void> sportsIconMono = reactiveSportsIconService.delete(id);
        return ServerResponse.ok().body("Deleted successfully...!", String.class);
    }

}
