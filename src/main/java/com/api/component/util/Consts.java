
//All members of this class are immutable. 
package com.api.component.util;


public final class Consts {

	  public static final String API_NAME ="API" ;

	  public static final String SERVICE_NAME ="Services" ;
	  public static final String PARAM_NAME ="name" ;
	  public static final String  DIGITAL_OCEAN_URI ="/api/v1/components.json" ;
	  public static final String  DIGITAL_OCEAN_HOST ="https://s2k7tnzlhrpw.statuspage.io" ;
	  public static final String PARAM_OP ="operational" ;
	  public static final String PARAM_DP ="degraded_performance" ;
	  public static final String PARAM_PO ="partial_outage" ;
	  public static final String PARAM_MO ="major_outage" ;
	  public static final String COMPONENT_ERROR_CODE_1 ="COMPONENT-ERROR-CODE-1" ;
	  public static final String COMPONENT__ERROR_CODE_2 ="COMPONENT-ERROR-CODE-2" ;
	  public static final String COMPONENT__ERROR_REQ_MEG ="Request not Valid" ;
	  public static final String COMPONENT__ERROR_RES_MEG ="Response not valid" ;
	  public static final String COMPONENT__ERROR_REQ_MEG_DESC ="Invalid Request Param not supported" ;
	  public static final String COMPONENT__ERROR_RES_MEG_DESC ="Invalid Resposen Param not supported" ;
	  
	
	
	//this prevents even the native class from 
	  private Consts(){
	    	    throw new AssertionError();
	  }

}
