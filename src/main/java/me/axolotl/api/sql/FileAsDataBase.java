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
 * The FileAsDataBase class provides functionality to interact with a SQLite database stored in a file.
 *
 * @since 2024-02-22
 */
public final class FileAsDataBase implements BaseDB {

    private final String pathS;
    private final File pathF;
    private final File parent;
    private SQLStatus status = SQLStatus.DISCONNECTED;
    private Connection connection;
    private Statement statement;

    /**
     * Constructs a new FileAsDataBase instance with the specified file path.
     *
     * @param path the file path of the SQLite database
     */
    public FileAsDataBase(String path) {
        this.pathS = path;
        this.pathF = new File(path);
        this.parent = pathF.getParentFile();

        if (!this.parent.exists()) {
            this.parent.mkdir();
        }
    }

    /**
     * Gets the current status of the SQL connection.
     *
     * @return the current SQL status
     */
    public SQLStatus getStatus() {
        return status;
    }

    /**
     * Connects to the SQLite database.
     *
     * @throws RuntimeException if unable to connect to the database
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
     * Disconnects from the SQLite database.
     *
     * @throws RuntimeException if unable to disconnect from the database
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
     * Creates a new table in the database with the specified table ID and data schema.
     *
     * @param tableId the ID of the table to be created
     * @param data    the data schema for the table
     * @throws RuntimeException if an error occurs during the table creation process
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
     * Removes an existing table from the database with the specified table ID.
     *
     * @param tableId the ID of the table to be removed
     * @throws RuntimeException if an error occurs during the table removal process
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
     * Retrieves values from a specified table in the database.
     *
     * @param tableId the ID of the table
     * @param filter  the filter condition for the query
     * @return a ResultSet containing the queried values
     * @throws RuntimeException if an error occurs during the query
     */
    public synchronized ResultSet getTableValues(String tableId, String filter) {
        isConnected();
        setStatus(2);
        final String cmd = "SELECT * FROM %s";
        final String filterCmd = "WHERE %s";
        final String finalCmd = String.format(cmd, tableId) + (filter.isBlank() ? "" : String.format(filterCmd, filter)) + ";";

        try (ResultSet rs = statement.executeQuery(finalCmd);) {
            setStatus(1);
            return rs;
        } catch (SQLException e) {
            setStatus(5);
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes values to a specified table in the database.
     *
     * @param tableId the ID of the table
     * @param value   a Map containing the column names and corresponding values to be inserted
     * @throws RuntimeException if an error occurs during the write operation
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
     * Deletes records from the specified table based on the provided filter.
     *
     * @param tableId the ID of the table from which to delete records
     * @param filter  the filter condition for deleting records (can be empty)
     * @throws RuntimeException if an error occurs during the deletion process
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
     * Executes a SQL command and returns the resulting ResultSet.
     *
     * @param command the SQL command to be executed
     * @return the ResultSet generated by the execution of the SQL command
     * @throws SQLException if a database access error occurs or the SQL command fails to execute
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
     * Executes a non-query SQL command on the database.
     *
     * @param command the SQL command to be executed
     * @throws SQLException if a database access error occurs or the SQL command fails to execute
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

