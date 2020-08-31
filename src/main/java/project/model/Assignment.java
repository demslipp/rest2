package project.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public record Assignment(int id, int taskId, int employeeId) {

    public Assignment(int taskId, int employeeId) {
        this(-1, taskId, employeeId);
    }

    public static final RowMapper ROW_MAPPER = new RowMapper();

    public Map<String, ?> asCreateParams() {
        return Map.of(
                "task_id", taskId,
                "employee_id", employeeId
        );
    }

    public static class RowMapper implements org.springframework.jdbc.core.RowMapper<Assignment> {
        @Override
        public Assignment mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Assignment(
                    resultSet.getInt("id"),
                    resultSet.getInt("task_id"),
                    resultSet.getInt("employee_id")
            );
        }
    }
}
