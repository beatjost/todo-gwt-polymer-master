package name.christianbauer.todo.client.framework;

import elemental.js.util.JsArrayOf;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;

@JsType
public class ArrayProperty extends Property {

    @JsIgnore
    public ArrayProperty() {
        super(Type.Array, JsArrayOf.create());
    }

    @JsIgnore
    public ArrayProperty(boolean reflectToAttribute, boolean readOnly, boolean notify) {
        super(Type.Array, JsArrayOf.create(), reflectToAttribute, readOnly, notify, null, null);
    }

    @JsIgnore
    public ArrayProperty(boolean reflectToAttribute, boolean readOnly, boolean notify, String computed, String observer) {
        super(Type.Array, JsArrayOf.create(), reflectToAttribute, readOnly, notify, computed, observer);
    }

    @JsIgnore
    public ArrayProperty(Object... items) {
        super(Type.Array, JsArrayOf.create());
        if (items != null) {
            JsArrayOf<Object> array = (JsArrayOf) getValue();
            for (Object item : items) {
                array.push(item);
            }
        }
    }
}
