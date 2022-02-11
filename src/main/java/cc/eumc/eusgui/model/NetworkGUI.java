package cc.eumc.eusgui.model;

import cc.eumc.eusgui.EusGUI;
import cc.eumc.eusgui.model.component.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.Nullable;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class NetworkGUI {
    private int id;
    private String title;
    private final List<GUIComponent> components;
    private transient int focusIndex = -1;

    public NetworkGUI(int id, String title) {
        this.id = id;
        this.title = title;
        this.components = new ArrayList<>();
    }

    public NetworkGUI(int id, String title, List<GUIComponent> components, int focusIndex) {
        this.id = id;
        this.title = title;
        this.components = components;
        this.focusIndex = focusIndex;
    }

    public static NetworkGUI fromJson(String json) {
        JsonElement jelement = JsonParser.parseReader(new JsonReader(new StringReader(json)));
        JsonObject jobject = jelement.getAsJsonObject();

        int id = jobject.get("id").getAsInt();
        String title = jobject.get("title").getAsString();
        NetworkGUI gui = new NetworkGUI(id, title);

        JsonArray componentArray = jobject.get("components").getAsJsonArray();
        for (JsonElement component : componentArray) {
            JsonObject componentObject = component.getAsJsonObject();
            ComponentType componentType = ComponentType.valueOf(componentObject.get("type").getAsString());
            GUIComponent c;
            switch (componentType) {
                case LABEL -> c = EusGUI.GSON.fromJson(component, Label.class);
                case MINECRAFT_BUTTON -> c = EusGUI.GSON.fromJson(component, MinecraftButton.class);
                case BUTTON -> c = EusGUI.GSON.fromJson(component, Button.class);
                default -> throw new JsonParseException("Unknown component type: " + componentType);
            }
            gui.addComponent(c);
        }

        return gui;
    }

    public void initAll() {
        for (GUIComponent component : components) {
            component.init(this);
        }
    }

    public void addComponent(GUIComponent component) {
        components.add(component);
    }

    public boolean removeComponent(GUIComponent component) {
        return components.remove(component);
    }

    public void focusNext() {
        if (components != null && components.size() > 0) {
            if (focusIndex < components.size() - 1) {
                focusIndex++;
            } else {
                focusIndex = 0;
            }
        }
    }

    public GUIComponent getFocusedComponent() {
        if (components != null && components.size() > 0 && focusIndex >= 0 && focusIndex < components.size()) {
            return components.get(focusIndex);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public GUIComponent[] getComponents() {
        return components.toArray(new GUIComponent[0]);
    }

    public @Nullable GUIComponent getComponent(String name) {
        for (GUIComponent component : components) {
            if (component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
