/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gorev;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muaz Ahmed
 */
@Entity
@Table(name = "DEPARTMAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departman.findAll", query = "SELECT d FROM Departman d"),
    @NamedQuery(name = "Departman.findByKodu", query = "SELECT d FROM Departman d WHERE d.kodu = :kodu"),
    @NamedQuery(name = "Departman.findByAdi", query = "SELECT d FROM Departman d WHERE d.adi = :adi"),
    @NamedQuery(name = "Departman.findByPersonelSayisi", query = "SELECT d FROM Departman d WHERE d.personelSayisi = :personelSayisi")})
public class Departman implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KODU")
    private Integer kodu;
    @Basic(optional = false)
    @Column(name = "ADI")
    private String adi;
    @Basic(optional = false)
    @Column(name = "PERSONEL_SAYISI")
    private int personelSayisi;

    public Departman() {
    }

    public Departman(Integer kodu) {
        this.kodu = kodu;
    }

    public Departman(Integer kodu, String adi, int personelSayisi) {
        this.kodu = kodu;
        this.adi = adi;
        this.personelSayisi = personelSayisi;
    }

    public Integer getKodu() {
        return kodu;
    }

    public void setKodu(Integer kodu) {
        this.kodu = kodu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public int getPersonelSayisi() {
        return personelSayisi;
    }

    public void setPersonelSayisi(int personelSayisi) {
        this.personelSayisi = personelSayisi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodu != null ? kodu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departman)) {
            return false;
        }
        Departman other = (Departman) object;
        if ((this.kodu == null && other.kodu != null) || (this.kodu != null && !this.kodu.equals(other.kodu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gorev.Departman[ kodu=" + kodu + " ]";
    }
    
}
