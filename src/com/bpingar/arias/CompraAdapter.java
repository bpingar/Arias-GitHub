package com.bpingar.arias;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CompraAdapter extends ArrayAdapter<Compra> {

	public CompraAdapter(Context context, int textViewResourceId,
			List<Compra> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.compra_item, null);
		}

		Compra compra = getItem(position);

		TextView nombreProducto = (TextView) convertView
				.findViewById(R.id.nombre_producto_item);
		nombreProducto.setText(compra.getNombreProducto());

		TextView numeroUnidades = (TextView) convertView
				.findViewById(R.id.numero_unidades_item);
		numeroUnidades.setText(compra.getNumeroUnidades().toString());

		TextView fechaCompra = (TextView) convertView
				.findViewById(R.id.fecha_compra_item);
		fechaCompra.setText(new SimpleDateFormat("dd/MM/yyyy").format(compra
				.getFechaCompra()));

		return convertView;
	}
}
