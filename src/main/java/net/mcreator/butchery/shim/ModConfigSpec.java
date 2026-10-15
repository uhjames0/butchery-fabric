package net.mcreator.butchery.shim;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.LinkedHashMap;
import java.util.Map;
import net.fabricmc.loader.api.FabricLoader;

public class ModConfigSpec {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Map<String, ConfigValue<?>> VALUES = new LinkedHashMap();
    private static JsonObject stored = new JsonObject();
    private static volatile boolean loaded = false;

    public static void load() {
        Path p = ModConfigSpec.configPath();
        try {
            if (Files.exists(p, new LinkOption[0]) && (stored = (JsonObject)GSON.fromJson(Files.readString(p), JsonObject.class)) == null) {
                stored = new JsonObject();
            }
            boolean dirty = false;
            for (Map.Entry<String, ConfigValue<?>> e : VALUES.entrySet()) {
                if (stored.has(e.getKey())) continue;
                Object dv = e.getValue().defaultValue;
                if (dv instanceof Boolean) {
                    Boolean b = (Boolean)dv;
                    stored.addProperty(e.getKey(), b);
                } else if (dv instanceof Number) {
                    Number n = (Number)dv;
                    stored.addProperty(e.getKey(), n);
                } else if (dv instanceof String) {
                    String s = (String)dv;
                    stored.addProperty(e.getKey(), s);
                }
                dirty = true;
            }
            if (dirty) {
                ModConfigSpec.save();
            }
            loaded = true;
        }
        catch (IOException ex) {
            throw new RuntimeException("Failed to load butchery config", ex);
        }
    }

    private static void save() {
        try {
            Files.createDirectories(ModConfigSpec.configPath().getParent(), new FileAttribute[0]);
            Files.writeString(ModConfigSpec.configPath(), (CharSequence)GSON.toJson((JsonElement)stored), new OpenOption[0]);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    private static Path configPath() {
        return FabricLoader.getInstance().getConfigDir().resolve("butchery.json");
    }

    public static class ConfigValue<T> {
        private final String path;
        private final T defaultValue;

        private ConfigValue(String path, T defaultValue) {
            this.path = path;
            this.defaultValue = defaultValue;
        }

        public T get() {
            JsonElement v;
            if (!loaded) {
                ModConfigSpec.load();
            }
            if ((v = stored.get(this.path)) == null) {
                return this.defaultValue;
            }
            T t = this.defaultValue;
            if (t instanceof Boolean) {
                Boolean b = (Boolean)t;
                return (T)Boolean.valueOf(stored.get(this.path).getAsBoolean());
            }
            T t2 = this.defaultValue;
            if (t2 instanceof Number) {
                Number n = (Number)t2;
                t2 = this.defaultValue;
                if (t2 instanceof Double) {
                    Double d = (Double)t2;
                    return (T)Double.valueOf(stored.get(this.path).getAsDouble());
                }
            }
            if ((t = this.defaultValue) instanceof String) {
                String s = (String)t;
                return (T)stored.get(this.path).getAsString();
            }
            return this.defaultValue;
        }

        public void set(T value) {
            if (value instanceof Boolean) {
                Boolean b = (Boolean)value;
                stored.addProperty(this.path, b);
            } else if (value instanceof Number) {
                Number n = (Number)value;
                stored.addProperty(this.path, n);
            } else if (value instanceof String) {
                String st = (String)value;
                stored.addProperty(this.path, st);
            }
            ModConfigSpec.save();
        }
    }

    public static class Builder {
        public Builder comment(String ... lines) {
            return this;
        }

        public <T> ConfigValue<T> define(String path, T defaultValue) {
            ConfigValue<T> v = new ConfigValue<T>(path, defaultValue);
            VALUES.put(path, v);
            return v;
        }

        public ModConfigSpec build() {
            return new ModConfigSpec();
        }
    }
}

