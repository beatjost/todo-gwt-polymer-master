package name.christianbauer.todo.client.framework;

import static name.christianbauer.todo.client.framework.ComponentEvent.getListenerName;
import static name.christianbauer.todo.client.framework.ComponentEvent.getType;
import static name.christianbauer.todo.client.framework.Polymer.register;

import elemental.js.util.JsMapFromStringTo;
import elemental.js.util.JsMapFromStringToString;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;

@JsType
public class ComponentType {

    public String is;

    public Callback registered;

    public ComponentCallback ready;

    public ComponentCallback attached;

    final public JsMapFromStringTo<Property> properties = JsMapFromStringTo.create();

    final public JsMapFromStringToString listeners = JsMapFromStringToString.create();

    public String[] observers = new String[0];

    public ComponentType(String is, ComponentType... dependencies) {
        this.is = is;

        if (dependencies != null) {
            registered = () -> {
                for (ComponentType dependency : dependencies) {
                    register(dependency);
                }
            };
        }
    }

    @JsIgnore
    public void enableListener(Class<? extends ComponentEvent> eventClass) {
        listeners.put(getType(eventClass), getListenerName(eventClass));
    }

    @JsIgnore
    // TODO https://www.mail-archive.com/google-web-toolkit-contributors@googlegroups.com/msg33431.html
    static public native <T, R> ComponentFunction<T, R> onInstanceOf(ComponentFunction<T, R> impl) /*-{
        return function (t) {
            return impl.@name.christianbauer.todo.client.framework.ComponentFunction::apply(*)(this, t);
        }
    }-*/;

    @JsIgnore
    static public native ComponentCallback onInstanceOf(ComponentCallback impl) /*-{
        return function () {
            impl.@name.christianbauer.todo.client.framework.ComponentCallback::call(*)(this);
        }
    }-*/;

    @JsIgnore
    static public native <T> ComponentConsumer<T> onInstanceOf(ComponentConsumer<T> impl) /*-{
        return function (t) {
            impl.@name.christianbauer.todo.client.framework.ComponentConsumer::accept(*)(this, t);
        }
    }-*/;

    @JsIgnore
    static public native <E> ComponentEventListener<E> onInstanceOf(ComponentEventListener<E> impl) /*-{
        return function (event, detail) {
            impl.@name.christianbauer.todo.client.framework.ComponentEventListener::call(*)(this, event, detail);
        }
    }-*/;

}
