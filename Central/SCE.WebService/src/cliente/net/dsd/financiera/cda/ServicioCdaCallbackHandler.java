
/**
 * ServicioCdaCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package net.dsd.financiera.cda;

    /**
     *  ServicioCdaCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicioCdaCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicioCdaCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicioCdaCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for pagarCda method
            * override this method for handling normal response from pagarCda operation
            */
           public void receiveResultpagarCda(
                    net.dsd.financiera.cda.ServicioCdaStub.PagarCdaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pagarCda operation
           */
            public void receiveErrorpagarCda(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for consultarCda method
            * override this method for handling normal response from consultarCda operation
            */
           public void receiveResultconsultarCda(
                    net.dsd.financiera.cda.ServicioCdaStub.ConsultarCdaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from consultarCda operation
           */
            public void receiveErrorconsultarCda(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listarCda method
            * override this method for handling normal response from listarCda operation
            */
           public void receiveResultlistarCda(
                    net.dsd.financiera.cda.ServicioCdaStub.ListarCdaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listarCda operation
           */
            public void receiveErrorlistarCda(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for generarCda method
            * override this method for handling normal response from generarCda operation
            */
           public void receiveResultgenerarCda(
                    net.dsd.financiera.cda.ServicioCdaStub.GenerarCdaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from generarCda operation
           */
            public void receiveErrorgenerarCda(java.lang.Exception e) {
            }
                


    }
    