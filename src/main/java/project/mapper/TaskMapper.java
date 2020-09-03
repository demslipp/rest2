package project.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import project.domain.Task;
import project.dto.TaskDTO;

import java.util.List;

@Mapper
public interface TaskMapper {

    Task dtoToTask(TaskDTO origin);

    TaskDTO taskToDto(Task origin);

    List<TaskDTO> dtoToTask(List<Task> origin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(TaskDTO dto, @MappingTarget Task entity);

}
