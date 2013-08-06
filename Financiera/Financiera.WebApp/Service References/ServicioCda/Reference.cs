﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión del motor en tiempo de ejecución:2.0.50727.5420
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Financiera.WebApp.ServicioCda {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="CdaType", Namespace="http://financiera.dsd.net/cda/")]
    [System.SerializableAttribute()]
    public partial class CdaType : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string cdaField;
        
        private double montoPagoField;
        
        private System.DateTime fechaGeneracionField;
        
        private System.DateTime fechaPagoField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false)]
        public string cda {
            get {
                return this.cdaField;
            }
            set {
                if ((object.ReferenceEquals(this.cdaField, value) != true)) {
                    this.cdaField = value;
                    this.RaisePropertyChanged("cda");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true)]
        public double montoPago {
            get {
                return this.montoPagoField;
            }
            set {
                if ((this.montoPagoField.Equals(value) != true)) {
                    this.montoPagoField = value;
                    this.RaisePropertyChanged("montoPago");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=2)]
        public System.DateTime fechaGeneracion {
            get {
                return this.fechaGeneracionField;
            }
            set {
                if ((this.fechaGeneracionField.Equals(value) != true)) {
                    this.fechaGeneracionField = value;
                    this.RaisePropertyChanged("fechaGeneracion");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=3)]
        public System.DateTime fechaPago {
            get {
                return this.fechaPagoField;
            }
            set {
                if ((this.fechaPagoField.Equals(value) != true)) {
                    this.fechaPagoField = value;
                    this.RaisePropertyChanged("fechaPago");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://financiera.dsd.net/cda/", ConfigurationName="ServicioCda.ServicioCdaSoap")]
    public interface ServicioCdaSoap {
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de encapsulador (GenerarCda) del mensaje GenerarCda no coincide con el valor predeterminado (generarCda).
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/cda/GenerarCda", ReplyAction="*")]
        Financiera.WebApp.ServicioCda.GenerarCda1 generarCda(Financiera.WebApp.ServicioCda.GenerarCda request);
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de encapsulador (PagarCda) del mensaje PagarCda no coincide con el valor predeterminado (pagarCda).
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/cda/PagarCda", ReplyAction="*")]
        Financiera.WebApp.ServicioCda.PagarCda1 pagarCda(Financiera.WebApp.ServicioCda.PagarCda request);
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de encapsulador (ListarCda) del mensaje ListarCda no coincide con el valor predeterminado (listarCda).
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/cda/ListarCda", ReplyAction="*")]
        Financiera.WebApp.ServicioCda.ListarCda1 listarCda(Financiera.WebApp.ServicioCda.ListarCda request);
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de encapsulador (ConsultarCda) del mensaje ConsultarCda no coincide con el valor predeterminado (consultarCda).
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/cda/ConsultarCda", ReplyAction="*")]
        Financiera.WebApp.ServicioCda.ConsultarCda1 consultarCda(Financiera.WebApp.ServicioCda.ConsultarCda request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="GenerarCda", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class GenerarCda {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public string codigoEntidad;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=1)]
        public string codigoEmpresa;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=2)]
        public double montopago;
        
        public GenerarCda() {
        }
        
        public GenerarCda(string codigoEntidad, string codigoEmpresa, double montopago) {
            this.codigoEntidad = codigoEntidad;
            this.codigoEmpresa = codigoEmpresa;
            this.montopago = montopago;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="GenerarCdaResponse", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class GenerarCda1 {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public Financiera.WebApp.ServicioCda.CdaType cda;
        
        public GenerarCda1() {
        }
        
        public GenerarCda1(Financiera.WebApp.ServicioCda.CdaType cda) {
            this.cda = cda;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="PagarCda", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class PagarCda {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public string cda;
        
        public PagarCda() {
        }
        
        public PagarCda(string cda) {
            this.cda = cda;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="PagarCdaResponse", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class PagarCda1 {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public Financiera.WebApp.ServicioCda.CdaType cda;
        
        public PagarCda1() {
        }
        
        public PagarCda1(Financiera.WebApp.ServicioCda.CdaType cda) {
            this.cda = cda;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="ListarCda", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class ListarCda {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public string codigoEmpresa;
        
        public ListarCda() {
        }
        
        public ListarCda(string codigoEmpresa) {
            this.codigoEmpresa = codigoEmpresa;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="ListarCdaResponse", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class ListarCda1 {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public Financiera.WebApp.ServicioCda.CdaType[] ListarCdaResult;
        
        public ListarCda1() {
        }
        
        public ListarCda1(Financiera.WebApp.ServicioCda.CdaType[] ListarCdaResult) {
            this.ListarCdaResult = ListarCdaResult;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="ConsultarCda", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class ConsultarCda {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public string cda;
        
        public ConsultarCda() {
        }
        
        public ConsultarCda(string cda) {
            this.cda = cda;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="ConsultarCdaResponse", WrapperNamespace="http://financiera.dsd.net/cda/", IsWrapped=true)]
    public partial class ConsultarCda1 {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://financiera.dsd.net/cda/", Order=0)]
        public Financiera.WebApp.ServicioCda.CdaType cda;
        
        public ConsultarCda1() {
        }
        
        public ConsultarCda1(Financiera.WebApp.ServicioCda.CdaType cda) {
            this.cda = cda;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    public interface ServicioCdaSoapChannel : Financiera.WebApp.ServicioCda.ServicioCdaSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    public partial class ServicioCdaSoapClient : System.ServiceModel.ClientBase<Financiera.WebApp.ServicioCda.ServicioCdaSoap>, Financiera.WebApp.ServicioCda.ServicioCdaSoap {
        
        public ServicioCdaSoapClient() {
        }
        
        public ServicioCdaSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ServicioCdaSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioCdaSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioCdaSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioCda.GenerarCda1 Financiera.WebApp.ServicioCda.ServicioCdaSoap.generarCda(Financiera.WebApp.ServicioCda.GenerarCda request) {
            return base.Channel.generarCda(request);
        }
        
        public Financiera.WebApp.ServicioCda.CdaType generarCda(string codigoEntidad, string codigoEmpresa, double montopago) {
            Financiera.WebApp.ServicioCda.GenerarCda inValue = new Financiera.WebApp.ServicioCda.GenerarCda();
            inValue.codigoEntidad = codigoEntidad;
            inValue.codigoEmpresa = codigoEmpresa;
            inValue.montopago = montopago;
            Financiera.WebApp.ServicioCda.GenerarCda1 retVal = ((Financiera.WebApp.ServicioCda.ServicioCdaSoap)(this)).generarCda(inValue);
            return retVal.cda;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioCda.PagarCda1 Financiera.WebApp.ServicioCda.ServicioCdaSoap.pagarCda(Financiera.WebApp.ServicioCda.PagarCda request) {
            return base.Channel.pagarCda(request);
        }
        
        public Financiera.WebApp.ServicioCda.CdaType pagarCda(string cda) {
            Financiera.WebApp.ServicioCda.PagarCda inValue = new Financiera.WebApp.ServicioCda.PagarCda();
            inValue.cda = cda;
            Financiera.WebApp.ServicioCda.PagarCda1 retVal = ((Financiera.WebApp.ServicioCda.ServicioCdaSoap)(this)).pagarCda(inValue);
            return retVal.cda;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioCda.ListarCda1 Financiera.WebApp.ServicioCda.ServicioCdaSoap.listarCda(Financiera.WebApp.ServicioCda.ListarCda request) {
            return base.Channel.listarCda(request);
        }
        
        public Financiera.WebApp.ServicioCda.CdaType[] listarCda(string codigoEmpresa) {
            Financiera.WebApp.ServicioCda.ListarCda inValue = new Financiera.WebApp.ServicioCda.ListarCda();
            inValue.codigoEmpresa = codigoEmpresa;
            Financiera.WebApp.ServicioCda.ListarCda1 retVal = ((Financiera.WebApp.ServicioCda.ServicioCdaSoap)(this)).listarCda(inValue);
            return retVal.ListarCdaResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioCda.ConsultarCda1 Financiera.WebApp.ServicioCda.ServicioCdaSoap.consultarCda(Financiera.WebApp.ServicioCda.ConsultarCda request) {
            return base.Channel.consultarCda(request);
        }
        
        public Financiera.WebApp.ServicioCda.CdaType consultarCda(string cda) {
            Financiera.WebApp.ServicioCda.ConsultarCda inValue = new Financiera.WebApp.ServicioCda.ConsultarCda();
            inValue.cda = cda;
            Financiera.WebApp.ServicioCda.ConsultarCda1 retVal = ((Financiera.WebApp.ServicioCda.ServicioCdaSoap)(this)).consultarCda(inValue);
            return retVal.cda;
        }
    }
}
