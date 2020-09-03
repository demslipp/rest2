package project.repository.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import project.domain.Task;
import project.dto.FindTasksDTO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;

public class TaskSpec {
//
//    public static Specification<Task> taskFilter(FindTasksDTO findTasksDTO){
//        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> {
//            FindTasksDTO.Criteria criteria = findTasksDTO.getCriteria();
//
//            if (!CollectionUtils.isEmpty(criteria.getIds())) {
//                CriteriaBuilder.In<BigInteger> inClause = criteriaBuilder.in(root.get("id"));
//                criteriaQuery.select(root)
//                        .where(root.get("id").in(criteria.getIds()));
//            }
//            return null;
//        }
//
//    }
//
//
//    private CriteriaQuery<Task> generateQuery(FindTasksDTO findTasksDTO){
//
//    }
}
