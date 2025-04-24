
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
* Classe que representa a tabela EVENT
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"EVENT\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Event")
@CronappTable(role=CronappTableRole.CLASS)
public class Event implements Serializable {
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
    @CronappColumn(attributeType="STRING", label="Event")
    @Column(name = "event", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String event;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @CronappColumn(attributeType="DATETIME", label="Date")
    @Column(name = "date", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date date;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Details")
    @Column(name = "details", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String details;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Icon")
    @Column(name = "icon", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String icon;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Position")
    @Column(name = "position", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String position;


    /**
    * Construtor
    * @generated
    */
    public Event(){
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
    public Event setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém event
    * return event
    * @generated
    */
    public java.lang.String getEvent() {
        return this.event;
    }

    /**
    * Define event
    * @param event event
    * @generated
    */
    public Event setEvent(java.lang.String event) {
        this.event = event;
        return this;
    }
    /**
    * Obtém date
    * return date
    * @generated
    */
    public java.util.Date getDate() {
        return this.date;
    }

    /**
    * Define date
    * @param date date
    * @generated
    */
    public Event setDate(java.util.Date date) {
        this.date = date;
        return this;
    }
    /**
    * Obtém details
    * return details
    * @generated
    */
    public java.lang.String getDetails() {
        return this.details;
    }

    /**
    * Define details
    * @param details details
    * @generated
    */
    public Event setDetails(java.lang.String details) {
        this.details = details;
        return this;
    }
    /**
    * Obtém icon
    * return icon
    * @generated
    */
    public java.lang.String getIcon() {
        return this.icon;
    }

    /**
    * Define icon
    * @param icon icon
    * @generated
    */
    public Event setIcon(java.lang.String icon) {
        this.icon = icon;
        return this;
    }
    /**
    * Obtém position
    * return position
    * @generated
    */
    public java.lang.String getPosition() {
        return this.position;
    }

    /**
    * Define position
    * @param position position
    * @generated
    */
    public Event setPosition(java.lang.String position) {
        this.position = position;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Event object = (Event)obj;
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
