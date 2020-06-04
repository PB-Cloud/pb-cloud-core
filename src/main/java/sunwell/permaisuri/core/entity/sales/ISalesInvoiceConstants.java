/*
 * @File : ISalesInvoiceConstants.java	Created on January 12, 2008, 4:45 PM
 *
 * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
 * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
 */
package sunwell.permaisuri.core.entity.sales;

/**
 * Interface yg mendeklarasikan tipe referensi (reference type) yg digunakan
 *  oleh kelas SalesInvoice.
 * <BR><BR>
 * Note: Yang dimaksud dgn tipe referensi adalah dokumen acuan atau sumber atau
 *  asal muasal dibuatnya suatu sales invoice.
 * 
 * @author Irfin A
 */
public interface ISalesInvoiceConstants 
{
    public static final int REF_TYPE_UNKNOWN = -1;
    public static final int REF_TYPE_SALESORDER = 0;
    public static final int REF_TYPE_DELIVERYORDER = 1;
    public static final int REF_TYPE_BEGINNING_BALANCE = 2;
}
