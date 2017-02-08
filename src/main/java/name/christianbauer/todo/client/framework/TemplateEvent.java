package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType
public interface TemplateEvent<T> {

    @JsProperty
    TemplateInstance<T> getModel();

}
