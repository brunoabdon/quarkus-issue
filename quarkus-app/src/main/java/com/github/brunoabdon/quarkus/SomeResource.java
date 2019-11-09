package com.github.brunoabdon.quarkus;

import javax.ws.rs.Path;

import com.github.brunoabdon.quarkus.SomeSuperclass;
import com.github.brunoabdon.quarkus.ReturnType;

@Path("")
public class SomeResource extends SomeSuperclass {

    @Override
    protected ReturnType getSomething() {
        return null;
    }
}
