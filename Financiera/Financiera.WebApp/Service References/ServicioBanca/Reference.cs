﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión del motor en tiempo de ejecución:2.0.50727.3649
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Financiera.WebApp.ServicioBanca {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="UsuarioType", Namespace="http://financiera.dsd.net/banca/")]
    [System.SerializableAttribute()]
    public partial class UsuarioType : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        private int usuarioIdField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string codigoField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true)]
        public int usuarioId {
            get {
                return this.usuarioIdField;
            }
            set {
                if ((this.usuarioIdField.Equals(value) != true)) {
                    this.usuarioIdField = value;
                    this.RaisePropertyChanged("usuarioId");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=1)]
        public string codigo {
            get {
                return this.codigoField;
            }
            set {
                if ((object.ReferenceEquals(this.codigoField, value) != true)) {
                    this.codigoField = value;
                    this.RaisePropertyChanged("codigo");
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
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="BancoType", Namespace="http://financiera.dsd.net/banca/")]
    [System.SerializableAttribute()]
    public partial class BancoType : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        private int bancoIdField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string nombreField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true)]
        public int bancoId {
            get {
                return this.bancoIdField;
            }
            set {
                if ((this.bancoIdField.Equals(value) != true)) {
                    this.bancoIdField = value;
                    this.RaisePropertyChanged("bancoId");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false)]
        public string nombre {
            get {
                return this.nombreField;
            }
            set {
                if ((object.ReferenceEquals(this.nombreField, value) != true)) {
                    this.nombreField = value;
                    this.RaisePropertyChanged("nombre");
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
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="CuentaType", Namespace="http://financiera.dsd.net/banca/")]
    [System.SerializableAttribute()]
    public partial class CuentaType : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        private int cuentaIdField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string numeroField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true)]
        public int cuentaId {
            get {
                return this.cuentaIdField;
            }
            set {
                if ((this.cuentaIdField.Equals(value) != true)) {
                    this.cuentaIdField = value;
                    this.RaisePropertyChanged("cuentaId");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false)]
        public string numero {
            get {
                return this.numeroField;
            }
            set {
                if ((object.ReferenceEquals(this.numeroField, value) != true)) {
                    this.numeroField = value;
                    this.RaisePropertyChanged("numero");
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
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://financiera.dsd.net/banca/", ConfigurationName="ServicioBanca.ServicioBancaSoap")]
    public interface ServicioBancaSoap {
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de elemento codigo del espacio de nombres http://financiera.dsd.net/banca/ no está marcado para aceptar valores nil.
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/banca/autenticar", ReplyAction="*")]
        Financiera.WebApp.ServicioBanca.autenticarResponse autenticar(Financiera.WebApp.ServicioBanca.autenticarRequest request);
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de elemento listarBancosPorUsuarioResult del espacio de nombres http://financiera.dsd.net/banca/ no está marcado para aceptar valores nil.
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/banca/listarBancosPorUsuario", ReplyAction="*")]
        Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioResponse listarBancosPorUsuario(Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequest request);
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de elemento listarCuentasPorUsuarioBancoResult del espacio de nombres http://financiera.dsd.net/banca/ no está marcado para aceptar valores nil.
        [System.ServiceModel.OperationContractAttribute(Action="http://financiera.dsd.net/banca/listarCuentasPorUsuarioBanco", ReplyAction="*")]
        Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoResponse listarCuentasPorUsuarioBanco(Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class autenticarRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="autenticar", Namespace="http://financiera.dsd.net/banca/", Order=0)]
        public Financiera.WebApp.ServicioBanca.autenticarRequestBody Body;
        
        public autenticarRequest() {
        }
        
        public autenticarRequest(Financiera.WebApp.ServicioBanca.autenticarRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://financiera.dsd.net/banca/")]
    public partial class autenticarRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string codigo;
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=1)]
        public string claveweb;
        
        public autenticarRequestBody() {
        }
        
        public autenticarRequestBody(string codigo, string claveweb) {
            this.codigo = codigo;
            this.claveweb = claveweb;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class autenticarResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="autenticarResponse", Namespace="http://financiera.dsd.net/banca/", Order=0)]
        public Financiera.WebApp.ServicioBanca.autenticarResponseBody Body;
        
        public autenticarResponse() {
        }
        
        public autenticarResponse(Financiera.WebApp.ServicioBanca.autenticarResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://financiera.dsd.net/banca/")]
    public partial class autenticarResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public Financiera.WebApp.ServicioBanca.UsuarioType usuario;
        
        public autenticarResponseBody() {
        }
        
        public autenticarResponseBody(Financiera.WebApp.ServicioBanca.UsuarioType usuario) {
            this.usuario = usuario;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class listarBancosPorUsuarioRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="listarBancosPorUsuario", Namespace="http://financiera.dsd.net/banca/", Order=0)]
        public Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequestBody Body;
        
        public listarBancosPorUsuarioRequest() {
        }
        
        public listarBancosPorUsuarioRequest(Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://financiera.dsd.net/banca/")]
    public partial class listarBancosPorUsuarioRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public int usuarioId;
        
        public listarBancosPorUsuarioRequestBody() {
        }
        
        public listarBancosPorUsuarioRequestBody(int usuarioId) {
            this.usuarioId = usuarioId;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class listarBancosPorUsuarioResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="listarBancosPorUsuarioResponse", Namespace="http://financiera.dsd.net/banca/", Order=0)]
        public Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioResponseBody Body;
        
        public listarBancosPorUsuarioResponse() {
        }
        
        public listarBancosPorUsuarioResponse(Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://financiera.dsd.net/banca/")]
    public partial class listarBancosPorUsuarioResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public Financiera.WebApp.ServicioBanca.BancoType[] listarBancosPorUsuarioResult;
        
        public listarBancosPorUsuarioResponseBody() {
        }
        
        public listarBancosPorUsuarioResponseBody(Financiera.WebApp.ServicioBanca.BancoType[] listarBancosPorUsuarioResult) {
            this.listarBancosPorUsuarioResult = listarBancosPorUsuarioResult;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class listarCuentasPorUsuarioBancoRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="listarCuentasPorUsuarioBanco", Namespace="http://financiera.dsd.net/banca/", Order=0)]
        public Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequestBody Body;
        
        public listarCuentasPorUsuarioBancoRequest() {
        }
        
        public listarCuentasPorUsuarioBancoRequest(Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://financiera.dsd.net/banca/")]
    public partial class listarCuentasPorUsuarioBancoRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public int usuarioId;
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=1)]
        public int bancoId;
        
        public listarCuentasPorUsuarioBancoRequestBody() {
        }
        
        public listarCuentasPorUsuarioBancoRequestBody(int usuarioId, int bancoId) {
            this.usuarioId = usuarioId;
            this.bancoId = bancoId;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class listarCuentasPorUsuarioBancoResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="listarCuentasPorUsuarioBancoResponse", Namespace="http://financiera.dsd.net/banca/", Order=0)]
        public Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoResponseBody Body;
        
        public listarCuentasPorUsuarioBancoResponse() {
        }
        
        public listarCuentasPorUsuarioBancoResponse(Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://financiera.dsd.net/banca/")]
    public partial class listarCuentasPorUsuarioBancoResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public Financiera.WebApp.ServicioBanca.CuentaType[] listarCuentasPorUsuarioBancoResult;
        
        public listarCuentasPorUsuarioBancoResponseBody() {
        }
        
        public listarCuentasPorUsuarioBancoResponseBody(Financiera.WebApp.ServicioBanca.CuentaType[] listarCuentasPorUsuarioBancoResult) {
            this.listarCuentasPorUsuarioBancoResult = listarCuentasPorUsuarioBancoResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    public interface ServicioBancaSoapChannel : Financiera.WebApp.ServicioBanca.ServicioBancaSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
    public partial class ServicioBancaSoapClient : System.ServiceModel.ClientBase<Financiera.WebApp.ServicioBanca.ServicioBancaSoap>, Financiera.WebApp.ServicioBanca.ServicioBancaSoap {
        
        public ServicioBancaSoapClient() {
        }
        
        public ServicioBancaSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ServicioBancaSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioBancaSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioBancaSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioBanca.autenticarResponse Financiera.WebApp.ServicioBanca.ServicioBancaSoap.autenticar(Financiera.WebApp.ServicioBanca.autenticarRequest request) {
            return base.Channel.autenticar(request);
        }
        
        public Financiera.WebApp.ServicioBanca.UsuarioType autenticar(string codigo, string claveweb) {
            Financiera.WebApp.ServicioBanca.autenticarRequest inValue = new Financiera.WebApp.ServicioBanca.autenticarRequest();
            inValue.Body = new Financiera.WebApp.ServicioBanca.autenticarRequestBody();
            inValue.Body.codigo = codigo;
            inValue.Body.claveweb = claveweb;
            Financiera.WebApp.ServicioBanca.autenticarResponse retVal = ((Financiera.WebApp.ServicioBanca.ServicioBancaSoap)(this)).autenticar(inValue);
            return retVal.Body.usuario;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioResponse Financiera.WebApp.ServicioBanca.ServicioBancaSoap.listarBancosPorUsuario(Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequest request) {
            return base.Channel.listarBancosPorUsuario(request);
        }
        
        public Financiera.WebApp.ServicioBanca.BancoType[] listarBancosPorUsuario(int usuarioId) {
            Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequest inValue = new Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequest();
            inValue.Body = new Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioRequestBody();
            inValue.Body.usuarioId = usuarioId;
            Financiera.WebApp.ServicioBanca.listarBancosPorUsuarioResponse retVal = ((Financiera.WebApp.ServicioBanca.ServicioBancaSoap)(this)).listarBancosPorUsuario(inValue);
            return retVal.Body.listarBancosPorUsuarioResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoResponse Financiera.WebApp.ServicioBanca.ServicioBancaSoap.listarCuentasPorUsuarioBanco(Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequest request) {
            return base.Channel.listarCuentasPorUsuarioBanco(request);
        }
        
        public Financiera.WebApp.ServicioBanca.CuentaType[] listarCuentasPorUsuarioBanco(int usuarioId, int bancoId) {
            Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequest inValue = new Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequest();
            inValue.Body = new Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoRequestBody();
            inValue.Body.usuarioId = usuarioId;
            inValue.Body.bancoId = bancoId;
            Financiera.WebApp.ServicioBanca.listarCuentasPorUsuarioBancoResponse retVal = ((Financiera.WebApp.ServicioBanca.ServicioBancaSoap)(this)).listarCuentasPorUsuarioBanco(inValue);
            return retVal.Body.listarCuentasPorUsuarioBancoResult;
        }
    }
}
