package name.christianbauer.todo.client.framework;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType
public class Property {

    @JsType
    public enum Type {
        Boolean, Date, Number, String, Array, Object
    }

    @JsIgnore
    public Property() {
    }

    @JsIgnore
    public Property(Type type) {
        this(type, null);
    }

    @JsIgnore
    public Property(Type type, Object value) {
        this(type, value, false, false, false, null, null);
    }

    @JsIgnore
    public Property(Type type, boolean notify, Object value) {
        this(type, value, false, false, notify, null, null);
    }

    @JsIgnore
    public Property(Type type, boolean reflectToAttribute, boolean readOnly, boolean notify, String observer) {
        this(type, null, reflectToAttribute, readOnly, notify, null, observer);
    }

    @JsIgnore
    public Property(Type type, Object value, boolean reflectToAttribute, boolean readOnly, boolean notify, String computed, String observer) {
        setType(getGlobalObject(type.name()));
        setValue(value);
        setReflectToAttribute(reflectToAttribute);
        setReadOnly(readOnly);
        setNotify(notify);
        setComputed(computed);
        setObserver(observer);
    }

    protected Object type;
    protected Object value;
    protected boolean reflectToAttribute;
    protected boolean readOnly;
    protected boolean notify;
    protected String computed;
    protected String observer;

    @JsProperty
    public Object getType() {
        return type;
    }

    @JsProperty
    public void setType(Object type) {
        this.type = type;
    }

    @JsProperty
    public Object getValue() {
        return value;
    }

    @JsProperty
    public void setValue(Object value) {
        this.value = value;
    }

    @JsProperty
    public boolean isReflectToAttribute() {
        return reflectToAttribute;
    }

    @JsProperty
    public void setReflectToAttribute(boolean reflectToAttribute) {
        this.reflectToAttribute = reflectToAttribute;
    }

    @JsProperty
    public boolean isReadOnly() {
        return readOnly;
    }

    @JsProperty
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsProperty
    public boolean isNotify() {
        return notify;
    }

    @JsProperty
    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    @JsProperty
    public String getComputed() {
        return computed;
    }

    @JsProperty
    public void setComputed(String computed) {
        this.computed = computed;
    }

    @JsProperty
    public String getObserver() {
        return observer;
    }

    @JsProperty
    public void setObserver(String observer) {
        this.observer = observer;
    }

    @JsIgnore
    // TODO: I don't know JavaScript...
    static public native Object getGlobalObject(String key) /*-{
        return $wnd[key];
    }-*/;

}
