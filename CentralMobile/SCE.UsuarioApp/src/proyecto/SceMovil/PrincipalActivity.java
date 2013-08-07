package proyecto.SceMovil;

import org.apache.cordova.DroidGap;

import android.os.Bundle;

public class PrincipalActivity extends DroidGap {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_principal);
		super.loadUrl("file:///android_asset/www/formatos/DGS/DGS015.html");
	}

}
