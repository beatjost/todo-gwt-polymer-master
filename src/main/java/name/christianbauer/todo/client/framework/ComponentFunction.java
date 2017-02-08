package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface ComponentFunction<T, R> {
    R apply(Component component, T t);
}
