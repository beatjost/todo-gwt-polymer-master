package name.christianbauer.todo.client.components;

import static name.christianbauer.todo.client.framework.Property.Type.Object;

import jsinterop.annotations.JsType;
import name.christianbauer.todo.client.events.TodoItemChangedEvent;
import name.christianbauer.todo.client.events.TodoItemRemoveEvent;
import name.christianbauer.todo.client.framework.ComponentCallback;
import name.christianbauer.todo.client.framework.ComponentType;
import name.christianbauer.todo.client.framework.Property;

@JsType
public class TodoItemDetailType extends ComponentType {

    final public ComponentCallback removeItem;

    final public ComponentCallback todoItemChanged;

    public TodoItemDetailType() {
        super("todo-item-detail");

        properties.put("todoItem", new Property(Object, false, false, false, "todoItemChanged"));

        removeItem = onInstanceOf(component -> {
            new TodoItemRemoveEvent(component.get("todoItem"))
                .fire(component);
        });

        todoItemChanged = onInstanceOf(component -> {
            new TodoItemChangedEvent(component.get("todoItem"))
                .fire(component);
        });
    }
}
