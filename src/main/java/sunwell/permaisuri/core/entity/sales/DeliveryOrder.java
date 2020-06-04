///*
// * DeliveryOrder.java
// *
// * Created on November 13, 2007, 1:48 PM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.util.*;
//import java.sql.*;
//import javax.persistence.EntityManager;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//import sunwell.permaisuri.core.entity.util.CounterInfo;
//
//import javax.persistence.*;
//
///**
// * Surat Jalan (D.O.) yg dibuat utk pesanan barang yg telah disiapkan stoknya 
// * (sudah ada reservasinya). DO boleh diterbitkan secara bertahap meski stok 
// * pesanan barang telah siap seluruhnya.
// * 
// * @author Irfin A
// * @version 1.0 - November 13, 2007 ; initial version
// * @version 2.0 - March 12, 2009 ; penambahan field `m_printed`, `m_printdate`, dan
// *                      `m_last_print_by` utk mendukung fitur secured-printing.
// * @version 2.1 - April 04, 2009 ; tambahan field `m_numprinted` utk melengkapi fitur
// *              versi 2.0
// * @version 2.5 - June 01, 2009 ; tambahan field `do_no` utk penomoran DO, sehingga
// *              nomor DO yg ditampilkan ke user bukan lagi berbentuk primary key
// * @version 3.0 - October 22, 2009 ; tambahan field `do_type` dan konstanta TYPE_XXX utk
// *              mengakomodasi permintaan Benteng Baru yaitu, DO jenis Gudang, Pabrik,
// *              dan Sendengan. Ketiga jenis DO ini memiliki tata cara pengolahan stok yg sama,
// *              yg berbeda adalah nomor urut (no sequence) yg digunakan serta bentuk
// *              print-out.
// * @version 3.2 - March 17, 2010 ; perubahan interface dari PersistentObject ke
// *              EntityObject.
// * @version 3.3 - Jul 24, 2015 ; tambahan method queryNoFor(int)
// */
//@Entity
//@Table( name = "deliveryorder" )
//public class DeliveryOrder 
//{
//    public static final int PRIORITY_NORM = 0;
//    public static final int PRIORITY_HIGH = 1;
//    public static final int PRIORITY_LOW = 2;
//
//    /** since version 3.0 */
//    public static final int TYPE_SENDENGAN = 0;
//    public static final int TYPE_NORMAL = 1;
//    public static final int TYPE_PABRIK = 2;
//    public static final int TYPE_MTS = 3;   // Makassar Tene
//    public static final int TYPE_TAKALAR = 4;
//    public static final int TYPE_CAMMING = 5;
//    public static final int TYPE_BONE = 6;
//    
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_do" )
//    @SequenceGenerator (name = "deliveryorder_id_do_seq", sequenceName = "deliveryorder_id_do_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "deliveryorder_id_do_seq")
//    private int systemId;
//    
//	@NotNull(message="{error_no_sr}")
//    @ManyToOne
//    @JoinColumn( name = "id_stockrsrv")
//    private StockReservation stockReservation ;
//    
//    @ManyToOne
//    @JoinColumn( name = "sys_creator" )
//    private UserCredential sysCreator;
//    
//    @ManyToOne
//    @JoinColumn( name = "sys_updater" )
//    private UserCredential sysUpdater;
//    
//    @ManyToOne
//    @JoinColumn( name = "locket_no" )
//    private CounterInfo locketNo ;
//    
//    @ManyToOne
//    @JoinColumn( name = "last_print_by" )
//    private UserCredential lastPrintBy;
//    
//    @OneToMany( mappedBy = "deliveryOrder", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
//    private List<ItemDO> items ;
//    
//    @Column( name = "isuue_datetime" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar issueDatetime = Calendar.getInstance();
//    
//    @Column( name = "delivery_datetime" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar deliveryDatetime = null;
//    
//    @Column( name = "sys_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar sysCreateDate;
//    
//    @Column( name = "sys_lastupdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar sysUpdateDate;
//    
//    @Column( name = "orintdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar printDate;
//    
//    /** Must be UNIQUE */
//    @Column( name = "do_no", unique = true)
//    private String doNo = null;
//    
//    @Column( name = "valid_days" )
//    private int validDays = 1;
//    
//    @Column( name = "delivery_mode" )
//    private String deliveryMode = "";
//    
//    @Column( name = "to_attn" )
//    private String toAttn = "";
//    
//    @Column( name = "shipto_addr" )
//    private String shipToAddr = "";
//    
//    @Column( name = "shipto_city" )
//    private String shipToCity = "";
//    
//    @Column( name = "shipto_sitename")
//    private String shipToSiteName = "";
//    
//    @Column( name = "shipto_attn")
//    private String shipToAttn = "";
//    
//    @Column( name = "priority")
//    private int priority = PRIORITY_NORM;
//    
//    @Column( name = "memo")
//    private String memo = "";
//
//    @Column( name = "printed")
//    private boolean printed = false;
//    
//    /** berapa kali dokumen sales invoice ini dicetak */
//    @Column( name = "numprinted" )
//    private int numPrinted = 0;
//
//    /** Menandakan DO ini telah selesai diproses dan tidak boleh lagi ada
//     *  aktivitas pergerakan barang menggunakan DO ini. */
//    @Column( name = "dismissed" )
//    private boolean dismissed = false;
//    
//    // since version 3.0
//    @Column( name = "do_type" )
//    private int doType = TYPE_NORMAL;
//    
//
//    public DeliveryOrder ()
//    {
//        this (-1);
//    }
//    
//    /**
//     * Create new DeliveryOrder with ID <code>_idDO</code>
//     * 
//     * @param _idDO
//     */
//    public DeliveryOrder (int _idDO)
//    {
//        systemId = _idDO;
//        validDays = 0;
//    }
//    
//    public int getSystemId () { return this.systemId; }
//    
//    public void setSystemId (int _idDO)
//    {
//        this.systemId = _idDO;
//    }
//
//    public String getDONo () { return doNo; }
//
//    /**
//     * Must be unique
//     * @param _number
//     */
//    public void setDONo (String _number)
//    {
//        doNo = _number;
//    }
//
//    /**
//     * Default tipe DO adalah {@link #TYPE_NORMAL}
//     * @return
//     */
//    public int getType () { return doType; }
//
//    /**
//     *
//     * @param _type harus bernilai salah satu dari {@link #TYPE_NORMAL}, {@link #TYPE_PABRIK},
//     *      atau {@link #TYPE_SENDENGAN}
//     */
//    public void setType (int _type)
//    {
//        doType = _type;
//    }
//    
//    public StockReservation getStockReservation ()
//    {
//        return stockReservation;
//    }
//
//    public void setStockReservation (StockReservation _sr)
//    {
//        stockReservation = _sr;
//    }
//    
//    /**
//     * Query on-demand data StockReservation
//     * 
//     * @return StockReservation atau null jika tidak ditemukan atau terjadi 
//     *  error saat query ke DB.
//     */
////    public StockReservation getReferencedStockReservation ()
////    {
////        if (m_stockRsrv != null)
////            return m_stockRsrv;
////        
////        String sql = null;
////        Statement stmt = null;
////        ResultSet rs = null;
////        
////        sql = "SELECT id_stockrsrv FROM deliveryorder WHERE id_do = " + m_id_do;
////        try {
////            stmt = MainAppRuntime.getDBConnection ().getConnection ().createStatement (ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
////            rs = stmt.executeQuery (sql);
////            if (! rs.next ())
////                return null;
////            
////            int idStockRsrv = rs.getInt (1);
////            m_stockRsrv = StockReservation.queryByID (idStockRsrv);
////            
////            return m_stockRsrv;
////        }
////        catch (SQLException q) {
////            GenericLogger.logSevere ("Error saat query on-demand data StockReservation: " + q.getMessage (), q.getStackTrace ());
////            return null;
////        }
////        finally {
////            if (stmt != null)
////                try { stmt.close (); } catch (SQLException z) { }
////        }
////    }
//
//    public boolean isDismissed () { return dismissed; }
//
//    public void setDismissed (boolean _status)
//    {
//        dismissed = _status;
//    }
//    
//    public int getValidDays () { return validDays; }
//    
//    /**
//     * Valid days. Must be a positive integer
//     * 
//     * @param _days
//     */
//    public void setValidDays (int _days)
//    {
//        this.validDays = java.lang.Math.abs (_days);
//    }
//
//    public int getItemCount ()
//    {
//        return items != null ? items.size() : 0;
//    }
//    
//    public List<ItemDO> getItems () 
//    {         
//        return items; 
//    }
//
//    public void setItems (List<ItemDO> _items)
//    {
//        items = _items;
//    }
//
//    public String getDeliveryMode () { return deliveryMode; }
//
//    public void setDeliveryMode (String _delivMode)
//    {
//        this.deliveryMode = (_delivMode != null) ? _delivMode : "";
//    }
//
//    public Calendar getIssueDatetime () { return issueDatetime; }
//
//    public void setIssueDatetime (Calendar _issue_datetime)
//    {
//        this.issueDatetime = _issue_datetime;
//    }
//
//    public Calendar getDeliveryDatetime () { return deliveryDatetime; }
//
//    public void setDeliveryDatetime (Calendar _delivDatetime)
//    {
//        this.deliveryDatetime = _delivDatetime;
//    }
//
//    public String getToAttn () { return toAttn; }
//
//    public void setToAttn (String _attn)
//    {
//        this.toAttn = (_attn != null) ? _attn : "";
//    }
//
//    public String getShipToAddr () { return shipToAddr; }
//
//    public void setShipToAddr (String _addr)
//    {
//        this.shipToAddr = (_addr != null) ? _addr : "";
//    }
//
//    public String getShipToCity () { return shipToCity; }
//
//    public void setShipToCity (String _city)
//    {
//        this.shipToCity = (_city != null) ? _city : "";
//    }
//
//    public String getShipToSitename () { return shipToSiteName; }
//
//    public void setShipToSitename (String _sitename)
//    {
//        this.shipToSiteName = (_sitename != null) ? _sitename : "";
//    }
//
//    public String getShipToAttn () { return shipToAttn; }
//
//    public void setShipToAttn (String _attn)
//    {
//        this.shipToAttn = (_attn != null) ? _attn : "";
//    }
//
//    public int getPriority () { return priority; }
//
//    public void setPriority (int _priority)
//    {
//        this.priority = _priority;
//    }
//    
//    public String getMemo () { return this.memo; }
//    
//    public void setMemo (String _txt)
//    {
//        this.memo = (_txt != null) ? _txt : "";
//    }
//
//    public boolean isPrinted () { return printed; }
//
//    public void setPrinted (boolean _status)
//    {
//        printed = _status;
//    }
//
//    public Calendar getPrintDate () { return printDate; }
//
//    public void setPrintDate (Calendar _printDate)
//    {
//        printDate = _printDate;
//    }
//
//    private void setNumPrinted (int _n)
//    {
//        numPrinted = _n;
//    }
//
//    /**
//     * Mengetahui jumlah dokumen sales invoice ini dicetak.
//     * @return
//     */
//    public int getNumPrinted ()
//    {
//        return numPrinted;
//    }
//
//    public UserCredential getLastPrintBy () { return lastPrintBy; }
//
//    public void setLastPrintBy (UserCredential _e)
//    {
//        lastPrintBy = _e;
//    }
//    
//    public Calendar getBusinessObjCreateDate () { return sysCreateDate; }
//
//    public void setBusinessObjCreateDate (Calendar m_user_createdate)
//    {
//        this.sysCreateDate = m_user_createdate;
//    }
//
//    public Calendar getBusinessObjUpdateDate () { return sysUpdateDate; }
//
//    public void setBusinessObjUpdateDate (Calendar m_user_modifydate)
//    {
//        this.sysUpdateDate = m_user_modifydate;
//    }
//    
//    public UserCredential getBusinessObjCreator ()
//    { 
//        return sysCreator;
//    }
//
//    public void setBusinessObjCreator (UserCredential _userCreate)
//    {
//        this.sysCreator = _userCreate;
//    }
//
//    /**
//     * Melakukan query ke DB utk mendapatkan objek User yg memodifikasi Purchase ini.
//     */
//    public UserCredential getBusinessObjUpdater ()
//    { 
//        return sysUpdater;
//    }
//
//    public void setBusinessObjUpdater (UserCredential m_userModify)
//    {
//        this.sysUpdater = m_userModify;
//    }
//    
//    public CounterInfo getLocketNo () { return locketNo; }
//    
//    public void setLocketNo (CounterInfo _locketNo)
//    {
//        this.locketNo = _locketNo;
//    }
//
//    public void resetAttributes ()
//    {
//        systemId = -1;
//        validDays = 0;
//        
//        sysCreateDate = null;
//        sysCreator = null;
//        sysUpdateDate = null;
//        sysUpdater = null;
//        locketNo = null ;
//    }
//
//    
//
//    public Object getGeneratedUniqueData ()
//    {
//        return String.valueOf (systemId);
//    }
//}
