
/**
 * TransmitirDrRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package net.dsd.sce.transmitirdigesarequest;
            

            /**
            *  TransmitirDrRequest bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class TransmitirDrRequest
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sce.dsd.net/TransmitirDigesaRequest",
                "TransmitirDrRequest",
                "ns2");

            

                        /**
                        * field for Mensaje
                        */

                        
                                    protected net.dsd.sce.transmitirdigesarequest.MensajeType localMensaje ;
                                

                           /**
                           * Auto generated getter method
                           * @return net.dsd.sce.transmitirdigesarequest.MensajeType
                           */
                           public  net.dsd.sce.transmitirdigesarequest.MensajeType getMensaje(){
                               return localMensaje;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mensaje
                               */
                               public void setMensaje(net.dsd.sce.transmitirdigesarequest.MensajeType param){
                            
                                            this.localMensaje=param;
                                    

                               }
                            

                        /**
                        * field for DrEntidad
                        */

                        
                                    protected java.lang.String localDrEntidad ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDrEntidad(){
                               return localDrEntidad;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DrEntidad
                               */
                               public void setDrEntidad(java.lang.String param){
                            
                                            this.localDrEntidad=param;
                                    

                               }
                            

                        /**
                        * field for TipoDr
                        */

                        
                                    protected int localTipoDr ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getTipoDr(){
                               return localTipoDr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoDr
                               */
                               public void setTipoDr(int param){
                            
                                            this.localTipoDr=param;
                                    

                               }
                            

                        /**
                        * field for NombreArchivoAdjunto
                        */

                        
                                    protected java.lang.String localNombreArchivoAdjunto ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNombreArchivoAdjunto(){
                               return localNombreArchivoAdjunto;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NombreArchivoAdjunto
                               */
                               public void setNombreArchivoAdjunto(java.lang.String param){
                            
                                            this.localNombreArchivoAdjunto=param;
                                    

                               }
                            

                        /**
                        * field for Adjunto
                        */

                        
                                    protected javax.activation.DataHandler localAdjunto ;
                                

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getAdjunto(){
                               return localAdjunto;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Adjunto
                               */
                               public void setAdjunto(javax.activation.DataHandler param){
                            
                                            this.localAdjunto=param;
                                    

                               }
                            

                        /**
                        * field for Usuario
                        */

                        
                                    protected net.dsd.sce.transmitirdigesarequest.UsuarioType localUsuario ;
                                

                           /**
                           * Auto generated getter method
                           * @return net.dsd.sce.transmitirdigesarequest.UsuarioType
                           */
                           public  net.dsd.sce.transmitirdigesarequest.UsuarioType getUsuario(){
                               return localUsuario;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Usuario
                               */
                               public void setUsuario(net.dsd.sce.transmitirdigesarequest.UsuarioType param){
                            
                                            this.localUsuario=param;
                                    

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME);
               return factory.createOMElement(dataSource,MY_QNAME);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://sce.dsd.net/TransmitirDigesaRequest");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":TransmitirDrRequest",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "TransmitirDrRequest",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localMensaje==null){
                                                 throw new org.apache.axis2.databinding.ADBException("mensaje cannot be null!!");
                                            }
                                           localMensaje.serialize(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","mensaje"),
                                               xmlWriter);
                                        
                                    namespace = "http://sce.dsd.net/TransmitirDigesaRequest";
                                    writeStartElement(null, namespace, "drEntidad", xmlWriter);
                             

                                          if (localDrEntidad==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("drEntidad cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDrEntidad);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://sce.dsd.net/TransmitirDigesaRequest";
                                    writeStartElement(null, namespace, "tipoDr", xmlWriter);
                             
                                               if (localTipoDr==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("tipoDr cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTipoDr));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://sce.dsd.net/TransmitirDigesaRequest";
                                    writeStartElement(null, namespace, "nombreArchivoAdjunto", xmlWriter);
                             

                                          if (localNombreArchivoAdjunto==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNombreArchivoAdjunto);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://sce.dsd.net/TransmitirDigesaRequest";
                                    writeStartElement(null, namespace, "adjunto", xmlWriter);
                             
                                        
                                    if (localAdjunto!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localAdjunto, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for adjunto", ex);
                                       }
                                    } else {
                                         
                                             writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             
                                            if (localUsuario==null){
                                                 throw new org.apache.axis2.databinding.ADBException("usuario cannot be null!!");
                                            }
                                           localUsuario.serialize(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","usuario"),
                                               xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://sce.dsd.net/TransmitirDigesaRequest")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest",
                                                                      "mensaje"));
                            
                            
                                    if (localMensaje==null){
                                         throw new org.apache.axis2.databinding.ADBException("mensaje cannot be null!!");
                                    }
                                    elementList.add(localMensaje);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest",
                                                                      "drEntidad"));
                                 
                                        if (localDrEntidad != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDrEntidad));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("drEntidad cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest",
                                                                      "tipoDr"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTipoDr));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest",
                                                                      "nombreArchivoAdjunto"));
                                 
                                         elementList.add(localNombreArchivoAdjunto==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNombreArchivoAdjunto));
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest",
                                        "adjunto"));
                                
                            elementList.add(localAdjunto);
                        
                            elementList.add(new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest",
                                                                      "usuario"));
                            
                            
                                    if (localUsuario==null){
                                         throw new org.apache.axis2.databinding.ADBException("usuario cannot be null!!");
                                    }
                                    elementList.add(localUsuario);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static TransmitirDrRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            TransmitirDrRequest object =
                new TransmitirDrRequest();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"TransmitirDrRequest".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (TransmitirDrRequest)net.dsd.sce.transmitirdigesarequest.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","mensaje").equals(reader.getName())){
                                
                                                object.setMensaje(net.dsd.sce.transmitirdigesarequest.MensajeType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","drEntidad").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"drEntidad" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDrEntidad(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","tipoDr").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"tipoDr" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTipoDr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","nombreArchivoAdjunto").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNombreArchivoAdjunto(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","adjunto").equals(reader.getName())){
                                
                                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                        if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                             object.setAdjunto(null);
                                             reader.next();
                                        } else {
                                    
                                            object.setAdjunto(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                    
                                        }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://sce.dsd.net/TransmitirDigesaRequest","usuario").equals(reader.getName())){
                                
                                                object.setUsuario(net.dsd.sce.transmitirdigesarequest.UsuarioType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    