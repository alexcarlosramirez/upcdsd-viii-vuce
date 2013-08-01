
/**
 * ServicioBancaCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package net.dsd.financiera.banca;

    /**
     *  ServicioBancaCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicioBancaCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicioBancaCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicioBancaCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for listarCuentasPorUsuarioBanco method
            * override this method for handling normal response from listarCuentasPorUsuarioBanco operation
            */
           public void receiveResultlistarCuentasPorUsuarioBanco(
                    net.dsd.financiera.banca.ServicioBancaStub.ListarCuentasPorUsuarioBancoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listarCuentasPorUsuarioBanco operation
           */
            public void receiveErrorlistarCuentasPorUsuarioBanco(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listarBancosPorUsuario method
            * override this method for handling normal response from listarBancosPorUsuario operation
            */
           public void receiveResultlistarBancosPorUsuario(
                    net.dsd.financiera.banca.ServicioBancaStub.ListarBancosPorUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listarBancosPorUsuario operation
           */
            public void receiveErrorlistarBancosPorUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for autenticar method
            * override this method for handling normal response from autenticar operation
            */
           public void receiveResultautenticar(
                    net.dsd.financiera.banca.ServicioBancaStub.AutenticarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from autenticar operation
           */
            public void receiveErrorautenticar(java.lang.Exception e) {
            }
                


    }
    