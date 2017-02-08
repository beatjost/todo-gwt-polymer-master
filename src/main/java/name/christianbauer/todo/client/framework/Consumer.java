package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface Consumer<T> {
    void accept(T var1);
}
