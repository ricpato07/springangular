package com.spring.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rgarciau
 */
@Entity
@Table(name = "SB_TRASVASE_CAJA_DETA")
public class SbTrasvaseCajaDeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SbTrasvaseCajaDetaPK sbTrasvaseCajaDetaPK;
    @Basic(optional = false)
    @Column(name = "IDOPERATORIA")
    private int idoperatoria;
    @Basic(optional = false)
    @Column(name = "SCLTCOD")
    private short scltcod;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "TIPO_ETIQUETA")
    private String tipoEtiqueta;

    public SbTrasvaseCajaDeta() {
    }

    public SbTrasvaseCajaDeta(SbTrasvaseCajaDetaPK sbTrasvaseCajaDetaPK) {
        this.sbTrasvaseCajaDetaPK = sbTrasvaseCajaDetaPK;
    }

    public SbTrasvaseCajaDeta(SbTrasvaseCajaDetaPK sbTrasvaseCajaDetaPK, int idoperatoria, short scltcod, short status, String tipoEtiqueta) {
        this.sbTrasvaseCajaDetaPK = sbTrasvaseCajaDetaPK;
        this.idoperatoria = idoperatoria;
        this.scltcod = scltcod;
        this.status = status;
        this.tipoEtiqueta = tipoEtiqueta;
    }

    public SbTrasvaseCajaDeta(long idtrasvase, long etiqueta) {
        this.sbTrasvaseCajaDetaPK = new SbTrasvaseCajaDetaPK(idtrasvase, etiqueta);
    }

    public SbTrasvaseCajaDetaPK getSbTrasvaseCajaDetaPK() {
        return sbTrasvaseCajaDetaPK;
    }

    public void setSbTrasvaseCajaDetaPK(SbTrasvaseCajaDetaPK sbTrasvaseCajaDetaPK) {
        this.sbTrasvaseCajaDetaPK = sbTrasvaseCajaDetaPK;
    }

    public int getIdoperatoria() {
        return idoperatoria;
    }

    public void setIdoperatoria(int idoperatoria) {
        this.idoperatoria = idoperatoria;
    }

    public short getScltcod() {
        return scltcod;
    }

    public void setScltcod(short scltcod) {
        this.scltcod = scltcod;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoEtiqueta() {
        return tipoEtiqueta;
    }

    public void setTipoEtiqueta(String tipoEtiqueta) {
        this.tipoEtiqueta = tipoEtiqueta;
    }

    @Override
    public String toString() {
        return "com.spring.pojos.SbTrasvaseCajaDeta[ sbTrasvaseCajaDetaPK=" + sbTrasvaseCajaDetaPK + " ]";
    }

}
