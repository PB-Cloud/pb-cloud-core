///*
// * SOBonusItem.java
// *
// * Created on April 28, 2009, 11:17:39 PM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//
//import java.sql.*;
//import javax.persistence.*;
///**
// *
// * @author Irfin A
// * @version 1.0 - Apr 28, 2009 ; initial version
// * @version 1.5 - Mar 13, 2010 ; perubahan implementasi interface dari PersistentObject
// *                  ke EntityObject.
// */
//@Entity
//@Table( name = "salespackagebonusitem" )
//@IdClass( SalesPackageBonusItemPK.class )
//public class SalesPackageBonusItem 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_sp" )
//    private SalesPackage m_salesPackage = null;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Item m_item = null;
//    
//    @Column( name = "qty" )
//    private double m_qty = 0;
//    
//    @Column( name = "note" )
//    private String m_note;
//
//    private boolean m_populatedFromDB = false;
//
//    /**
//     * @return the m_aslesPackage
//     */
//    public SalesPackage getSalesPackage () { return m_salesPackage; }
//
//    /**
//     * @param m_so the m_aslesPackage to set
//     */
//    public void setSalesPackage (SalesPackage _sp )
//    {
//        this.m_salesPackage = _sp;
//    }
//
//    /**
//     * @return the m_item
//     */
//    public Item getItem () { return m_item; }
//
//    /**
//     * @param m_item the m_item to set
//     */
//    public void setItem (Item m_item)
//    {
//        this.m_item = m_item;
//    }
//
//    /**
//     * @return the m_qty
//     */
//    public double getQty () { return m_qty; }
//
//    /**
//     * @param m_qty the m_qty to set
//     */
//    public void setQty (double m_qty)
//    {
//        this.m_qty = m_qty;
//    }
//
//    /**
//     * @return the m_note
//     */
//    public String getNote () { return m_note; }
//
//    /**
//     * @param m_note the m_note to set
//     */
//    public void setNote (String _note)
//    {
//        this.m_note = (_note != null) ? _note : "";
//    }
//    
//}
