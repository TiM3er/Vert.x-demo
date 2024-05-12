package pl.tim3erland.demo;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("hello.vertx.addr", msg -> {
            msg.reply("Hello Vert. Wordls");
        });
        vertx.eventBus().consumer("hello.named.addr", msg -> {
            var name = (String) msg.body();
            msg.reply("Hello " + name + " Wordls");
        });
    }
}
