package me.axolotldev.api.sql.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BaseDB接口定義了連接到數據庫和斷開與數據庫的基本操作。
 *
 * @since 2024-02-22
 */
public interface BaseDB {

    /**
     * 默認的JDBC鏈接。
     */
    String defaultLink = "jdbc:";

    /**
     * SQLite數據庫的JDBC鏈接。
     */
    String SQLiteLink = "jdbc:sqlite:";

    /**
     * 建立與數據庫的連接。
     *
     * @throws SQLException 如果發生數據庫訪問錯誤
     */
    void connect() throws SQLException;

    /**
     * 關閉與數據庫的連接。
     *
     * @throws SQLException 如果發生數據庫訪問錯誤
     */
    void disconnect() throws SQLException;

    /**
     * 在數據庫上執行非查詢SQL命令。
     *
     * @param command 要執行的SQL命令
     * @throws SQLException 如果發生數據庫訪問錯誤或SQL命令執行失敗
     */
    void runNormal(String command) throws SQLException;

    /**
     * 在數據庫上執行SQL查詢命令並返回生成的ResultSet。
     *
     * @param command 要執行的SQL命令
     * @return SQL命令執行生成的ResultSet
     * @throws SQLException 如果發生數據庫訪問錯誤或SQL命令執行失敗
     */
    ResultSet runSearch(String command) throws SQLException;

}
