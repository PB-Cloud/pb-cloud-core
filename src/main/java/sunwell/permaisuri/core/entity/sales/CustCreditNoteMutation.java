///*
// * CustCreditNoteMutation.java
// *
// * Created on December 3, 00:30
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.io.Serializable;
//
//import java.math.BigDecimal;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Query;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.xml.bind.annotation.XmlRootElement;
//
//import sunwell.permaisuri.core.entity.customer.Customer;
//
///**
// *
// * @author Irfin A
// */
//@Entity
////@IdClass (CustCreditNoteMutationPK.class)
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CustCreditNoteMutation.findAll", query = "SELECT c FROM CustCreditNoteMutation c"),
//    @NamedQuery(name = "CustCreditNoteMutation.findByCust", query = "SELECT c FROM CustCreditNoteMutation c WHERE c.m_cust = :cust ORDER BY c.m_mutationDate"),
//    @NamedQuery(name = "CustCreditNoteMutation.findByRefType", query = "SELECT c FROM CustCreditNoteMutation c WHERE c.m_refType = :reftype"),
//    @NamedQuery(name = "CustCreditNoteMutation.findByRefTypeAndId", query = "SELECT c FROM CustCreditNoteMutation c WHERE c.m_refType = :reftype AND c.m_refId = :refid ORDER BY c.m_mutationDate"),
//    @NamedQuery(name = "CustCreditNoteMutation.findByMutationDate", query = "SELECT c FROM CustCreditNoteMutation c WHERE c.m_mutationDate = :mutationdate")
//})
//public class CustCreditNoteMutation implements Serializable
//{
//    private static final long serialVersionUID = 1L;
//    
//    public static final int REFTYPE_UNDEFINED = 0;
//    public static final int REFTYPE_RETURN = 1;
//    public static final int REFTYPE_PAYMENT = 2;
//    public static final int REFTYPE_MANUAL = 3;
//    public static final int REFTYPE_CUST_WITHDRAW_RETURN = 4;
//    public static final int REFTYPE_CUST_WITHDRAW_CASH = 5;
//
//    
//    @Id
//    @Column(name= "systemid")
//    @SequenceGenerator (name = "custcreditnotemutation_systemid_seq", sequenceName = "custcreditnotemutation_systemid_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "custcreditnotemutation_systemid_seq")
//    private long m_systemID;
//    
////    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cust")
//    private Customer m_cust;
//    
////    @Id
//    @Column(name = "reftype")
//    private int m_refType;
//    
////    @Id
//    @Column(name = "refid")
//    private long m_refId;
//    
////    @Id
//    @Column(name = "mutation_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Calendar m_mutationDate;
//    
////    @Id
//    @Column(name = "amount", nullable = false)
//    private double m_amount;
//    
//    @Column(name = "memo")
//    private String memo;
//
//    public CustCreditNoteMutation ()
//    {
//    }
//    
//    public long getSystemID() {
//        return m_systemID;
//    }
//    
//    public void setSystemID(long _id) {
//        m_systemID = _id;
//    }
//    
//    public Customer getCustomer ()
//    {
//        return m_cust;
//    }
//    
//    public void setCustomer (Customer _c)
//    {
//        m_cust = _c;
//    }
//    
//    public int getRefType ()
//    {
//        return m_refType;
//    }
//    
//    public void setRefType (int _type)
//    {
//        m_refType = _type;
//    }
//    
//    public long getRefId ()
//    {
//        return m_refId;
//    }
//    
//    public void setRefId (long _refid)
//    {
//        m_refId = _refid;
//    }
//    
//    public Calendar getMutationDate ()
//    {
//        return m_mutationDate;
//    }
//    
//    public void setMutationDate (Calendar _d)
//    {
//        m_mutationDate = _d;
//    }
//
//    public double getAmount ()
//    {
//        return m_amount;
//    }
//
//    public void setAmount (double _amount)
//    {
//        this.m_amount = _amount;
//    }
//
//    public String getMemo ()
//    {
//        return memo;
//    }
//
//    public void setMemo (String _s)
//    {
//        this.memo = _s;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 5;
//        hash = 79 * hash + Objects.hashCode (this.m_cust);
//        hash = 79 * hash + this.m_refType;
//        hash = (int) (79 * hash + this.m_refId);
//        hash = 79 * hash + Objects.hashCode (this.m_mutationDate);
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object obj)
//    {
//        if (obj == null)
//            return false;
//        if (getClass () != obj.getClass ())
//            return false;
//        
//        final CustCreditNoteMutation other = (CustCreditNoteMutation) obj;
//        if (!Objects.equals (this.m_cust, other.m_cust))
//            return false;
//        if (this.m_refType != other.m_refType)
//            return false;
//        if (this.m_refId != other.m_refId)
//            return false;
//        
//        if (!Objects.equals (this.m_mutationDate, other.m_mutationDate))
//            return false;
//        
//        return true;
//    }
//}
