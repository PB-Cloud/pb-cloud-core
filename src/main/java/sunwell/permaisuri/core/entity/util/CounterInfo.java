///**
// * Counterinfo.java
// *
// * Created on Oct 30, 2014, 2:35:39 PM
// */
//package sunwell.permaisuri.core.entity.util;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Query;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Benny
// * @author Irfin
// */
//@Entity 
//@Table(name = "counterinfo")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CounterInfo.findAll", query = "SELECT c FROM CounterInfo c ORDER BY c.m_counterName"),
//    @NamedQuery(name = "CounterInfo.findBySystemId", query = "SELECT c FROM CounterInfo c WHERE c.m_systemId = :systemId"),
//    @NamedQuery(name = "CounterInfo.findByCounterName", query = "SELECT c FROM CounterInfo c WHERE c.m_counterName = :counterName"),
//    @NamedQuery(name = "CounterInfo.findByLocation", query = "SELECT c FROM CounterInfo c WHERE c.m_location = :location ORDER BY c.m_counterName")
//})
//public class CounterInfo implements Serializable 
//{
//    private static final long serialVersionUID = 1L;
//    
//    private static CounterInfo m_currentInstanceForThisMachine;
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counterinfo_systemid_seq")
//    @SequenceGenerator (name = "counterinfo_systemid_seq", sequenceName = "counterinfo_systemid_seq", allocationSize = 1 )
//    @Basic(optional = false)
//    @Column(name = "systemid")
//    private Long m_systemId;
//    
//    @Column(name = "counter_name")
//    private String m_counterName;
//    
//    @Column(name = "location")
//    private String m_location;
//    
//    @Column(name = "memo")
//    private String m_memo;
//    
//    public CounterInfo ()
//    {
//    }
//
//    public CounterInfo (Long systemId)
//    {
//        this.m_systemId = systemId;
//    }
//
//    public Long getSystemId ()
//    {
//        return m_systemId;
//    }
//
//    public void setSystemId (Long systemId)
//    {
//        this.m_systemId = systemId;
//    }
//
//    public String getCounterName ()
//    {
//        return m_counterName;
//    }
//
//    public void setCounterName (String counterName)
//    {
//        this.m_counterName = counterName;
//    }
//
//    public String getLocation ()
//    {
//        return m_location;
//    }
//
//    public void setLocation (String location)
//    {
//        this.m_location = location;
//    }
//
//    public String getMemo ()
//    {
//        return m_memo;
//    }
//
//    public void setMemo (String memo)
//    {
//        this.m_memo = memo;
//    }
//
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += (m_systemId != null ? m_systemId.hashCode () : 0);
//        return hash;
//    }
//
//    /*@Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CounterInfo)) {
//            return false;
//        }
//        CounterInfo other = (CounterInfo) object;
//        if ((this.m_systemId == null && other.m_systemId != null) || (this.m_systemId != null && !this.m_systemId.equals (other.m_systemId)))
//            return false;
//        return true;
//    }*/
//    
//   
//    
//    // Contoh Cara Pemakaian di Main.java:
//    //
//    // m_IdCounterInfo = 1;  <-- diisikan PK yg ada di tabel `counterinfo`
//    // boolean bool = CounterInfo.setDefaultInstanceId (m_IdCounterInfo);
//    // if (!bool)
//    //     Library.warningDialog (null, "Konfigurasi standar untuk Counter Info tidak ditemukan.\nHubungi administrator sistem.", "Pesan");
//}
