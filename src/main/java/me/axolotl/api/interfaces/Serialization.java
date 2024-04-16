package me.axolotl.api.interfaces;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Map;

/**
 * The Serialization interface provides methods for serialization and deserialization of objects.
 *
 * @param <UnSerializationType> the type of object to be deserialized
 * @see java.io.Serializable
 * @since 2024-04-13
 */
public interface Serialization<UnSerializationType> extends Serializable {

    /**
     * Serializes the object into a map of key-value pairs.
     *
     * @return a map containing the serialized data
     */
    @NotNull
    Map<String, Object> serialization();

    /**
     * Deserializes the object from the provided map of key-value pairs.
     *
     * @param serializedData the map containing the serialized data
     * @return the deserialized object
     */
    @NotNull
    UnSerializationType unSerialization(Map<String, Object> serializedData);
}

