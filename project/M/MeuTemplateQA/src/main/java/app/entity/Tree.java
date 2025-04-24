
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
* Classe que representa a tabela TREE
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"TREE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Tree")
@CronappTable(role=CronappTableRole.CLASS)
public class Tree implements Serializable {
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
    @CronappColumn(attributeType="STRING", label="Crew Member")
    @Column(name = "crew_member", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String crew_member;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_tree_0", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Tree captain;


    /**
    * Construtor
    * @generated
    */
    public Tree(){
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
    public Tree setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém crew_member
    * return crew_member
    * @generated
    */
    public java.lang.String getCrew_member() {
        return this.crew_member;
    }

    /**
    * Define crew_member
    * @param crew_member crew_member
    * @generated
    */
    public Tree setCrew_member(java.lang.String crew_member) {
        this.crew_member = crew_member;
        return this;
    }
    /**
    * Obtém captain
    * return captain
    * @generated
    */
    public Tree getCaptain() {
        return this.captain;
    }

    /**
    * Define captain
    * @param captain captain
    * @generated
    */
    public Tree setCaptain(Tree captain) {
        this.captain = captain;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Tree object = (Tree)obj;
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
