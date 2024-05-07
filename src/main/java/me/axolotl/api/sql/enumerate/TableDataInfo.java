package me.axolotl.api.sql.enumerate;

import me.axolotl.api.exception.MethodNotAllowed;
import org.jetbrains.annotations.NotNull;

/**
 * TableDataInfo枚舉表示數據庫表列的額外信息。
 *
 * @since 2024-02-24
 */
public enum TableDataInfo {

    /**
     * 表示列的默認值。
     */
    DEFAULT,

    /**
     * 表示列的長度。
     */
    LENGTH,

    /**
     * 表示列是否可為空。
     */
    NULLABLE,

    /**
     * 表示列是否使用0填滿空缺。
     */
    ZEROFILL,

    /**
     * 表示列是否為無符號。
     */
    UNSIGNED,

    /**
     * 表示與列關聯的注釋。
     */
    COMMENT;

    /* ========== ========== ========== ========== ========== */

    // ENUM DEFAULT的方法

    @NotNull
    private String defValue = "";

    /**
     * 設置列的默認值。
     *
     * @param s 要設置的默認值
     * @return 具有更新的默認值的TableDataInfo對象
     * @throws MethodNotAllowed 如果對除DEFAULT以外的枚舉調用了該方法
     */
    public TableDataInfo setDefaultValue(@NotNull String s) {
        if (this != DEFAULT) throw new MethodNotAllowed("Only DEFAULT can use this method.");
        this.defValue = s;

        return this;
    }

    /**
     * 獲取列的默認值。
     *
     * @return 列的默認值
     * @throws MethodNotAllowed 如果對除DEFAULT以外的枚舉調用了該方法
     */
    public String getDefaultValue() {
        if (this != DEFAULT) throw new MethodNotAllowed("Only DEFAULT can use this method.");
        return defValue;
    }

    // ENUM LENGTH的方法

    private int length = 0;

    /**
     * 設置列的長度。
     *
     * @param length 要設置的長度
     * @return 具有更新的長度的TableDataInfo對象
     * @throws MethodNotAllowed 如果對除LENGTH以外的枚舉調用了該方法
     */
    public TableDataInfo setLength(int length) {
        if (this != LENGTH) throw new MethodNotAllowed("Only LENGTH can use this method.");
        this.length = length;

        return this;
    }

    /**
     * 獲取列的長度。
     *
     * @return 列的長度
     * @throws MethodNotAllowed 如果對除LENGTH以外的枚舉調用了該方法
     */
    public int getLength() {
        if (this != LENGTH) throw new MethodNotAllowed("Only LENGTH can use this method.");
        return this.length;
    }

    // ENUM COMMENT的方法

    private String comment = "";

    /**
     * 設置列的注釋。
     *
     * @param comment 要設置的注釋
     * @return 具有更新的注釋的TableDataInfo對象
     * @throws MethodNotAllowed 如果對除COMMENT以外的枚舉調用了該方法
     */
    public TableDataInfo setComment(String comment) {
        if (this != COMMENT) throw new MethodNotAllowed("Only COMMENT can use this method.");
        this.comment = comment;

        return this;
    }

    /**
     * 獲取列的注釋。
     *
     * @return 列的注釋
     * @throws MethodNotAllowed 如果對除COMMENT以外的枚舉調用了該方法
     */
    public String getComment() {
        if (this != COMMENT) throw new MethodNotAllowed("Only COMMENT can use this method.");
        return comment;
    }

    /* ========== ========== ========== ========== ========== */

    /**
     * 返回TableDataInfo對象的字符串表示形式。
     *
     * @return 對象的字符串表示形式
     */
    @Override
    public String toString() {
        switch (this) {
            case DEFAULT:
                return String.format("DEFAULT %s", getDefaultValue());
            case LENGTH:
                return String.format("(%s)", getLength());
            case NULLABLE:
                return "NULL";
            case COMMENT:
                return String.format("COMMENT '%s'", getComment());
            default:
                return this.name();
        }
    }

}
