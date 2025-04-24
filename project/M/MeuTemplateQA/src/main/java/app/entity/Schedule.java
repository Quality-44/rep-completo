
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela SCHEDULE
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"SCHEDULE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Schedule")
@CronappTable(role=CronappTableRole.CLASS)
public class Schedule implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Title")
    @Column(name = "title", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String title;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @CronappColumn(attributeType="TIMESTAMP", label="Start")
    @Column(name = "start", nullable = true, unique = false, insertable=true, updatable=true, columnDefinition = "TIMESTAMP")
        
        private java.util.Date start;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @CronappColumn(attributeType="TIMESTAMP", label="End")
    @Column(name = "end", nullable = true, unique = false, insertable=true, updatable=true, columnDefinition = "TIMESTAMP")
        
        private java.util.Date end;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Start Timezone")
    @Column(name = "startTimezone", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String startTimezone;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="End Timezone")
    @Column(name = "endTimezone", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String endTimezone;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Description")
    @Column(name = "description", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String description;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Recurrence Id")
    @Column(name = "recurrenceId", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String recurrenceId;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Recurrence Rule")
    @Column(name = "recurrenceRule", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String recurrenceRule;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Recurrence Exception")
    @Column(name = "recurrenceException", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String recurrenceException;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Is All Day")
    @Column(name = "isAllDay", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean isAllDay;


    /**
    * Construtor
    * @generated
    */
    public Schedule(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Schedule setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém title
    * return title
    * @generated
    */
    public java.lang.String getTitle() {
        return this.title;
    }

    /**
    * Define title
    * @param title title
    * @generated
    */
    public Schedule setTitle(java.lang.String title) {
        this.title = title;
        return this;
    }
    /**
    * Obtém start
    * return start
    * @generated
    */
    public java.util.Date getStart() {
        return this.start;
    }

    /**
    * Define start
    * @param start start
    * @generated
    */
    public Schedule setStart(java.util.Date start) {
        this.start = start;
        return this;
    }
    /**
    * Obtém end
    * return end
    * @generated
    */
    public java.util.Date getEnd() {
        return this.end;
    }

    /**
    * Define end
    * @param end end
    * @generated
    */
    public Schedule setEnd(java.util.Date end) {
        this.end = end;
        return this;
    }
    /**
    * Obtém startTimezone
    * return startTimezone
    * @generated
    */
    public java.lang.String getStartTimezone() {
        return this.startTimezone;
    }

    /**
    * Define startTimezone
    * @param startTimezone startTimezone
    * @generated
    */
    public Schedule setStartTimezone(java.lang.String startTimezone) {
        this.startTimezone = startTimezone;
        return this;
    }
    /**
    * Obtém endTimezone
    * return endTimezone
    * @generated
    */
    public java.lang.String getEndTimezone() {
        return this.endTimezone;
    }

    /**
    * Define endTimezone
    * @param endTimezone endTimezone
    * @generated
    */
    public Schedule setEndTimezone(java.lang.String endTimezone) {
        this.endTimezone = endTimezone;
        return this;
    }
    /**
    * Obtém description
    * return description
    * @generated
    */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
    * Define description
    * @param description description
    * @generated
    */
    public Schedule setDescription(java.lang.String description) {
        this.description = description;
        return this;
    }
    /**
    * Obtém recurrenceId
    * return recurrenceId
    * @generated
    */
    public java.lang.String getRecurrenceId() {
        return this.recurrenceId;
    }

    /**
    * Define recurrenceId
    * @param recurrenceId recurrenceId
    * @generated
    */
    public Schedule setRecurrenceId(java.lang.String recurrenceId) {
        this.recurrenceId = recurrenceId;
        return this;
    }
    /**
    * Obtém recurrenceRule
    * return recurrenceRule
    * @generated
    */
    public java.lang.String getRecurrenceRule() {
        return this.recurrenceRule;
    }

    /**
    * Define recurrenceRule
    * @param recurrenceRule recurrenceRule
    * @generated
    */
    public Schedule setRecurrenceRule(java.lang.String recurrenceRule) {
        this.recurrenceRule = recurrenceRule;
        return this;
    }
    /**
    * Obtém recurrenceException
    * return recurrenceException
    * @generated
    */
    public java.lang.String getRecurrenceException() {
        return this.recurrenceException;
    }

    /**
    * Define recurrenceException
    * @param recurrenceException recurrenceException
    * @generated
    */
    public Schedule setRecurrenceException(java.lang.String recurrenceException) {
        this.recurrenceException = recurrenceException;
        return this;
    }
    /**
    * Obtém isAllDay
    * return isAllDay
    * @generated
    */
    public java.lang.Boolean getIsAllDay() {
        return this.isAllDay;
    }

    /**
    * Define isAllDay
    * @param isAllDay isAllDay
    * @generated
    */
    public Schedule setIsAllDay(java.lang.Boolean isAllDay) {
        this.isAllDay = isAllDay;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Schedule object = (Schedule)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
