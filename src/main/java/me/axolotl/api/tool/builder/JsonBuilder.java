package me.axolotl.api.tool.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * JsonBuilder是一個用於構建JSON對象和數組的實用工具類。
 * 它提供了在流暢方式中創建和操作JSON結構的方法。
 *
 * @since 2024-02-08
 */
public final class JsonBuilder {

    private final JsonObject object = new JsonObject();

    /**
     * 檢索構建的最終JsonObject。
     *
     * @return 構建的最終JsonObject。
     */
    public JsonObject finalObject() {
        return this.object;
    }

    /**
     * 檢索與指定鍵關聯的SubObject。
     * 如果鍵不存在，則添加一個新的空JsonObject。
     *
     * @param key 與SubObject關聯的鍵。
     * @return 與鍵關聯的SubObject。
     */
    public SubObject getSubAsObject(String key) {
        if (this.object.get(key) == null) {
            this.object.add(key, new JsonObject());
        }
        return new SubObject(object.get(key).getAsJsonObject());
    }

    /**
     * 檢索與指定鍵關聯的SubArray。
     * 如果鍵不存在，則添加一個新的空JsonArray。
     *
     * @param key 與SubArray關聯的鍵。
     * @return 與鍵關聯的SubArray。
     */
    public SubArray getSubAsArray(String key) {
        if (this.object.get(key) == null) {
            this.object.add(key, new JsonArray());
        }
        return new SubArray(object.get(key).getAsJsonArray());
    }

    /**
     * 在此對象中設置一個String類型的鍵值對。
     *
     * @param key   值的鍵。
     * @param value 要設置的String值。
     * @return 用於方法鏈接的這個SubObject。
     */
    public JsonBuilder setKV(String key, String value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * 在此對象中設置一個Number類型的鍵值對。
     *
     * @param key   值的鍵。
     * @param value 要設置的Number值。
     * @return 用於方法鏈接的這個SubObject。
     */
    public JsonBuilder setKV(String key, Number value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * 在此對象中設置一個Character類型的鍵值對。
     *
     * @param key   值的鍵。
     * @param value 要設置的Character值。
     * @return 用於方法鏈接的這個SubObject。
     */
    public JsonBuilder setKV(String key, Character value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * 在此對象中設置一個Boolean類型的鍵值對。
     *
     * @param key   值的鍵。
     * @param value 要設置的Boolean值。
     * @return 用於方法鏈接的這個SubObject。
     */
    public JsonBuilder setKV(String key, Boolean value) {
        object.addProperty(key, value);
        return this;
    }

    /**
     * 表示JsonBuilder內部的嵌套JSON對象。
     */
    public final class SubObject {

        private JsonObject object;

        private SubObject() {
        }

        /**
         * 使用提供的JsonObject構造SubObject。
         *
         * @param object 要包裝的JsonObject。
         */
        private SubObject(JsonObject object) {
            this.object = object;
        }

        /**
         * 檢索此SubObject內與指定鍵關聯的SubObject。
         * 如果鍵不存在，則添加一個新的空JsonObject。
         *
         * @param key 與SubObject關聯的鍵。
         * @return 與鍵關聯的SubObject。
         */
        public SubObject getSubAsObject(String key) {
            if (this.object.get(key) == null) {
                this.object.add(key, new JsonObject());
            }
            return new SubObject(this.object.get(key).getAsJsonObject());
        }

        /**
         * 檢索此SubObject內與指定鍵關聯的SubArray。
         * 如果鍵不存在，則添加一個新的空JsonArray。
         *
         * @param key 與SubArray關聯的鍵。
         * @return 與鍵關聯的SubArray。
         */
        public SubArray getSubAsArray(String key) {
            if (this.object.get(key) == null) {
                this.object.add(key, new JsonArray());
            }
            return new SubArray(this.object.get(key).getAsJsonArray());
        }

        /**
         * 在此SubObject中設置一個String類型的鍵值對。
         *
         * @param key   值的鍵。
         * @param value 要設置的String值。
         * @return 用於方法鏈接的這個SubObject。
         */
        public SubObject setKV(String key, String value) {
            object.addProperty(key, value);
            return this;
        }

        /**
         * 在此SubObject中設置一個Number類型的鍵值對。
         *
         * @param key   值的鍵。
         * @param value 要設置的Number值。
         * @return 用於方法鏈接的這個SubObject。
         */
        public SubObject setKV(String key, Number value) {
            object.addProperty(key, value);
            return this;
        }

        /**
         * 在此SubObject中設置一個Character類型的鍵值對。
         *
         * @param key   值的鍵。
         * @param value 要設置的Character值。
         * @return 用於方法鏈接的這個SubObject。
         */
        public SubObject setKV(String key, Character value) {
            object.addProperty(key, value);
            return this;
        }

        /**
         * 在此SubObject中設置一個Boolean類型的鍵值對。
         *
         * @param key   值的鍵。
         * @param value 要設置的Boolean值。
         * @return 用於方法鏈接的這個SubObject。
         */
        public SubObject setKV(String key, Boolean value) {
            object.addProperty(key, value);
            return this;
        }

    }

    /**
     * 表示JsonBuilder內部的嵌套JSON數組。
     */
    public final class SubArray {
        private JsonArray array;

        private SubArray() {
        }

        /**
         * 使用提供的JsonArray構造SubArray。
         *
         * @param array 要包裝的JsonArray。
         */
        private SubArray(JsonArray array) {
            this.array = array;
        }

        /**
         * 檢索此SubArray中指定索引處的SubObject。
         * 如果索引超出範圍或索引處的元素不是對象，則拋出ArrayIndexOutOfBoundsException。
         *
         * @param i 要檢索的SubObject的索引。
         * @return 指定索引處的SubObject。
         * @throws ArrayIndexOutOfBoundsException 如果索引超出範圍。
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
         * 檢索此SubArray中指定索引處的SubArray。
         * 如果索引超出範圍或索引處的元素不是數組，則拋出ArrayIndexOutOfBoundsException。
         *
         * @param i 要檢索的SubArray的索引。
         * @return 指定索引處的SubArray。
         * @throws ArrayIndexOutOfBoundsException 如果索引超出範圍。
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
         * 將一個String值添加到此SubArray。
         *
         * @param value 要添加的String值。
         * @return 用於方法鏈接的這個SubArray。
         */
        public SubArray put(String value) {
            array.add(value);
            return this;
        }

        /**
         * 將一個Character值添加到此SubArray。
         *
         * @param value 要添加的Character值。
         * @return 用於方法鏈接的這個SubArray。
         */
        public SubArray put(Character value) {
            array.add(value);
            return this;
        }

        /**
         * 將一個Number值添加到此SubArray。
         *
         * @param value 要添加的Number值。
         * @return 用於方法鏈接的這個SubArray。
         */
        public SubArray put(Number value) {
            array.add(value);
            return this;
        }

        /**
         * 將一個Boolean值添加到此SubArray。
         *
         * @param value 要添加的Boolean值。
         * @return 用於方法鏈接的這個SubArray。
         */
        public SubArray put(Boolean value) {
            array.add(value);
            return this;
        }

    }

}
