package project.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public record Task(int id, String taskName, int difficult, int time, int cost) {

    public static final RowMapper ROW_MAPPER = new RowMapper();

    public Map<String, ?> asCreateParams() {
        return Map.of(
                "task_name", taskName,
                "difficult", difficult,
                "time", time,
                "cost", cost
        );
    }

    public static class RowMapper implements org.springframework.jdbc.core.RowMapper<Task> {

        @Override
        public Task mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Task(
                    resultSet.getInt("id"),
                    resultSet.getString("task_name"),
                    resultSet.getInt("difficult"),
                    resultSet.getInt("time"),
                    resultSet.getInt("cost")
            );
        }
    }
}
