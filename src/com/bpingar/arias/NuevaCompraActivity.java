package com.bpingar.arias;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevaCompraActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueva_compra);

		final Button boton = (Button) findViewById(R.id.guardar_compra);
		boton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.activity_nueva_compra, menu);
		return true;
	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.guardar_compra:
			guardarCompra();
			break;

		default:
			break;
		}
	}

	private void guardarCompra() {
		final EditText nombreProducto = (EditText) findViewById(R.id.nombre_producto);
		final EditText numeroUnidades = (EditText) findViewById(R.id.numero_unidades);
		final EditText fechaCompra = (EditText) findViewById(R.id.fecha_compra);

		try {
			final Compra miNuevaCompra = new Compra(nombreProducto.getText()
					.toString(), Float.valueOf(numeroUnidades.getText()
					.toString()),
					new SimpleDateFormat("dd/MM/yyyy").parse(fechaCompra
							.getText().toString()));
			final Intent intent = new Intent();
			intent.putExtra(MisComprasActivity.COMPRA, miNuevaCompra);
			setResult(RESULT_OK, intent);
			finish();
		} catch (final NumberFormatException e) {
			Log.e("ARIAS", e.getMessage());
			Toast.makeText(this, R.string.error_numero_unidades_entero_decimal,
					Toast.LENGTH_LONG).show();
		} catch (final ParseException e) {
			Log.e("ARIAS", e.getMessage());
			Toast.makeText(this, R.string.error_fecha_compra_fecha_con_formato,
					Toast.LENGTH_LONG).show();
		}
	}

}
