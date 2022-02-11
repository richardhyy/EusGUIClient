package cc.eumc.eusgui.model.event;

import cc.eumc.eusgui.model.component.GUIComponent;

public abstract class GUIEvent {
    private final String componentName;
    private final GUIEventType type;

    public GUIEvent(GUIEventType type, String sourceComponentName) {
        this.componentName = sourceComponentName;
        this.type = type;
    }

    public String getSourceComponentName() {
        return componentName;
    }
}
