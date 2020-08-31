package project.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public record Employee(int id, String lastname, String firstname, Grade grade) {

    public static final RowMapper ROW_MAPPER = new RowMapper();

    public Map<String, ?> asCreateParams() {
        return Map.of(
                "lastname", lastname,
                "firstname", firstname,
                "grade", grade.toString()
        );
    }

    public static class RowMapper implements org.springframework.jdbc.core.RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("lastname"),
                    resultSet.getString("firstname"),
                    Grade.valueOf(resultSet.getString("grade"))
            );
        }
    }

}
