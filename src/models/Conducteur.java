/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wolf
 */
@Entity
@Table(name = "conducteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conducteur.findAll", query = "SELECT c FROM Conducteur c")
    , @NamedQuery(name = "Conducteur.findById", query = "SELECT c FROM Conducteur c WHERE c.id = :id")
    , @NamedQuery(name = "Conducteur.findByNom", query = "SELECT c FROM Conducteur c WHERE c.nom = :nom")
    , @NamedQuery(name = "Conducteur.findByPrenom", query = "SELECT c FROM Conducteur c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Conducteur.findByTel", query = "SELECT c FROM Conducteur c WHERE c.tel = :tel")
    , @NamedQuery(name = "Conducteur.findByEmail", query = "SELECT c FROM Conducteur c WHERE c.email = :email")
    , @NamedQuery(name = "Conducteur.findByPermis", query = "SELECT c FROM Conducteur c WHERE c.permis = :permis")})
public class Conducteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private int prenom;
    @Basic(optional = false)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "permis")
    private int permis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conducteurId")
    private Collection<Vehicule> vehiculeCollection;

    public Conducteur() {
    }

    public Conducteur(Integer id) {
        this.id = id;
    }

    public Conducteur(Integer id, String nom, int prenom, String tel, String email, int permis) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.permis = permis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrenom() {
        return prenom;
    }

    public void setPrenom(int prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermis() {
        return permis;
    }

    public void setPermis(int permis) {
        this.permis = permis;
    }

    @XmlTransient
    public Collection<Vehicule> getVehiculeCollection() {
        return vehiculeCollection;
    }

    public void setVehiculeCollection(Collection<Vehicule> vehiculeCollection) {
        this.vehiculeCollection = vehiculeCollection;
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
        if (!(object instanceof Conducteur)) {
            return false;
        }
        Conducteur other = (Conducteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Conducteur[ id=" + id + " ]";
    }
    
}
