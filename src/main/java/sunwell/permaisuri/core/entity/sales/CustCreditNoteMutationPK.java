///*
// * CustCreditNoteMutationPK.java
// *
// * Created on December 3, 00:30
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.io.Serializable;
//import java.util.Calendar;
//
///**
// *
// * @author Irfin A
// */
//public class CustCreditNoteMutationPK implements Serializable
//{
//    private long m_cust;
//    private int m_refType;
//    private long m_refId;
//    private Calendar m_mutationDate;
//    private double m_amount;
//
//    public CustCreditNoteMutationPK ()
//    {
//    }
//
//    public CustCreditNoteMutationPK (long cust, int reftype, int refid, Calendar mutationDate, double _amount)
//    {
//        this.m_cust = cust;
//        this.m_refType = reftype;
//        this.m_refId = refid;
//        this.m_mutationDate = mutationDate;
//        this.m_amount = _amount;
//    }
//
//    public long getCust ()
//    {
//        return m_cust;
//    }
//
//    public void setCust (long cust)
//    {
//        this.m_cust = cust;
//    }
//
//    public int getRefType ()
//    {
//        return m_refType;
//    }
//
//    public void setRefType (int reftype)
//    {
//        this.m_refType = reftype;
//    }
//
//    public long getRefId ()
//    {
//        return m_refId;
//    }
//
//    public void setRefId (long refid)
//    {
//        this.m_refId = refid;
//    }
//
//    public Calendar getMutationDate ()
//    {
//        return m_mutationDate;
//    }
//
//    public void setMutationDate (Calendar mutationDate)
//    {
//        this.m_mutationDate = mutationDate;
//    }
//    
//    public double getAmount ()
//    {
//        return m_cust;
//    }
//
//    public void setAmount (double _amount)
//    {
//        this.m_amount = _amount;
//    }
//
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += (int) m_cust;
//        hash += (int) m_refType;
//        hash += (int) m_refId;
//        hash += (m_mutationDate != null ? m_mutationDate.hashCode () : 0);
//        hash += (double) m_amount;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CustCreditNoteMutationPK)) {
//            return false;
//        }
//        CustCreditNoteMutationPK other = (CustCreditNoteMutationPK) object;
//        if (this.m_cust != other.m_cust)
//            return false;
//        if (this.m_refType != other.m_refType)
//            return false;
//        if (this.m_refId != other.m_refId)
//            return false;
//        if (this.m_amount != other.m_amount)
//            return false;
//        if ((this.m_mutationDate == null && other.m_mutationDate != null) || (this.m_mutationDate != null && !this.m_mutationDate.equals (other.m_mutationDate)))
//            return false;
//        return true;
//    }
//
//    @Override
//    public String toString ()
//    {
//        return "sunwell.xrp.sales.payment.CustCreditNoteMutationPK[ cust=" + m_cust + ", reftype=" + m_refType + ", refid=" + m_refId + ", mutationDate=" + m_mutationDate + " ]";
//    }
//}
