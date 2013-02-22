package com.bpingar.arias;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MisComprasActivity extends ListActivity implements OnClickListener {

	public static final String COMPRA = "compra";
	private final List<Compra> misCompras = new ArrayList<Compra>();
	private CompraAdapter misComprasAdapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mis_compras);

		final Button botonAnadirCompra = (Button) findViewById(R.id.anadirCompra);
		botonAnadirCompra.setOnClickListener(this);

		misComprasAdapter = new CompraAdapter(this,
				android.R.layout.simple_list_item_1, misCompras);
		setListAdapter(misComprasAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.activity_mis_compras, menu);
		return true;
	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.anadirCompra:
			startActivityForResult(new Intent(this, NuevaCompraActivity.class), 1);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(final int requestCode,
			final int resultCode, final Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				final Compra miNuevaCompra = (Compra) data.getExtras()
						.getSerializable(COMPRA);
				misCompras.add(miNuevaCompra);
				misComprasAdapter.notifyDataSetChanged();
				Toast.makeText(this, miNuevaCompra.getNombreProducto(),
						Toast.LENGTH_SHORT).show();
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(this, "Por favor, inténtelo de nuevo",
						Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
