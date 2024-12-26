package me.axolotl.api.minecraft;

/**
 * DependPlugin類別代表一個依賴的插件。
 *
 * @since 2024-04-18
 */
public record DependPlugin(String pluginID, boolean force) {

    /**
     * 使用指定的插件ID和強制標誌構造一個新的DependPlugin。
     *
     * @param pluginID 依賴插件的ID
     * @param force    一個布林值，指示依賴是否被強制執行
     */
    public DependPlugin {
    }

    /**
     * 檢索依賴插件的ID。
     *
     * @return 依賴插件的ID
     */
    @Override
    public String pluginID() {
        return pluginID;
    }

    /**
     * 檢查依賴是否被強制執行。
     *
     * @return 如果依賴被強制執行則返回true，否則返回false
     */
    @Override
    public boolean force() {
        return force;
    }

    /**
     * 返回DependPlugin的字符串表示形式。
     *
     * @return DependPlugin的字符串表示形式
     */
    @Override
    public String toString() {
        return "DependPlugin{" +
                "pluginID='" + pluginID + '\'' +
                ", force=" + force +
                '}';
    }
}
