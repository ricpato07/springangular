package com.spring.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rgarciau
 */
@Entity
@Table(name = "SB_TRASVASE_CAJA_CAB", schema = "RGARCIAU")
public class SbTrasvaseCajaCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTRASVASE")
    private Long idtrasvase;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "CAJA_ID")
    private int cajaId;
    @Column(name = "PRECINTO")
    private String precinto;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
   

    public SbTrasvaseCajaCab() {
    }

    public SbTrasvaseCajaCab(Long idtrasvase) {
        this.idtrasvase = idtrasvase;
    }

    public SbTrasvaseCajaCab(Long idtrasvase, int cajaId, short status) {
        this.idtrasvase = idtrasvase;
        this.cajaId = cajaId;
        this.status = status;
    }

    public Long getIdtrasvase() {
        return idtrasvase;
    }

    public void setIdtrasvase(Long idtrasvase) {
        this.idtrasvase = idtrasvase;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCajaId() {
        return cajaId;
    }

    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }

    public String getPrecinto() {
        return precinto;
    }

    public void setPrecinto(String precinto) {
        this.precinto = precinto;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
  
    @Override
    public String toString() {
        return "com.spring.pojos.SbTrasvaseCajaCab[ idtrasvase=" + idtrasvase + " ]";
    }
    
}
