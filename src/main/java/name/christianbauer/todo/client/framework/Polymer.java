package name.christianbauer.todo.client.framework;

import elemental.dom.Element;

public class Polymer {

    static public native void log(Object o) /*-{
        console.dir(o);
    }-*/;

    static public native void logKeys(Object o) /*-{
        console.log(Object.keys(o));
    }-*/;

    static public native void register(ComponentType componentType) /*-{
        var ctor = $wnd.Polymer.Class(componentType);
        $doc.registerElement(componentType.is, ctor);
    }-*/;

    static public native Component.DOM dom(Element element) /*-{
        return $wnd.Polymer.dom(element);
    }-*/;

}
