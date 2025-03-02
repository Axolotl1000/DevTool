package me.axolotldev.api.interfaces;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Map;

/**
 * Serialization接口提供了對象的序列化和反序列化方法。
 *
 * @param <UnSerializationType> 要反序列化的對象的類型
 * @see java.io.Serializable
 * @since 2024-04-13
 */
public interface Serialization<UnSerializationType> extends Serializable {

    /**
     * 將對象序列化為鍵值對的映射。
     *
     * @return 包含序列化數據的映射
     */
    @NotNull
    Map<String, Object> serialization();

    /**
     * 從提供的鍵值對映射中反序列化對象。
     *
     * @param serializedData 包含序列化數據的映射
     * @return 反序列化後的對象
     */
    @NotNull
    UnSerializationType unSerialization(Map<String, Object> serializedData);
}
