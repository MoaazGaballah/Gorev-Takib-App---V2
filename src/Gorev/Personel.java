/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gorev;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muaz Ahmed
 */
@Entity
@Table(name = "PERSONEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personel.findAll", query = "SELECT p FROM Personel p"),
    @NamedQuery(name = "Personel.findByPersonelId", query = "SELECT p FROM Personel p WHERE p.personelId = :personelId"),
    @NamedQuery(name = "Personel.findByAdi", query = "SELECT p FROM Personel p WHERE p.adi = :adi"),
    @NamedQuery(name = "Personel.findBySoyadi", query = "SELECT p FROM Personel p WHERE p.soyadi = :soyadi"),
    @NamedQuery(name = "Personel.findByMaas", query = "SELECT p FROM Personel p WHERE p.maas = :maas"),
    @NamedQuery(name = "Personel.findByDepartman", query = "SELECT p FROM Personel p WHERE p.departman = :departman"),
    @NamedQuery(name = "Personel.findBySube", query = "SELECT p FROM Personel p WHERE p.sube = :sube"),
    @NamedQuery(name = "Personel.findByCinsiyet", query = "SELECT p FROM Personel p WHERE p.cinsiyet = :cinsiyet"),
    @NamedQuery(name = "Personel.findBySifre", query = "SELECT p FROM Personel p WHERE p.sifre = :sifre"),
    @NamedQuery(name = "Personel.findBySifretekrar", query = "SELECT p FROM Personel p WHERE p.sifretekrar = :sifretekrar")})
public class Personel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PERSONEL_ID")
    private Integer personelId;
    @Basic(optional = false)
    @Column(name = "ADI")
    private String adi;
    @Basic(optional = false)
    @Column(name = "SOYADI")
    private String soyadi;
    @Basic(optional = false)
    @Column(name = "MAAS")
    private Integer maas;
    @Basic(optional = false)
    @Column(name = "DEPARTMAN")
    private String departman;
    @Column(name = "SUBE")
    private String sube;
    @Column(name = "CINSIYET")
    private String cinsiyet;
    @Column(name = "SIFRE")
    private String sifre;
    @Column(name = "SIFRETEKRAR")
    private String sifretekrar;
    @Lob
    @Column(name = "PERSONEL_RESIMI")
    private byte[] personelResimi;

    public Personel() {
    }
    
    
    
    

    public Personel(int personelId) {
        this.personelId = personelId;
    }

    public Personel(int personelId, String adi, String soyadi, int maas, String departman) {
        this.personelId = personelId;
        this.adi = adi;
        this.soyadi = soyadi;
        this.maas = maas;
        this.departman = departman;
    }

    public Integer getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId ) {
        this.personelId = personelId;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Integer getMaas() {
        return maas;
    }

    public void setMaas(Integer maas) {
        this.maas = maas;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getSube() {
        return sube;
    }

    public void setSube(String sube) {
        this.sube = sube;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSifretekrar() {
        return sifretekrar;
    }

    public void setSifretekrar(String sifretekrar) {
        this.sifretekrar = sifretekrar;
    }

    public byte[] getPersonelResimi() {
        return personelResimi;
    }

    public void setPersonelResimi(byte[] personelResimi) {
        this.personelResimi = personelResimi;
    }
    public  ImageIcon getscaledImage() {
        ImageIcon imageicon=new ImageIcon(personelResimi);//load the image to the image icon
        Image image=imageicon.getImage();//transform it
        double h=100.0/imageicon.getIconHeight();//calculate w /h ratio
        Image newimage =image.getScaledInstance((int)(imageicon.getIconWidth()*h),
                (int)(imageicon.getIconHeight()*h), java.awt.Image.SCALE_SMOOTH);//scale it the smooth way
        return new ImageIcon(newimage);//transform it back
    }
    static JFileChooser jc;
    public static byte[]readImage() {
        InputStream is=null;
        byte[] bytes=null;
        try {
            File file=new File(jc.getSelectedFile().getAbsolutePath());
            is =new FileInputStream(file);
            //get the size of the file 
            long length =file.length();
            if (length >Integer.MAX_VALUE) {
                JOptionPane.showMessageDialog(null, "Dosya çok büyük");
                return null;
            }
            //create the byte array to hold the data
            bytes=new byte[(int)length];
            //read in the beyts
            int offset=0;
            int numRead=0;
            while (offset<bytes.length&&(numRead=is.read(bytes,offset,bytes.length-offset))>=0) {                
                offset+=numRead;
            }//ensure all the bytes have read in 
            is.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                is.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return bytes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personelId != null ? personelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personel)) {
            return false;
        }
        Personel other = (Personel) object;
        if ((this.personelId == null && other.personelId != null) || (this.personelId != null && !this.personelId.equals(other.personelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gorev.Personel[ personelId=" + personelId + " ]";
    }
    
}
