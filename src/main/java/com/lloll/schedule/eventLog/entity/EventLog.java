package com.lloll.schedule.eventLog.entity;

import com.lloll.schedule.schedule.entity.Schedule;
import com.lloll.schedule.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String eventType; //'CREATE', 'UPDATE', 'DELETE'

    @NotNull
    @Column(name = "eventData", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> eventData;

    private boolean isRead;
    private Date createdAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule scheduleId;
}
