package me.axolotl.api.sql;

import me.axolotl.api.sql.enumerate.SQLStatus;
import me.axolotl.api.sql.excetption.NonInConnectedException;
import me.axolotl.api.sql.interfaces.BaseDB;
import me.axolotl.api.sql.util.TableUnit;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.axolotl.api.sql.enumerate.SQLStatus.CONNECTED;
import static me.axolotl.api.sql.enumerate.SQLStatus.PROCESSING;

/**
 * FileAsDataBase類提供了與存儲在文件中的SQLite數據庫交互的功能。
 *
 * @since 2024-02-22
 */
@SuppressWarnings("unused")
public final class FileAsDataBase implements BaseDB {

    private final String pathS;
    private final File pathF;
    private SQLStatus status = SQLStatus.DISCONNECTED;
    private Connection connection;
    private Statement statement;

    /**
     * 使用指定的文件路徑構造一個新的FileAsDataBase實例。
     *
     * @param path SQLite數據庫的文件路徑
     */
    public FileAsDataBase(String path) {
        this.pathS = path;
        this.pathF = new File(path);
        File parent = pathF.getParentFile();

        if (!parent.exists()) {
            if (!parent.mkdir()) {
                throw new RuntimeException("Cannot create parent directory.");
            }
        }
    }

    /**
     * 獲取當前SQL連接的狀態。
     *
     * @return 當前SQL狀態
     */
    public SQLStatus getStatus() {
        return status;
    }

    /**
     * 連接到SQLite數據庫。
     *
     * @throws RuntimeException 如果無法連接到數據庫
     */
    public synchronized void connect() {
        setStatus(0);
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(SQLiteLink + pathS);
            this.statement = this.connection.createStatement();
            setStatus(1);
        } catch (Exception e) {
            setStatus(5);
            throw new RuntimeException(String.format("Cannot Connect to Database \"%s\"", pathS), e);
        }
    }

    /**
     * 斷開與SQLite數據庫的連接。
     *
     * @throws RuntimeException 如果無法從數據庫斷開連接
     */
    public synchronized void disconnect() {
        setStatus(3);
        try {
            if (this.status == CONNECTED) {
                connection.close();
                setStatus(4);
            } else if (this.status == SQLStatus.PROCESSING) {
                setStatus(5);
                throw new RuntimeException("Please wait until process done.");
            }
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(String.format("Cannot Disconnect from Database \"%s\"", pathS), e);
        }
    }

    /**
     * 在數據庫中創建一個具有指定表ID和數據模式的新表。
     *
     * @param tableId 要創建的表的ID
     * @param data    表的數據模式
     * @throws RuntimeException 在表創建過程中發生錯誤時
     */
    public synchronized void createTable(String tableId, TableUnit... data) {
        isConnected();
        setStatus(2);
        final String cmd = "CREATE TABLE %s ( %s );";
        final ArrayList<String> info = new ArrayList<>();
        for (TableUnit tu : data) {
            info.add(tu.toString());
        }
        try {
            statement.execute(String.format(cmd, tableId, String.join(", ", info)));
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(e);
        }
        setStatus(1);
    }

    /**
     * 從數據庫中刪除具有指定表ID的現有表。
     *
     * @param tableId 要刪除的表的ID
     * @throws RuntimeException 在表刪除過程中發生錯誤時
     */
    public synchronized void removeTable(String tableId) {
        isConnected();
        setStatus(2);
        final String cmd = "DROP TABLE %s;";
        try {
            statement.execute(String.format(cmd, tableId));
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(e);
        }
        setStatus(1);
    }

    /**
     * 從數據庫中檢索指定表中的值。
     *
     * @param tableId 表的ID
     * @param filter  查詢的過濾條件
     * @return 包含查詢值的ResultSet
     * @throws RuntimeException 在查詢過程中發生錯誤時
     */
    public synchronized ResultSet getTableValues(String tableId, String filter) {
        isConnected();
        setStatus(2);
        final String cmd = "SELECT * FROM %s";
        final String filterCmd = "WHERE %s";
        final String finalCmd = String.format(cmd, tableId) + (filter.isBlank() ? "" : String.format(filterCmd, filter)) + ";";

        try (ResultSet rs = statement.executeQuery(finalCmd)) {
            setStatus(1);
            return rs;
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(e);
        }
    }

    /**
     * 將值寫入數據庫中指定的表。
     *
     * @param tableId 表的ID
     * @param value   包含列名和相應值的Map以進行插入
     * @throws RuntimeException 在寫操作過程中發生錯誤時
     */
    public synchronized void writeToTable(String tableId, Map<String, Object> value) {
        isConnected();
        setStatus(2);
        final String cmd = "INSERT INTO %s (%s) VALUES (%s);";
        StringBuilder ksb = new StringBuilder();
        StringBuilder vsb = new StringBuilder();
        value.forEach((k, v) -> {
            ksb.append(", ").append(k);
            vsb.append(", ").append(v);
        });
        try {
            setStatus(1);
            statement.execute(String.format(cmd, tableId, ksb.substring(2), vsb.substring(2)));
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(e);
        }
    }

    /**
     * 基於提供的過濾器從指定表中刪除記錄。
     *
     * @param tableId 表的ID，從中刪除記錄
     * @param filter  刪除記錄的過濾條件（可以為空）
     * @throws RuntimeException 在刪除過程中發生錯誤時
     */
    public synchronized void deleteFromTable(String tableId, String filter) {
        isConnected();
        setStatus(2);
        final String cmd = "DELETE FROM %s";
        final String filterCmd = "WHERE ( %s )";
        final String finalCmd = String.format(cmd, tableId) + (filter.isBlank() ? "" : String.format(filterCmd, filter)) + ";";

        try {
            setStatus(1);
            statement.execute(finalCmd);
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(e);
        }
    }

    /**
     * 執行SQL命令並返回生成的ResultSet。
     *
     * @param command 要執行的SQL命令
     * @return 通過SQL命令執行生成的ResultSet
     * @throws SQLException 如果發生數據庫訪問錯誤或SQL命令無法執行
     */
    public synchronized ResultSet runSearch(String command) throws SQLException {
        isConnected();
        setStatus(2);
        try {
            ResultSet rs = statement.executeQuery(command);
            setStatus(1);
            return rs;
        } catch (SQLException ex) {
            setStatus(5);
            throw ex;
        }
    }

    /**
     * 在數據庫上執行一個非查詢的SQL命令。
     *
     * @param command 要執行的SQL命令
     * @throws SQLException 如果發生數據庫訪問錯誤或SQL命令無法執行
     */
    public synchronized void runNormal(String command) throws SQLException {
        isConnected();
        setStatus(2);
        try {
            setStatus(1);
            statement.execute(command);
        } catch (SQLException ex) {
            setStatus(5);
            throw ex;
        }
    }

    private void isConnected() {
        if (!List.of(CONNECTED, PROCESSING).contains(this.status)) {
            setStatus(5);
            throw new RuntimeException("Did not connect to database", new NonInConnectedException());
        }
    }

    private void setStatus(int statusCode) {
        this.status = SQLStatus.getByLevel(statusCode);
    }

    @Override
    public String toString() {
        return "FileAsDataBase(" +
                "path:" +
                pathF.toString() +
                ")";
    }
}
