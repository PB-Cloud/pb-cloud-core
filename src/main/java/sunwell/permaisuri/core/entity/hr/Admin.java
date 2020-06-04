/*
 * Employee.java
 *
 * Created on May 25, 2014
 */
package sunwell.permaisuri.core.entity.hr;

import java.io.Serializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlTransient;

import sunwell.permaisuri.core.entity.contact.Contact;
import sunwell.permaisuri.core.entity.cred.UserCredential;

/**
 *
 * @author irfin
 */
@Entity
@Table(name = "admin")
public class Admin extends Contact
{
      
}
