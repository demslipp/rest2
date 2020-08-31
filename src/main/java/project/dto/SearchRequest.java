package project.dto;

import java.util.StringJoiner;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public record SearchRequest(String taskName, Integer difficult, Integer time, Integer cost) {

    public String toSql() {
        if (isNull(taskName) && isNull(difficult) && isNull(time) && isNull(cost)) {
            return "SELECT id, task_name, difficult, time, cost FROM public.task";
        }

        var select = "SELECT id, task_name, difficult, time, cost FROM public.task WHERE ";
        var joiner = new StringJoiner(" OR ", select, "");

        if (nonNull(taskName)) {
            joiner.add(format("task_name LIKE '?%s?'", taskName));
        }

        if (nonNull(difficult)) {
            joiner.add(format("difficult = %d", difficult));
        }

        if (nonNull(time)) {
            joiner.add(format("time = %d", time));
        }
        if (nonNull(cost)) {
            joiner.add(format("cost=%d", cost));
        }
        return joiner.toString();
    }
}
