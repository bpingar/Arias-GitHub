package com.bpingar.arias;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MisComprasActivity extends ListActivity implements OnClickListener {

	private List<Compra> misCompras = new ArrayList<Compra>();
	// private ArrayAdapter<String> misComprasAdapter;
	private CompraAdapter misComprasAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mis_compras);

		Button botonAnadirCompra = (Button) findViewById(R.id.anadirCompra);
		botonAnadirCompra.setOnClickListener(this);

		misComprasAdapter = new CompraAdapter(this,
				android.R.layout.simple_list_item_1, misCompras);
		setListAdapter(misComprasAdapter);
		// deseoAdapter = new DeseoAdapter(this,
		// R.layout.fila_lista_personalizada, lista);
		// setListAdapter(deseoAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mis_compras, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.anadirCompra:
			Intent intent = new Intent(this, NuevaCompraActivity.class);
			startActivityForResult(intent, 1);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				Compra miNuevaCompra = (Compra) data.getExtras().getSerializable(
						"compra");
				misCompras.add(miNuevaCompra);
				misComprasAdapter.notifyDataSetChanged();
				Toast.makeText(this, miNuevaCompra.getNombreProducto(),
						Toast.LENGTH_SHORT).show();
			}
			else if (resultCode== RESULT_CANCELED) {
				Toast.makeText(this,"Por favor, inténtelo de nuevo",
						Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
