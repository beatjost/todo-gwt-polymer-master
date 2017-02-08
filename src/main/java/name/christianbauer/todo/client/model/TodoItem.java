package name.christianbauer.todo.client.model;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType
public class TodoItem {

    protected String title;
    protected boolean done;

    @JsIgnore
    public TodoItem(String title) {
        this(title, false);
    }

    @JsIgnore
    public TodoItem(String title, boolean done) {
        setTitle(title);
        setDone(done);
    }

    @JsProperty
    public String getTitle() {
        return title;
    }

    @JsProperty
    public void setTitle(String title) {
        this.title = title;
    }

    @JsProperty
    public boolean isDone() {
        return done;
    }

    @JsProperty
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
            "title='" + getTitle()+ '\'' +
            ", done=" + isDone() +
            '}';
    }
}
