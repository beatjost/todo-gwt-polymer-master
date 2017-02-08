package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface ComponentConsumer<T> {
    void accept(Component component, T t);
}
