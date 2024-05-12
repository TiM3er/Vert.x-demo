package pl.tim3erland.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.deployVerticle(new HelloVerticle());
        var router = Router.router(vertx);
        router.get("/api/v1/hello").handler(routingContext -> {
            vertx.eventBus().request("hello.vertx.addr", "", reply -> {
                routingContext.request().response().end((String) reply.result().body());
            });
        });
        router.get("/api/v1/hello/:name").handler(routingContext -> {
            var name = routingContext.pathParam("name");
            vertx.eventBus().request("hello.named.addr", name, reply -> {
                routingContext.request().response().end((String) reply.result().body());
            });        });

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }
}
//