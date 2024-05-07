package me.axolotl.api.minecraft;

/**
 * DependPlugin類別代表一個依賴的插件。
 *
 * @since 2024-04-18
 */
public class DependPlugin {

    private final String pluginID;
    private final transient boolean force;

    /**
     * 使用指定的插件ID和強制標誌構造一個新的DependPlugin。
     *
     * @param pluginID 依賴插件的ID
     * @param force    一個布林值，指示依賴是否被強制執行
     */
    public DependPlugin(String pluginID, boolean force) {
        this.pluginID = pluginID;
        this.force = force;
    }

    /**
     * 檢索依賴插件的ID。
     *
     * @return 依賴插件的ID
     */
    public String getPluginID() {
        return pluginID;
    }

    /**
     * 檢查依賴是否被強制執行。
     *
     * @return 如果依賴被強制執行則返回true，否則返回false
     */
    public boolean isForce() {
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
