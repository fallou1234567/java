/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wolf
 */
@Entity
@Table(name = "achat_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AchatLocation.findAll", query = "SELECT a FROM AchatLocation a")
    , @NamedQuery(name = "AchatLocation.findById", query = "SELECT a FROM AchatLocation a WHERE a.id = :id")
    , @NamedQuery(name = "AchatLocation.findByDate", query = "SELECT a FROM AchatLocation a WHERE a.date = :date")
    , @NamedQuery(name = "AchatLocation.findByPrix", query = "SELECT a FROM AchatLocation a WHERE a.prix = :prix")
    , @NamedQuery(name = "AchatLocation.findByPrixVente", query = "SELECT a FROM AchatLocation a WHERE a.prixVente = :prixVente")
    , @NamedQuery(name = "AchatLocation.findByKilometrage", query = "SELECT a FROM AchatLocation a WHERE a.kilometrage = :kilometrage")
    , @NamedQuery(name = "AchatLocation.findByNote", query = "SELECT a FROM AchatLocation a WHERE a.note = :note")})
public class AchatLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "prix")
    private int prix;
    @Basic(optional = false)
    @Column(name = "prix_vente")
    private int prixVente;
    @Basic(optional = false)
    @Column(name = "kilometrage")
    private int kilometrage;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fournisseur fournisseurId;
    @JoinColumn(name = "vehicule_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicule vehiculeId;

    public AchatLocation() {
    }

    public AchatLocation(Integer id) {
        this.id = id;
    }

    public AchatLocation(Integer id, Date date, int prix, int prixVente, int kilometrage, String note) {
        this.id = id;
        this.date = date;
        this.prix = prix;
        this.prixVente = prixVente;
        this.kilometrage = kilometrage;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Fournisseur getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Fournisseur fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Vehicule getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(Vehicule vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AchatLocation)) {
            return false;
        }
        AchatLocation other = (AchatLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.AchatLocation[ id=" + id + " ]";
    }
    
}
