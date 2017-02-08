package name.christianbauer.todo.client.framework;

import java.util.Locale;
import java.util.logging.Logger;

import elemental.js.util.JsMapFromStringTo;

public abstract class ComponentEvent {

    protected JsMapFromStringTo options = JsMapFromStringTo.create();

    public ComponentEvent() {
        this(true);
    }

    public ComponentEvent(boolean bubbles) {
        options.put("bubbles", bubbles);
    }

    private static final Logger LOG = Logger.getLogger(ComponentEvent.class.getName());

    public static String getType(String simpleClassName) {
        String type = toLowerCaseDash(simpleClassName);

        if (type.length() > 6 && type.substring(type.length()-6).equals("-event"))
            type = type.substring(0, type.length()-6);

        return type;
    }

    public static String getType(Class<? extends ComponentEvent> eventClass) {
        return getType(eventClass.getSimpleName());
    }

    public String getType() {
        return getType(getClass());
    }

    public static String getListenerName(Class<? extends ComponentEvent> eventClass) {
        String listenerName = "on" + eventClass.getSimpleName();
        if (listenerName.substring(listenerName.length()-5).equals("Event")) {
            listenerName = listenerName.substring(0, listenerName.length()-5);
        }
        return listenerName;
    }

    public void fire(Component component) {
        LOG.fine("Firing event on '" + component.getLocalName() + "': " + getType());
        component.fire(getType(), getDetail(), getOptions());
    }

    public JsMapFromStringTo getOptions() {
        return options;
    }

    public abstract Object getDetail();

    /**
     * Transforms 'EXFooBar123' into 'ex-foo-bar-123 and "attributeX" into "attribute-x" without regex (GWT!)
     */
    public static String toLowerCaseDash(String camelCase) {
        if (camelCase == null)
            return null;
        if (camelCase.length() == 0)
            return camelCase;
        StringBuilder sb = new StringBuilder();
        char[] chars = camelCase.toCharArray();
        boolean inNonLowerCase = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!Character.isLowerCase(c)) {
                if (!inNonLowerCase) {
                    if (i > 0)
                        sb.append("-");
                } else if (i < chars.length - 1 && Character.isLowerCase(chars[i + 1])) {
                    sb.append("-");
                }
                inNonLowerCase = true;
            } else {
                inNonLowerCase = false;
            }
            sb.append(c);
        }
        String name = sb.toString();
        name = name.toLowerCase(Locale.ROOT);
        return name;
    }
}
