/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wolf
 */
@Entity
@Table(name = "vehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v")
    , @NamedQuery(name = "Vehicule.findById", query = "SELECT v FROM Vehicule v WHERE v.id = :id")
    , @NamedQuery(name = "Vehicule.findByMatricule", query = "SELECT v FROM Vehicule v WHERE v.matricule = :matricule")
    , @NamedQuery(name = "Vehicule.findByMarque", query = "SELECT v FROM Vehicule v WHERE v.marque = :marque")
    , @NamedQuery(name = "Vehicule.findByModele", query = "SELECT v FROM Vehicule v WHERE v.modele = :modele")
    , @NamedQuery(name = "Vehicule.findByCouleur", query = "SELECT v FROM Vehicule v WHERE v.couleur = :couleur")
    , @NamedQuery(name = "Vehicule.findBySerie", query = "SELECT v FROM Vehicule v WHERE v.serie = :serie")
    , @NamedQuery(name = "Vehicule.findByCirculation", query = "SELECT v FROM Vehicule v WHERE v.circulation = :circulation")})
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @Column(name = "marque")
    private String marque;
    @Basic(optional = false)
    @Column(name = "modele")
    private String modele;
    @Basic(optional = false)
    @Column(name = "couleur")
    private String couleur;
    @Basic(optional = false)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @Column(name = "circulation")
    @Temporal(TemporalType.DATE)
    private Date circulation;
    @JoinColumn(name = "carburant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carburant carburantId;
    @JoinColumn(name = "conducteur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conducteur conducteurId;
    @JoinColumn(name = "departement_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departement departementId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeVoiture typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculeId")
    private Collection<AchatLocation> achatLocationCollection;

    public Vehicule() {
    }

    public Vehicule(Integer id) {
        this.id = id;
    }

    public Vehicule(Integer id, String matricule, String marque, String modele, String couleur, String serie, Date circulation) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.serie = serie;
        this.circulation = circulation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getCirculation() {
        return circulation;
    }

    public void setCirculation(Date circulation) {
        this.circulation = circulation;
    }

    public Carburant getCarburantId() {
        return carburantId;
    }

    public void setCarburantId(Carburant carburantId) {
        this.carburantId = carburantId;
    }

    public Conducteur getConducteurId() {
        return conducteurId;
    }

    public void setConducteurId(Conducteur conducteurId) {
        this.conducteurId = conducteurId;
    }

    public Departement getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Departement departementId) {
        this.departementId = departementId;
    }

    public TypeVoiture getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeVoiture typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<AchatLocation> getAchatLocationCollection() {
        return achatLocationCollection;
    }

    public void setAchatLocationCollection(Collection<AchatLocation> achatLocationCollection) {
        this.achatLocationCollection = achatLocationCollection;
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
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Vehicule[ id=" + id + " ]";
    }
    
}
