/*
 * SalesOrder.java
 *
 * Created on September 4, 2007, 5:28 PM
 */
package sunwell.permaisuri.core.entity.sales;

import java.io.Serializable;


import java.sql.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import sunwell.permaisuri.core.entity.cred.UserCredential;
import sunwell.permaisuri.core.entity.customer.Customer;
//import sunwell.permaisuri.core.entity.util.CounterInfo;

import javax.persistence.*;

@Entity
@Table (name = "salesinvoice")
public class SalesInvoice 
{
    @Id
    @Column( name = "systemid")
    @SequenceGenerator (name = "salesinvoice_id_si_seq", sequenceName = "salesinvoice_id_si_seq", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "salesinvoice_id_si_seq")
    private long systemId;
    
    @NotNull(message="{error_no_customer}")
    @ManyToOne
    @JoinColumn( name = "cust" )    
    private Customer customer;
    
    @OneToMany( mappedBy = "parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER )
    @Fetch(FetchMode.SELECT)
    private List<SalesInvoiceItem> items ;
    
    @NotNull(message="{error_no_issue_date}")
    @Column( name = "issuedate" )
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)    
    private Calendar issueDate = Calendar.getInstance();
    
    @Column( name = "status_delivery")
    private int deliveryStatus ;
    
    @Column( name = "status_canceled" )
    private int canceledStatus = 0;
    
    @Column( name = "status_payment" )
    private int paymentStatus = 0;
    
    @Column( name = "misc_charge")
    private double miscCharge = 0.0;
    
    @Column( name = "misc_charge_memo" )
    private String miscChargeMemo = "";
    
//    @Column( name = "invoiced" )
//    private boolean invoiced ;
    
    @Column( name = "memo" )
    private String memo = "";
    
    @Column( name = "vat" )
    private double vat = 0.0;
    
    @Column( name = "vat_inclusive" )
    private boolean vatInclusive = false;
        
    @Column( name = "shipping_line" )
    private Integer shippingLine = 0;
    
    @Column( name = "promocode_used" )
    private Integer promoCodeUsed ;
    
    @Column(name="disc")
    private double discount;
    
    @Column(name="disc_memo")
    private String discountMemo;
    
    @NotNull(message="{no_si_no_specified}")
    @Column( name = "invoice_no", unique = true)
    private String invoiceNo;
    
    @Column(name="payment_type")
    private int paymentType;
    
    @Column(name="payment_details")
    private String paymentDetail;
    
    @Column(name="payment_amount") 
    private double paymentAmount;
    
    @Column(name="no_fak_pajak")
    private String noFakPajak;
    
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
    public SalesInvoice ()
    {
    }

    public SalesInvoice (long _idSO)
    {
//       resetAttributes ();
       systemId = _idSO;
    }
    
    public long getSystemId () { return systemId; }
    
    public void setSystemId (long _id)
    {
        this.systemId = _id;
    }
    
    public String getInvoiceNo () { return invoiceNo; }

    public void setInvoiceNo (String _no)
    {
        this.invoiceNo = (_no != null) ? _no : "";
    }

    public Calendar getIssueDate () { return issueDate; }

    public void setIssueDate (Calendar _date)
    {
        this.issueDate = _date;
    }

    public int getDeliveryStatus () { return deliveryStatus; }

    public void setDeliveryStatus (int _d)
    {
        this.deliveryStatus = _d;
    }

    public double getMiscCharges () { return miscCharge; }

    public void setMiscCharges (double m_misc_charges)
    {
        this.miscCharge = m_misc_charges;
    }

    public String getMiscChargesMemo () { return miscChargeMemo; }

    public void setMiscChargesMemo (String _misc_charges_memo)
    {
        this.miscChargeMemo = (_misc_charges_memo != null) ? _misc_charges_memo : "";
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
        if (_vs != SalesOrder.VS_OPEN && _vs != SalesOrder.VS_CLOSED && _vs != SalesOrder.VS_CANCELED)
            this.canceledStatus = SalesOrder.VS_CANCELED;
        else
            this.canceledStatus = _vs;
    }
                
    public Customer getCustomer () { return customer; }

    public void setCustomer (Customer m_cust)
    {
        this.customer = m_cust;
    }
    
    
    public List<SalesInvoiceItem> getItems () 
    { 
        return items; 
    }
    
    public void setItems (List<SalesInvoiceItem> _items)
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
//    public void setSysCreateDate (Calendar m_user_createdate)
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
//    public void setSysUodateDate (Calendar _date)
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

	public int getPaymentType ()
	{
		return paymentType;
	}

	public void setPaymentType (int _paymentType)
	{
		paymentType = _paymentType;
	}

	public String getPaymentDetail ()
	{
		return paymentDetail;
	}

	public void setPaymentDetail (String _paymentDetail)
	{
		paymentDetail = _paymentDetail;
	}

	public double getPaymentAmount ()
	{
		return paymentAmount;
	}

	public void setPaymentAmount (double _paymentAmount)
	{
		paymentAmount = _paymentAmount;
	}

	public String getNoFakPajak ()
	{
		return noFakPajak;
	}

	public void setNoFakPajak (String _noFakPajak)
	{
		noFakPajak = _noFakPajak;
	}

	  
}
