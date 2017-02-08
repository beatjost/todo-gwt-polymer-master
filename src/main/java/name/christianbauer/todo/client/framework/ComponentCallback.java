package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface ComponentCallback {
    void call(Component component);
}
