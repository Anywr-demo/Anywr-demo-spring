package AnywrDemo.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;


    @CreatedDate
    @Column(name ="creationDate", nullable = false,updatable = false)
    private Instant creationDate;

    @LastModifiedDate
    @Column(name ="lastModifiedDate")
    private Instant lastModifiedDate;


}

