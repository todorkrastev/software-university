package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.cats.design_pattern.speciffication.Handler;
import bg.softuni.intro.cats.design_pattern.speciffication.HandlerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
@Scope("singleton")
public class HandlerFactoryImpl implements HandlerFactory {
    private Handler handler;

    @Override
    public Handler getHandler() {
        return handler;
    }

    public HandlerFactoryImpl(List<Handler> handlers) {
        for (int i = 1; i < handlers.size(); i++) {
            handlers.get(i-1).setSuccessor(handlers.get(i));
        }

        this.handler = handlers.get(0);
    }
}
