package cc.eumc.eusgui.model.event;

public class KeyPressEvent extends GUIEvent {
    private final int keyCode;
    private final int scanCode;
    private final int modifiers;

    public KeyPressEvent(String sourceComponentName, int keyCode, int scanCode, int modifiers) {
        super(GUIEventType.KEY_PRESSED, sourceComponentName);

        this.keyCode = keyCode;
        this.scanCode = scanCode;
        this.modifiers = modifiers;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getScanCode() {
        return scanCode;
    }

    public int getModifiers() {
        return modifiers;
    }

    @Override
    public String toString() {
        return "KeyPressEvent{" +
                "keyCode=" + keyCode +
                ", scanCode=" + scanCode +
                ", modifiers=" + modifiers +
                '}';
    }
}
