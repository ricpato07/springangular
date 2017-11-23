package com.spring.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jcdavila
 */
@Entity
@Table(name = "SB_TRASVASE", schema = "RGARCIAU")
public class SbTrasvase implements Serializable {

    @Id
    @Column(name = "NUNICODOC")
    private Long nunicodoc;
    @Column(name = "CAJA_ORIGEN")
    private Long cajaOrigen;
    @Column(name = "CAJA_DESTINO")
    private Long cajaDestino;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "ESTATUS")
    private char estatus;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "UBICACION")
    private String ubicacion;
    @Column(name = "TIPO_TRASVASE")
    private String tipoTrasvase;
    @Column(name = "EXPEDIENTE")
    private Long expediente;
    @Column(name = "ID_OPERATORIA")
    private Long idOperatoria;
    @Column(name = "TIPO_EXPEDIENTE")
    private Long tipoExpediente;

    public Long getNunicodoc() {
        return nunicodoc;
    }

    public void setNunicodoc(Long nunicodoc) {
        this.nunicodoc = nunicodoc;
    }

    public Long getCajaOrigen() {
        return cajaOrigen;
    }

    public void setCajaOrigen(Long cajaOrigen) {
        this.cajaOrigen = cajaOrigen;
    }

    public Long getCajaDestino() {
        return cajaDestino;
    }

    public void setCajaDestino(Long cajaDestino) {
        this.cajaDestino = cajaDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the tipoTrasvase
     */
    public String getTipoTrasvase() {
        return tipoTrasvase;
    }

    /**
     * @param tipoTrasvase the tipoTrasvase to set
     */
    public void setTipoTrasvase(String tipoTrasvase) {
        this.tipoTrasvase = tipoTrasvase;
    }

    /**
     * @return the expediente
     */
    public Long getExpediente() {
        return expediente;
    }

    /**
     * @param expediente the expediente to set
     */
    public void setExpediente(Long expediente) {
        this.expediente = expediente;
    }

    /**
     * @return the idOperatoria
     */
    public Long getIdOperatoria() {
        return idOperatoria;
    }

    /**
     * @param idOperatoria the idOperatoria to set
     */
    public void setIdOperatoria(Long idOperatoria) {
        this.idOperatoria = idOperatoria;
    }

    /**
     * @return the tipoExpediente
     */
    public Long getTipoExpediente() {
        return tipoExpediente;
    }

    /**
     * @param tipoExpediente the tipoExpediente to set
     */
    public void setTipoExpediente(Long tipoExpediente) {
        this.tipoExpediente = tipoExpediente;
    }

}
