package com.spring.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rgarciau
 */
@Embeddable
public class SbTrasvaseCajaDetaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IDTRASVASE")
    private long idtrasvase;
    @Basic(optional = false)
    @Column(name = "ETIQUETA")
    private long etiqueta;

    public SbTrasvaseCajaDetaPK() {
    }

    public SbTrasvaseCajaDetaPK(long idtrasvase, long etiqueta) {
        this.idtrasvase = idtrasvase;
        this.etiqueta = etiqueta;
    }

    public long getIdtrasvase() {
        return idtrasvase;
    }

    public void setIdtrasvase(long idtrasvase) {
        this.idtrasvase = idtrasvase;
    }

    public long getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(long etiqueta) {
        this.etiqueta = etiqueta;
    }
 
    @Override
    public String toString() {
        return "com.spring.pojos.SbTrasvaseCajaDetaPK[ idtrasvase=" + idtrasvase + ", etiqueta=" + etiqueta + " ]";
    }
    
}
