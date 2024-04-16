package me.axolotl.api.tool.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * JsonBuilder is a utility class for constructing JSON objects and arrays.
 * It provides methods to create and manipulate JSON structures in a fluent manner.
 *
 * @since 2024-02-08
 */
public final class JsonBuilder {

    private final JsonObject object = new JsonObject();

    /**
     * Retrieves the final JsonObject constructed.
     *
     * @return The final JsonObject constructed.
     */
    public JsonObject finalObject() {
        return this.object;
    }

    /**
     * Retrieves a SubObject associated with the specified key.
     * If the key doesn't exist, a new empty JsonObject is added.
     *
     * @param key The key associated with the SubObject.
     * @return The SubObject associated with the key.
     */
    public SubObject getSubAsObject(String key) {
        if (this.object.get(key) == null) {
            this.object.add(key, new JsonObject());
        }
        return new SubObject(object.get(key).getAsJsonObject());
    }

    /**
     * Retrieves a SubArray associated with the specified key.
     * If the key doesn't exist, a new empty JsonArray is added.
     *
     * @param key The key associated with the SubArray.
     * @return The SubArray associated with the key.
     */
    public SubArray getSubAsArray(String key) {
        if (this.object.get(key) == null) {
            this.object.add(key, new JsonArray());
        }
        return new SubArray(object.get(key).getAsJsonArray());
    }

    /**
     * Sets a key-value pair of type String within this Object.
     *
     * @param key   The key for the value.
     * @param value The String value to be set.
     * @return This SubObject for method chaining.
     */
    public JsonBuilder setKV(String key, String value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * Sets a key-value pair of type Number within this Object.
     *
     * @param key   The key for the value.
     * @param value The Number value to be set.
     * @return This SubObject for method chaining.
     */
    public JsonBuilder setKV(String key, Number value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * Sets a key-value pair of type Character within this Object.
     *
     * @param key   The key for the value.
     * @param value The Character value to be set.
     * @return This SubObject for method chaining.
     */
    public JsonBuilder setKV(String key, Character value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * Sets a key-value pair of type Boolean within this Object.
     *
     * @param key   The key for the value.
     * @param value The Boolean value to be set.
     * @return This SubObject for method chaining.
     */
    public JsonBuilder setKV(String key, Boolean value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * Represents a nested JSON object within JsonBuilder.
     */
    public final class SubObject {

        private JsonObject object;

        private SubObject() {
        }

        /**
         * Constructs a SubObject with the provided JsonObject.
         *
         * @param object The JsonObject to wrap.
         */
        private SubObject(JsonObject object) {
            this.object = object;
        }

        /**
         * Retrieves a SubObject associated with the specified key within this SubObject.
         * If the key doesn't exist, a new empty JsonObject is added.
         *
         * @param key The key associated with the SubObject.
         * @return The SubObject associated with the key.
         */
        public SubObject getSubAsObject(String key) {
            if (this.object.get(key) == null) {
                this.object.add(key, new JsonObject());
            }
            return new SubObject(this.object.get(key).getAsJsonObject());
        }

        /**
         * Retrieves a SubArray associated with the specified key within this SubObject.
         * If the key doesn't exist, a new empty JsonArray is added.
         *
         * @param key The key associated with the SubArray.
         * @return The SubArray associated with the key.
         */
        public SubArray getSubAsArray(String key) {
            if (this.object.get(key) == null) {
                this.object.add(key, new JsonArray());
            }
            return new SubArray(this.object.get(key).getAsJsonArray());
        }

        /**
         * Sets a key-value pair of type String within this SubObject.
         *
         * @param key   The key for the value.
         * @param value The String value to be set.
         * @return This SubObject for method chaining.
         */
        public SubObject setKV(String key, String value) {
            object.addProperty(key, value);
            return this;
        }

        /**
         * Sets a key-value pair of type Number within this SubObject.
         *
         * @param key   The key for the value.
         * @param value The Number value to be set.
         * @return This SubObject for method chaining.
         */
        public SubObject setKV(String key, Number value) {
            object.addProperty(key, value);
            return this;
        }

        /**
         * Sets a key-value pair of type Character within this SubObject.
         *
         * @param key   The key for the value.
         * @param value The Character value to be set.
         * @return This SubObject for method chaining.
         */
        public SubObject setKV(String key, Character value) {
            object.addProperty(key, value);
            return this;
        }

        /**
         * Sets a key-value pair of type Boolean within this SubObject.
         *
         * @param key   The key for the value.
         * @param value The Boolean value to be set.
         * @return This SubObject for method chaining.
         */
        public SubObject setKV(String key, Boolean value) {
            object.addProperty(key, value);
            return this;
        }

    }

    /**
     * Represents a nested JSON array within JsonBuilder.
     */
    public final class SubArray {
        private JsonArray array;

        private SubArray() {
        }

        /**
         * Constructs a SubArray with the provided JsonArray.
         *
         * @param array The JsonArray to wrap.
         */
        private SubArray(JsonArray array) {
            this.array = array;
        }

        /**
         * Retrieves a SubObject at the specified index within this SubArray.
         * If the index is out of bounds or the element at the index is not an object,
         * throws ArrayIndexOutOfBoundsException.
         *
         * @param i The index of the SubObject to retrieve.
         * @return The SubObject at the specified index.
         * @throws ArrayIndexOutOfBoundsException If the index is out of bounds.
         */
        public SubObject getSubAsObject(Integer i) throws ArrayIndexOutOfBoundsException {
            if (this.array.get(i) == null) {
                if (this.array.size() + 1 >= i) {
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    return new SubObject(this.array.get(i).getAsJsonObject());
                }
            }
            return null;
        }

        /**
         * Retrieves a SubArray at the specified index within this SubArray.
         * If the index is out of bounds or the element at the index is not an array,
         * throws ArrayIndexOutOfBoundsException.
         *
         * @param i The index of the SubArray to retrieve.
         * @return The SubArray at the specified index.
         * @throws ArrayIndexOutOfBoundsException If the index is out of bounds.
         */
        public SubArray getSubAsArray(Integer i) throws ArrayIndexOutOfBoundsException {
            if (this.array.get(i) == null) {
                if (this.array.size() + 1 >= i) {
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    return new SubArray(this.array.get(i).getAsJsonArray());
                }
            }
            return null;
        }

        /**
         * Appends a String value to this SubArray.
         *
         * @param value The String value to append.
         * @return This SubArray for method chaining.
         */
        public SubArray put(String value) {
            array.add(value);
            return this;
        }

        /**
         * Appends a Character value to this SubArray.
         *
         * @param value The Character value to append.
         * @return This SubArray for method chaining.
         */
        public SubArray put(Character value) {
            array.add(value);
            return this;
        }

        /**
         * Appends a Number value to this SubArray.
         *
         * @param value The Number value to append.
         * @return This SubArray for method chaining.
         */
        public SubArray put(Number value) {
            array.add(value);
            return this;
        }

        /**
         * Appends a Boolean value to this SubArray.
         *
         * @param value The Boolean value to append.
         * @return This SubArray for method chaining.
         */
        public SubArray put(Boolean value) {
            array.add(value);
            return this;
        }

    }

}
