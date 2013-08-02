
/**
 * ServicioCeMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package net.dsd.sce.servicioce;

        /**
        *  ServicioCeMessageReceiverInOut message receiver
        */

        public class ServicioCeMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ServicioCeSkeleton skel = (ServicioCeSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("transmitirNroExpediente".equals(methodName)){
                
                net.dsd.sce.transmitirresponse.TransmitirResponse transmitirResponse3 = null;
	                        net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest wrappedParam =
                                                             (net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               transmitirResponse3 =
                                                   
                                                   
                                                         skel.transmitirNroExpediente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), transmitirResponse3, false, new javax.xml.namespace.QName("http://sce.dsd.net/ServicioCe/",
                                                    "transmitirNroExpediente"));
                                    } else 

            if("transmitirPago".equals(methodName)){
                
                net.dsd.sce.transmitirresponse.TransmitirResponse transmitirResponse5 = null;
	                        net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest wrappedParam =
                                                             (net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               transmitirResponse5 =
                                                   
                                                   
                                                         skel.transmitirPago(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), transmitirResponse5, false, new javax.xml.namespace.QName("http://sce.dsd.net/ServicioCe/",
                                                    "transmitirPago"));
                                    } else 

            if("transmitirOrden".equals(methodName)){
                
                net.dsd.sce.transmitirresponse.TransmitirResponse transmitirResponse7 = null;
	                        net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest wrappedParam =
                                                             (net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               transmitirResponse7 =
                                                   
                                                   
                                                         skel.transmitirOrden(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), transmitirResponse7, false, new javax.xml.namespace.QName("http://sce.dsd.net/ServicioCe/",
                                                    "transmitirOrden"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(net.dsd.sce.transmitirresponse.TransmitirResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(net.dsd.sce.transmitirresponse.TransmitirResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, net.dsd.sce.transmitirresponse.TransmitirResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(net.dsd.sce.transmitirresponse.TransmitirResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private net.dsd.sce.transmitirresponse.TransmitirResponse wrapTransmitirNroExpediente(){
                                net.dsd.sce.transmitirresponse.TransmitirResponse wrappedElement = new net.dsd.sce.transmitirresponse.TransmitirResponse();
                                return wrappedElement;
                         }
                    
                         private net.dsd.sce.transmitirresponse.TransmitirResponse wrapTransmitirPago(){
                                net.dsd.sce.transmitirresponse.TransmitirResponse wrappedElement = new net.dsd.sce.transmitirresponse.TransmitirResponse();
                                return wrappedElement;
                         }
                    
                         private net.dsd.sce.transmitirresponse.TransmitirResponse wrapTransmitirOrden(){
                                net.dsd.sce.transmitirresponse.TransmitirResponse wrappedElement = new net.dsd.sce.transmitirresponse.TransmitirResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest.class.equals(type)){
                
                           return net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (net.dsd.sce.transmitirresponse.TransmitirResponse.class.equals(type)){
                
                           return net.dsd.sce.transmitirresponse.TransmitirResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest.class.equals(type)){
                
                           return net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (net.dsd.sce.transmitirresponse.TransmitirResponse.class.equals(type)){
                
                           return net.dsd.sce.transmitirresponse.TransmitirResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest.class.equals(type)){
                
                           return net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (net.dsd.sce.transmitirresponse.TransmitirResponse.class.equals(type)){
                
                           return net.dsd.sce.transmitirresponse.TransmitirResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    