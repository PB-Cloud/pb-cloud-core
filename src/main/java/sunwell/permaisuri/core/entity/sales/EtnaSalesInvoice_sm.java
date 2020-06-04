//package sunwell.xrp.sales;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Arrays;
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import sunwell.xrp.db.DBConnection;
//import sunwell.xrp.sales.payment.SalesPayment;
//import sunwell.xrp.sales.ret.SalesReturn;
//import sunwell.xrp.util.MainAppRuntime;
//
//@Entity
//@Table(name="etnasalesinvoice")
//public class EtnaSalesInvoice_sm
//  extends SalesInvoice
//{
//  public static final int PAYMENT_TYPE_CASH = 0;
//  public static final int PAYMENT_TYPE_CREDIT = 1;
//  @OneToMany(mappedBy="m_etnaSI", cascade={javax.persistence.CascadeType.ALL})
//  List<BonusItemUsed> m_listBonusIU;
//  @Transient
//  private BonusItemUsed[] m_arrBonusIU;
//  @Column(name="payment_type")
//  private int m_payment_type;
//  private boolean m_populatedFromDB = false;
//  
//  public EtnaSalesInvoice_sm()
//  {
//    this(-1);
//  }
//  
//  public EtnaSalesInvoice_sm(int _id)
//  {
//    super(_id);
//    this.m_payment_type = 1;
//    this.m_arrBonusIU = null;
//    this.m_populatedFromDB = false;
//  }
//  
//  public int getBonusItemCount()
//  {
//    if (this.m_arrBonusIU == null) {
//      if (this.m_listBonusIU != null) {
//        this.m_arrBonusIU = ((BonusItemUsed[])this.m_listBonusIU.toArray(new BonusItemUsed[0]));
//      }
//    }
//    return this.m_arrBonusIU == null ? 0 : this.m_arrBonusIU.length;
//  }
//  
//  public BonusItemUsed getBonusItemAt(int _position)
//  {
//    if (this.m_arrBonusIU == null) {
//      if (this.m_listBonusIU != null) {
//        this.m_arrBonusIU = ((BonusItemUsed[])this.m_listBonusIU.toArray(new BonusItemUsed[0]));
//      }
//    }
//    if (this.m_arrBonusIU == null) {
//      return null;
//    }
//    if ((_position < 0) || (_position > this.m_arrBonusIU.length - 1)) {
//      return null;
//    }
//    return this.m_arrBonusIU[_position];
//  }
//  
//  public BonusItemUsed[] getBonusItems()
//  {
//    if (this.m_arrBonusIU == null) {
//      if (this.m_listBonusIU != null) {
//        this.m_arrBonusIU = ((BonusItemUsed[])this.m_listBonusIU.toArray(new BonusItemUsed[0]));
//      }
//    }
//    return this.m_arrBonusIU;
//  }
//  
//  public void setBonusItems(BonusItemUsed[] _arrBIU)
//  {
//    this.m_arrBonusIU = _arrBIU;
//    if (this.m_arrBonusIU != null)
//    {
//      for (int i = 0; i < this.m_arrBonusIU.length; i++) {
//        this.m_arrBonusIU[i].setEtnaSalesInvoice(this);
//      }
//      this.m_listBonusIU = Arrays.asList(this.m_arrBonusIU);
//    }
//  }
//  
//  public int getPaymentType()
//  {
//    return this.m_payment_type;
//  }
//  
//  public void setPaymentType(int _payment_type)
//  {
//    this.m_payment_type = _payment_type;
//  }
//  
//  public void resetAttributes()
//  {
//    super.resetAttributes();
//    
//    this.m_populatedFromDB = false;
//    this.m_payment_type = 1;
//    this.m_arrBonusIU = null;
//  }
//  
//  public boolean isPopulatedFromDB()
//  {
//    return this.m_populatedFromDB;
//  }
//  
//  public static Double calculateDueAmount(int _idSI)
//    throws SQLException
//  {
//    double invAmount = querySalesAmountFor(_idSI);
//    
//    double returnValue = 0.0D;
//    SalesReturn[] arrRetur = SalesReturn.queryForSalesInvoice(_idSI);
//    if (arrRetur != null) {
//      for (int t = 0; t < arrRetur.length; t++)
//      {
//        SalesReturn sr = arrRetur[t];
//        returnValue += sr.calculateReturnAmount();
//      }
//    }
//    double sdhBayar = SalesPayment.calculateTotalPaymentDone(_idSI);
//    
//    return Double.valueOf(invAmount - returnValue - sdhBayar);
//  }
//  
//  public static EtnaSalesInvoice_sm queryByReference(int _refType, int _refID)
//    throws SQLException
//  {
//    SalesInvoice si = null;
//    EtnaSalesInvoice_sm retval = null;
//    BonusItemUsed[] arrBIU = null;
//    String sql = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//    try
//    {
//      si = SalesInvoice.queryByReference(_refType, _refID);
//      EtnaSalesInvoice_sm localEtnaSalesInvoice1;
//      if (si == null) {
//        return null;
//      }
//      sql = "SELECT payment_type FROM etnasalesinvoice WHERE id_si = " + si.getID();
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement(1003, 1007);
//      rs = stmt.executeQuery(sql);
//      if (!rs.next()) {
//        return null;
//      }
//      retval = new EtnaSalesInvoice_sm();
//      retval.m_populatedFromDB = true;
//      retval.setID(si.getID());
//      retval.setPaymentType(rs.getInt(1));
//      
//      retval.setAppliedDiscounts(si.getAppliedDiscounts());
//      retval.setCustomer(si.getCustomer());
//      retval.setDuedate(si.getDuedate());
//      retval.setIssueDateTime(si.getIssueDateTime());
//      retval.setMemo(si.getMemo());
//      retval.setMiscCharges(si.getMiscCharges());
//      retval.setMiscChargesMemo(si.getMiscChargesMemo());
//      retval.setPaid(si.isPaid());
//      retval.setReference(si.getReferenceType(), si.getReferenceID());
//      retval.setSalesItems(si.getSalesItems());
//      retval.setMiscCharges(si.getMiscCharges());
//      retval.setMiscChargesMemo(si.getMiscChargesMemo());
//      retval.setVAT(si.getVAT());
//      retval.setVATInclusive(si.isVATInclusive());
//      retval.setPrinted(si.isPrinted());
//      retval.setNumPrinted(si.getPrintedCount());
//      retval.setPrintDate(si.getPrintDate());
//      retval.setLastPrintBy(si.getLastPrintBy());
//      
//      retval.setBusinessObjCreator(si.getBusinessObjCreator());
//      retval.setBusinessObjCreateDate(si.getBusinessObjCreateDate());
//      retval.setBusinessObjUpdater(si.getBusinessObjUpdater());
//      retval.setBusinessObjUpdateDate(si.getBusinessObjUpdateDate());
//      
//      arrBIU = BonusItemUsed.getAllBySalesInvoiceID(si.getID());
//      retval.setBonusItems(arrBIU);
//      
//      return retval;
//    }
//    catch (SQLException e)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw e;
//    }
//    catch (Exception w)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw new SQLException(w);
//    }
//    finally
//    {
//      si = null;
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException4) {}
//      }
//    }
//  }
//  
//  public boolean populateAttributes()
//    throws SQLException
//  {
//    Statement stmt = null;
//    
//    this.m_populatedFromDB = false;
//    try
//    {
//      boolean bool = super.populateAttributes();
//      boolean bool1;
//      if (!bool) {
//        return false;
//      }
//      StringBuilder sql = new StringBuilder();
//      sql.append("SELECT payment_type FROM etnasalesinvoice WHERE id_si = " + getID());
//      
//        System.out.println ("SQL: " + sql.toString ());
//      
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement(1003, 1007);
//      ResultSet rs = stmt.executeQuery(sql.toString());
//      rs.next();
//      
//      setPaymentType(rs.getInt(1));
//      
//      this.m_arrBonusIU = BonusItemUsed.getAllBySalesInvoiceID(getID());
//      
//      this.m_populatedFromDB = true;
//      return this.m_populatedFromDB;
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw e;
//    }
//    catch (Exception w)
//    {
//      w.printStackTrace();
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw w;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException3) {}
//      }
//    }
//  }
//  
//  public static boolean updatePaymentTypeInDB(int _idSI, int _paymentType)
//    throws SQLException
//  {
//    Statement stmt = null;
//    String sql = null;
//    
//    sql = "UPDATE etnasalesinvoice SET payment_type = " + _paymentType + " " + "WHERE id_si = " + _idSI;
//    try
//    {
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement();
//      int n = stmt.executeUpdate(sql);
//      
//      return n > 0;
//    }
//    catch (SQLException e)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw e;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException2) {}
//      }
//    }
//  }
//  
//  public static double querySalesAmountFor(int _idSI)
//    throws SQLException
//  {
//    Statement stmt = null;
//    
//    String query = "SELECT SumEtnaSalesInvoice(" + _idSI + ") ";
//    try
//    {
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement(1003, 1007);
//      
//      ResultSet rs = stmt.executeQuery(query);
//      double d;
//      if (!rs.next()) {
//        return 0.0D;
//      }
//      return rs.getDouble(1);
//    }
//    catch (SQLException e)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw e;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException3) {}
//      }
//    }
//  }
//  
//  public boolean insertToDB()
//    throws SQLException
//  {
//    Statement stmt = null;
//    try
//    {
//      boolean bool = super.insertToDB();
//      
//      int idSI = getID();
//      
//      String query = "INSERT INTO etnasalesinvoice (id_si, payment_type) VALUES ('" + idSI + "', '" + this.m_payment_type + "')";
//      
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement();
//      int n = stmt.executeUpdate(query);
//      int i;
//      if (this.m_arrBonusIU != null) {
//        for (i = 0; i < this.m_arrBonusIU.length; i++) {
//          this.m_arrBonusIU[i].insertToDB();
//        }
//      }
//      return bool && (n > 0);
//    }
//    catch (SQLException e)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw e;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException2) {}
//      }
//    }
//  }
//  
//  public boolean updateToDB()
//    throws SQLException
//  {
//    Statement stmt = null;
//    String sql = null;
//    try
//    {
//      boolean bool = super.updateToDB();
//      
//      BonusItemUsed.deleteAllBySalesInvoiceID(getID());
//      
//      sql = "UPDATE etnasalesinvoice SET   payment_type = '" + this.m_payment_type + "' " + "WHERE id_si = " + getID();
//      
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement();
//      int n = stmt.executeUpdate(sql);
//      int i;
//      if (this.m_arrBonusIU != null) {
//        for (i = 0; i < this.m_arrBonusIU.length; i++) {
//          this.m_arrBonusIU[i].insertToDB();
//        }
//      }
//      return (bool) && (n > 0) ;
//    }
//    catch (SQLException e)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw e;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException2) {}
//      }
//    }
//  }
//  
//  public boolean deleteFromDB()
//    throws SQLException
//  {
//    Statement stmt = null;
//    String query = null;
//    try
//    {
//      boolean bool = super.deleteFromDB();
//      
//      query = "DELETE FROM etnasalesinvoice WHERE id_si = " + getID();
//      
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement();
//      int n = stmt.executeUpdate(query);
//      
//      BonusItemUsed.deleteAllBySalesInvoiceID(getID());
//      
//      return bool;
//    }
//    catch (SQLException x)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw x;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException2) {}
//      }
//    }
//  }
//  
//  public boolean isExistsInDB()
//    throws SQLException
//  {
//    Statement stmt = null;
//    
//    String sql = "SELECT COUNT(*) FROM etnasalesinvoice WHERE id_si = " + getID();
//    try
//    {
//      stmt = MainAppRuntime.getDBConnection().getConnection().createStatement(1003, 1007);
//      ResultSet rs = stmt.executeQuery(sql);
//      boolean bool;
//      if (!rs.next()) {
//        return false;
//      }
//      return rs.getInt(1) > 0;
//    }
//    catch (SQLException x)
//    {
//      MainAppRuntime.getDBConnection().getConnection().rollback();
//      throw x;
//    }
//    finally
//    {
//      if (stmt != null) {
//        try
//        {
//          stmt.close();
//        }
//        catch (SQLException localSQLException3) {}
//      }
//    }
//  }
//}
