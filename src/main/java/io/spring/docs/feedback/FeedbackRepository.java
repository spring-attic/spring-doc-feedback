package io.spring.docs.feedback;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path="feedback")
public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Long> {
	List<Feedback> findByStarNumber(@Param("starNumber") short starNumber);
	List<Feedback> findByProjectName(@Param("projectName") String projectName);
}
