
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package net.dsd.sce.transmitirdigesarequest;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://sce.dsd.net/TransmitirDigesaRequest".equals(namespaceURI) &&
                  "UsuarioType".equals(typeName)){
                   
                            return  net.dsd.sce.transmitirdigesarequest.UsuarioType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sce.dsd.net/TransmitirDigesaRequest".equals(namespaceURI) &&
                  "Frm001Type".equals(typeName)){
                   
                            return  net.dsd.sce.transmitirdigesarequest.Frm001Type.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sce.dsd.net/TransmitirDigesaRequest".equals(namespaceURI) &&
                  "MensajeType".equals(typeName)){
                   
                            return  net.dsd.sce.transmitirdigesarequest.MensajeType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sce.dsd.net/TransmitirDigesaRequest".equals(namespaceURI) &&
                  "Dgs015ProductoType".equals(typeName)){
                   
                            return  net.dsd.sce.transmitirdigesarequest.Dgs015ProductoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sce.dsd.net/TransmitirDigesaRequest".equals(namespaceURI) &&
                  "Dgs015Type".equals(typeName)){
                   
                            return  net.dsd.sce.transmitirdigesarequest.Dgs015Type.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    