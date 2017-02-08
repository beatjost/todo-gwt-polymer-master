package name.christianbauer.todo.client.events;

import jsinterop.annotations.JsType;
import name.christianbauer.todo.client.framework.TemplateEvent;
import name.christianbauer.todo.client.model.TodoItem;

@JsType
public interface TodoItemTemplateEvent extends TemplateEvent<TodoItem> {
}
