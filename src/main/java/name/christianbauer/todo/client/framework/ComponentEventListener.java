package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface ComponentEventListener<E> {
    void call(Component component, E event, Object detail);
}
