package pl.tim3erland.demo;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer()
        .requestHandler(req ->
        {
            req.response().end("Heeelo Vert.x World!");
        }).listen(8080);
    }
}
//