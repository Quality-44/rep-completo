
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;
    import cronapi.CronapiByteHeaderSignature;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela ARCHIVE
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"ARCHIVE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Archive")
@CronappTable(role=CronappTableRole.CLASS)
public class Archive implements Serializable {
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
    @CronappColumn(attributeType="FILE_DATABASE", label="File")
    @Column(name = "file", nullable = true, unique = false, insertable=true, updatable=true)
    @CronapiByteHeaderSignature
        
        private byte[] file;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Name")
    @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String name;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Content Type")
    @Column(name = "contentType", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String contentType;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="File Extension")
    @Column(name = "fileExtension", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String fileExtension;


    /**
    * Construtor
    * @generated
    */
    public Archive(){
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
    public Archive setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém file
    * return file
    * @generated
    */
    public byte[] getFile() {
        return this.file;
    }

    /**
    * Define file
    * @param file file
    * @generated
    */
    public Archive setFile(byte[] file) {
        this.file = file;
        return this;
    }
    /**
    * Obtém name
    * return name
    * @generated
    */
    public java.lang.String getName() {
        return this.name;
    }

    /**
    * Define name
    * @param name name
    * @generated
    */
    public Archive setName(java.lang.String name) {
        this.name = name;
        return this;
    }
    /**
    * Obtém contentType
    * return contentType
    * @generated
    */
    public java.lang.String getContentType() {
        return this.contentType;
    }

    /**
    * Define contentType
    * @param contentType contentType
    * @generated
    */
    public Archive setContentType(java.lang.String contentType) {
        this.contentType = contentType;
        return this;
    }
    /**
    * Obtém fileExtension
    * return fileExtension
    * @generated
    */
    public java.lang.String getFileExtension() {
        return this.fileExtension;
    }

    /**
    * Define fileExtension
    * @param fileExtension fileExtension
    * @generated
    */
    public Archive setFileExtension(java.lang.String fileExtension) {
        this.fileExtension = fileExtension;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Archive object = (Archive)obj;
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
