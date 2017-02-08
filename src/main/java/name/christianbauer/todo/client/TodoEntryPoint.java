package name.christianbauer.todo.client;

import static name.christianbauer.todo.client.framework.Polymer.register;

import java.util.logging.Logger;

import name.christianbauer.todo.client.components.TodoListType;

public class TodoEntryPoint implements com.google.gwt.core.client.EntryPoint {

    private static final Logger LOG = Logger.getLogger(TodoEntryPoint.class.getName());

    @Override
    public void onModuleLoad() {
        register(new TodoListType());
    }
}
