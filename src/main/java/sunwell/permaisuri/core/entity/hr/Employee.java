///*
// * Employee.java
// *
// * Created on May 25, 2014
// */
//package sunwell.permaisuri.core.entity.hr;
//
//import java.io.Serializable;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Collection;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Query;
//import javax.persistence.Table;
//import javax.persistence.TypedQuery;
//import javax.xml.bind.annotation.XmlTransient;
//
//import sunwell.permaisuri.core.entity.contact.Contact;
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//
///**
// *
// * @author irfin
// */
//@Entity
//@Table(name = "employee")
////@NamedQueries({
////    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
////    @NamedQuery(name = "Employee.findBySystemId", query = "SELECT e FROM Employee e WHERE e.systemId = :systemid"),
////    @NamedQuery(name = "Employee.findByEIN", query = "SELECT e FROM Employee e WHERE e.ein = :ein"),
////    @NamedQuery(name = "Employee.findByCredential", query = "SELECT e FROM Employee e WHERE e.credential = :cred")})
//public class Employee extends Contact
//{
//    private static final long serialVersionUID = 1L;
//    
//    @Basic(optional = false)
//    @Column(name = "ein")
//    private String ein;
//    
////    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER)
////    private Collection<Employment> employments;
//    
////    @ManyToOne
////    @JoinColumn(name = "jobspecialitytype", nullable = true)
////    private JobSpecialityType jobSpeciality;
//    
////    @OneToOne
////    @JoinColumn(name = "cred")
////    private UserCredential credential;
//
//    public Employee ()
//    {
//    }
//
//    public Employee (Long systemid)
//    {
//        super (systemid);
//    }
//
//    public Employee (Long systemid, String ein)
//    {
//        super (systemid);
//        this.ein = ein;
//    }
//
//    public String getEIN ()
//    {
//        return ein;
//    }
//
//    public void setEIN (String ein)
//    {
//        this.ein = ein;
//    }
//    
////    public UserCredential getCredential ()
////    {
////        return credential;
////    }
////    
////    public void setCredential (UserCredential _uc)
////    {
////        credential = _uc;
////    }
//
////    @XmlTransient
////    public Collection<Employment> getEmployments ()
////    {
////        return employments;
////    }
////
////    public void setEmployments (Collection<Employment> employmentCollection)
////    {
////        this.employments = employmentCollection;
////    }
//    
////    public JobSpecialityType getJobSpeciality ()
////    {
////        return jobSpeciality;
////    }
////
////    public void setJobSpeciality (JobSpecialityType jobSpeciality)
////    {
////        this.jobSpeciality = jobSpeciality;
////    }
//
////    @Override
////    public int hashCode ()
////    {
////        int hash = 0;
////        hash += (getSystemId () != null ? getSystemId ().hashCode () : 0);
////        return hash;
////    }
////
////    @Override
////    public boolean equals (Object _obj)
////    {
////    	if(_obj == null)
////    		return false;
////        // TODO: Warning - this method won't work in the case the id fields are not set
////        if (!(_obj instanceof Employee))
////            return false;
////        
////        Employee other = (Employee) _obj;
////        if ((this.getSystemId() == null && other.getSystemId() != null) ||
////            (this.getSystemId() != null && !this.getSystemId().equals (other.getSystemId())))
////            return false;
////        
////        return true;
////    }
//
//    @Override
//    public String toString ()
//    {
//        return this.getFullNameWithTitle () + " [" + this.ein + "]";
//    }    
//}
