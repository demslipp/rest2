package project.dto;

import java.util.StringJoiner;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public record SearchEmployee(String lastname, String firstname, String grade) {

    public String toSql() {
        if (isNull(lastname) && isNull(firstname) && isNull(grade)) {
            return "SELECT id, lastname, firstname, grade FROM public.employee";
        }

        var select = "SELECT id, lastname, firstname, grade FROM public.employee WHERE ";
        var joiner = new StringJoiner(" OR ", select, "");

        if (nonNull(lastname)) {
            joiner.add(format("lastname LIKE '?%s?'", lastname));
        }

        if (nonNull(grade)) {
            joiner.add(format("grade = '%s'::public.grade", grade));
        }
        return joiner.toString();
    }
}
