package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType
public interface TemplateInstance<T> {

    @JsProperty
    int getIndex();

    @JsProperty
    T getItem();

}
