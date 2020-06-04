/*
 * SalesOrder.java
 *
 * Created on September 4, 2007, 5:28 PM
 */
package sunwell.permaisuri.core.entity.sales;

import java.io.Serializable;



import java.sql.*;
import java.util.*;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import sunwell.permaisuri.core.entity.cred.UserCredential;
import sunwell.permaisuri.core.entity.customer.Customer;
//import sunwell.permaisuri.core.entity.hr.Employee;
//import sunwell.permaisuri.core.entity.util.CounterInfo;

import javax.persistence.*;
/**
 * Kelas yang merepresentasikan sebuah Sales Order.
 *
 * @author Irfin A
 *
 * @version 1.0 - September 4, 2007 ; initial version.
 * @version 2.0 - April 30, 2009 ; penambahan atribut SOBonusItem utk fitur bonus item.
 * @version 2.5 - March 10, 2010 ; perubahan implementasi interface ke EntityObject dan
                  ITraceableBusinessObject.
 * @version 2.6 - May 7, 2015 ; tambahan atribut m_salesPerson.
 */
@Entity
@Table (name = "salesorder")
public class SalesOrder 
{
    /**
     * Flag Delivery-Status dari Sales Order ini.
     */
    public static final int DS_UNDELIVERED = 0;
    public static final int DS_FULLY_DELIVERED = 1;
    public static final int DS_PARTIALLY_DELIVERED = 2;
    
    /**
     * Flag status reservasi
     */
    public static final int RESERVATION_PARTIAL_OR_NONE = 0;
    public static final int RESERVATION_FULL = 1;
    
    /**
     * Flag Validity-Status dari Sales Order ini.
     */
    public static final int VS_OPEN = 0;
    public static final int VS_CLOSED = 1;
    public static final int VS_CANCELED = 2;
    
    /**
     * Flag status payment dari Sales Order ini.
     */
    public static final int PAYMENT_PAID = 0;
    public static final int PAYMENT_UNPAID = 1;
    
    /** PRIMARY KEY ; auto-increment */
    @Id
    @Column( name = "systemid")
    @SequenceGenerator (name = "salesorder_id_so_seq", sequenceName = "salesorder_id_so_seq", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "salesorder_id_so_seq")
    private long systemId;
    
    @NotNull(message="{error_no_customer}")
    @ManyToOne
    @JoinColumn( name = "cust" )    
    private Customer customer;
    
    @NotNull(message="{error_no_issue_date}")
    @Column( name = "issuedate" )
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)    
    private Calendar issueDate = Calendar.getInstance();
        
    @OneToMany( mappedBy = "parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER )
    @Fetch (FetchMode.SELECT)
    private List<SalesOrderItem> items ;    
    
    @Column( name = "status_delivery")
    private int deliveryStatus ;
    
    @Column( name = "misc_charge")
    private double miscCharge = 0.0;
    
    @Column( name = "misc_charge_memo" )
    private String miscChargesMemo = "";
    
    @Column( name = "memo" )
    private String memo = "";
    
    @Column( name = "vat" )
    private double vat = 0.0;
    
    @Column( name = "vat_inclusive" )
    private boolean vatInclusive = false;
    
    @Column( name = "status_canceled" )
    private int canceledStatus;
    
    @Column( name = "status_payment" )
    private int paymentStatus;
    
    @Column( name = "shipping_line" )
    private Integer shippingLine ;
    
    @Column( name = "promocode_used" )
    private Integer promoCodeUsed ;
    
    @Column(name="disc")
    private double discount;
    
    @Column(name="disc_memo")
    private String discountMemo;
    
//    @ManyToOne
//    @JoinColumn( name = "bo_creator" )
//    private UserCredential sysCreator;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_updater" )
//    private UserCredential sysUpdater;
//    
//    @Column( name = "bo_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)  
//    private Calendar sysCreateDate;
//    
//    @Column( name = "bo_updatedate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)      
//    private Calendar sysUpdateDate;
    
        
    /** Creates a new instance of SalesOrder */
    public SalesOrder ()
    {
    }

    public SalesOrder (long _idSO)
    {
//       resetAttributes ();
       systemId = _idSO;
    }
    
    public long getSystemId () { return systemId; }
    
    public void setSystemId (long _id)
    {
        this.systemId = _id;
    }

    public int getDeliveryStatus () { return deliveryStatus; }

    public void setDeliveryStatus (int _delivered)
    {
        this.deliveryStatus = _delivered;
    }

    public double getMiscCharges () { return miscCharge; }

    public void setMiscCharges (double m_misc_charges)
    {
        this.miscCharge = m_misc_charges;
    }

    public String getMiscChargesMemo () { return miscChargesMemo; }

    public void setMiscChargesMemo (String _misc_charges_memo)
    {
        this.miscChargesMemo = (_misc_charges_memo != null) ? _misc_charges_memo : "";
    }


    public String getMemo () { return memo; }

    public void setMemo (String _memo)
    {
        this.memo = (_memo != null) ? _memo : "";
    }

    public double getVAT () { return vat; }

    public void setVAT (double _vat)
    {
        this.vat = _vat;
    }

    public boolean isVATInclusive () { return vatInclusive; }

    public void setVATInclusive (boolean m_vat_inclusive)
    {
        this.vatInclusive = m_vat_inclusive;
    }

    public int getCanceledStatus () { return canceledStatus; }

    /**
     * @param _vs harus bernilai salah satu dari konstanta {@link #VS_OPEN},
     *  {@link #VS_CLOSED}, atau {@link #VS_CANCELED}. Jika nilai _vs bukan salah
     *  satu dari ketiga konstanta tersebut, maka nilai _vs akan di-override dgn
     *  nilai {@link #VS_CANCELED}.
     */
    public void setCanceledStatus (int _vs)
    {
        if (_vs != VS_OPEN && _vs != VS_CLOSED && _vs != VS_CANCELED)
            this.canceledStatus = VS_CANCELED;
        else
            this.canceledStatus = _vs;
    }
                
    public Customer getCustomer () { return customer; }

    public void setCustomer (Customer m_cust)
    {
        this.customer = m_cust;
    }
    
    public List<SalesOrderItem> getItems () 
    { 
        return items; 
    }
    
    public void setItems (List<SalesOrderItem> _items)
    {
        items = _items;
    }
    
//    public UserCredential getSysCreator ()
//    {
//        return sysCreator;
//    }
//
//    public void setSysCreator (UserCredential _userCreate)
//    {
//        sysCreator = _userCreate;
//    }
//
//    public Calendar getSysCreateDate () { return sysCreateDate; }
//
//    protected void setSysCreateDate (Calendar m_user_createdate)
//    {
//        sysCreateDate = m_user_createdate;
//    }
//
//    public UserCredential getSysUpdater ()
//    {
//        return sysUpdater;
//    }
//
//    public void setSysUpdater (UserCredential m_userModify)
//    {
//        sysUpdater = m_userModify;
//    }
//
//    public Calendar getSysUpdateDate () { return sysUpdateDate; }
//
//    protected void setSysUodateDate (Calendar _date)
//    {
//        sysUpdateDate = _date;
//    }

	public int getPaymentStatus ()
	{
		return paymentStatus;
	}

	public void setPaymentStatus (int _paymentStatus)
	{
		paymentStatus = _paymentStatus;
	}

	public Integer getShippingLine ()
	{
		return shippingLine;
	}

	public void setShippingLine (Integer _shippingLine)
	{
		shippingLine = _shippingLine;
	}

	public Integer getPromoCodeUsed ()
	{
		return promoCodeUsed;
	}

	public void setPromoCodeUsed (Integer _promoCodeUsed)
	{
		promoCodeUsed = _promoCodeUsed;
	}
	
	public double getDiscount ()
	{
		return discount;
	}

	public void setDiscount (double _discount)
	{
		discount = _discount;
	}  

	public String getDiscountMemo ()
	{
		return discountMemo;
	}

	public void setDiscountMemo (String _discountMemo)
	{
		discountMemo = _discountMemo;
	}

	public Calendar getIssueDate ()
	{
		return issueDate;
	}

	public void setIssueDate (Calendar _issueDate)
	{
		issueDate = _issueDate;
	}

	  
}
