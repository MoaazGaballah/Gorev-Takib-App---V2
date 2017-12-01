/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gorev;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muaz Ahmed
 */
@Entity
@Table(name = "GOREVLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gorevler.findAll", query = "SELECT g FROM Gorevler g"),
    @NamedQuery(name = "Gorevler.findByGorevId", query = "SELECT g FROM Gorevler g WHERE g.gorevId = :gorevId"),
    @NamedQuery(name = "Gorevler.findByGorevTipi", query = "SELECT g FROM Gorevler g WHERE g.gorevTipi = :gorevTipi"),
    @NamedQuery(name = "Gorevler.findBySurec", query = "SELECT g FROM Gorevler g WHERE g.surec = :surec"),
    @NamedQuery(name = "Gorevler.findByOncelik", query = "SELECT g FROM Gorevler g WHERE g.oncelik = :oncelik"),
    @NamedQuery(name = "Gorevler.findByKonu", query = "SELECT g FROM Gorevler g WHERE g.konu = :konu"),
    @NamedQuery(name = "Gorevler.findByGorevNotu", query = "SELECT g FROM Gorevler g WHERE g.gorevNotu = :gorevNotu"),
    @NamedQuery(name = "Gorevler.findByTamamlama", query = "SELECT g FROM Gorevler g WHERE g.tamamlama = :tamamlama"),
    @NamedQuery(name = "Gorevler.findByPersonelIsimi", query = "SELECT g FROM Gorevler g WHERE g.personelIsimi = :personelIsimi"),
    @NamedQuery(name = "Gorevler.findByDepartman", query = "SELECT g FROM Gorevler g WHERE g.departman = :departman"),
    @NamedQuery(name = "Gorevler.findByTarih", query = "SELECT g FROM Gorevler g WHERE g.tarih = :tarih")})
public class Gorevler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GOREV_ID")
    private Integer gorevId;
    @Column(name = "GOREV_TIPI")
    private String gorevTipi;
    @Column(name = "SUREC")
    private String surec;
    @Column(name = "ONCELIK")
    private String oncelik;
    @Column(name = "KONU")
    private String konu;
    @Column(name = "GOREV_NOTU")
    private String gorevNotu;
    @Column(name = "TAMAMLAMA")
    private Integer tamamlama;
    @Column(name = "PERSONEL_ISIMI")
    private String personelIsimi;
    @Column(name = "DEPARTMAN")
    private String departman;
    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;

    public Gorevler() {
    }

    public Gorevler(Integer gorevId) {
        this.gorevId = gorevId;
    }

    public Integer getGorevId() {
        return gorevId;
    }

    public void setGorevId(Integer gorevId) {
        this.gorevId = gorevId;
    }

    public String getGorevTipi() {
        return gorevTipi;
    }

    public void setGorevTipi(String gorevTipi) {
        this.gorevTipi = gorevTipi;
    }

    public String getSurec() {
        return surec;
    }

    public void setSurec(String surec) {
        this.surec = surec;
    }

    public String getOncelik() {
        return oncelik;
    }

    public void setOncelik(String oncelik) {
        this.oncelik = oncelik;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getGorevNotu() {
        return gorevNotu;
    }

    public void setGorevNotu(String gorevNotu) {
        this.gorevNotu = gorevNotu;
    }

    public Integer getTamamlama() {
        return tamamlama;
    }

    public void setTamamlama(Integer tamamlama) {
        this.tamamlama = tamamlama;
    }

    public String getPersonelIsimi() {
        return personelIsimi;
    }

    public void setPersonelIsimi(String personelIsimi) {
        this.personelIsimi = personelIsimi;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gorevId != null ? gorevId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gorevler)) {
            return false;
        }
        Gorevler other = (Gorevler) object;
        if ((this.gorevId == null && other.gorevId != null) || (this.gorevId != null && !this.gorevId.equals(other.gorevId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gorev.Gorevler[ gorevId=" + gorevId + " ]";
    }
    
}
