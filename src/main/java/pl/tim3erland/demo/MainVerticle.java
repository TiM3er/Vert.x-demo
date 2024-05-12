package pl.tim3erland.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        var router = Router.router(vertx);
        router.get("/api/v1/hello").handler(routingContext -> {
            routingContext.request().response().end("Hello Vert.x World!");
        });
        router.get("/api/v1/hello/:name").handler(routingContext -> {
            var name = routingContext.pathParam("name");
            routingContext.request().response().end(String.format("Hello " + name + " !")  );
        });

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }
}
//