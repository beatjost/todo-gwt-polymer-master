package name.christianbauer.todo.client.components;

import static name.christianbauer.todo.client.framework.Property.Type.Number;

import elemental.js.util.JsArrayOf;
import jsinterop.annotations.JsType;
import name.christianbauer.todo.client.events.TodoItemTemplateEvent;
import name.christianbauer.todo.client.framework.ArrayProperty;
import name.christianbauer.todo.client.framework.ComponentCallback;
import name.christianbauer.todo.client.framework.ComponentEventListener;
import name.christianbauer.todo.client.framework.ComponentType;
import name.christianbauer.todo.client.framework.Function;
import name.christianbauer.todo.client.framework.Property;
import name.christianbauer.todo.client.model.TodoItem;

@JsType
public class TodoListType extends ComponentType {

    final public Function<Double, Double> calculateIndex;

    final public ComponentCallback todoItemsChanged;

    final public ComponentCallback addItem;

    final public ComponentEventListener<TodoItemTemplateEvent> removeItem;

    public TodoListType() {
        super("todo-list", new TodoItemDetailType());

        properties.put("todoItems", new ArrayProperty(
            new TodoItem("Some test data...", false),
            new TodoItem("More test data...", false)
        ));
        properties.put("openItems", new Property(Number, 0));
        properties.put("doneItems", new Property(Number, 0));

        observers = new String[]{
            "todoItemsChanged(todoItems.*)"
        };

        calculateIndex = index -> index + 1;

        todoItemsChanged = onInstanceOf(component -> {
            JsArrayOf<TodoItem> items = component.get("todoItems");
            int open = 0;
            int done = 0;
            for (int i = 0; i < items.length(); i++) {
                if (items.get(i).isDone()) {
                    done++;
                } else {
                    open++;
                }
            }
            component.set("openItems", open);
            component.set("doneItems", done);
        });

        addItem = onInstanceOf(component -> {
            component.push("todoItems", new TodoItem("I have something to do...", false));
        });

        removeItem = onInstanceOf((component, event, detail) -> {
            component.splice("todoItems", event.getModel().getIndex(), 1);
        });
    }
}
