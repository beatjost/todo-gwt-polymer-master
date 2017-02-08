package name.christianbauer.todo.client.events;

import jsinterop.annotations.JsType;
import name.christianbauer.todo.client.model.TodoItem;

@JsType
public class TodoItemRemoveEvent extends TodoItemEvent {
    public TodoItemRemoveEvent(TodoItem item) {
        super(item);
    }
}
