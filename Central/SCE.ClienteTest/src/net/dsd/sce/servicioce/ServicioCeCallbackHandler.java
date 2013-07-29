
/**
 * ServicioCeCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package net.dsd.sce.servicioce;

    /**
     *  ServicioCeCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicioCeCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicioCeCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicioCeCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for transmitirNroExpediente method
            * override this method for handling normal response from transmitirNroExpediente operation
            */
           public void receiveResulttransmitirNroExpediente(
                    net.dsd.sce.servicioce.ServicioCeStub.TransmitirResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from transmitirNroExpediente operation
           */
            public void receiveErrortransmitirNroExpediente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for transmitirPago method
            * override this method for handling normal response from transmitirPago operation
            */
           public void receiveResulttransmitirPago(
                    net.dsd.sce.servicioce.ServicioCeStub.TransmitirResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from transmitirPago operation
           */
            public void receiveErrortransmitirPago(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for transmitirOrden method
            * override this method for handling normal response from transmitirOrden operation
            */
           public void receiveResulttransmitirOrden(
                    net.dsd.sce.servicioce.ServicioCeStub.TransmitirResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from transmitirOrden operation
           */
            public void receiveErrortransmitirOrden(java.lang.Exception e) {
            }
                


    }
    