package com.example.kevin.vale.Materias_Fisica;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevin.vale.Activitis.Menu_principal;
import com.example.kevin.vale.R;

public class Mecanicaa extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanicaa);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });


        expandableListView = (ExpandableListView) findViewById(R.id.lista_expandible_mecameca);

        ExpandableListViewmecaa adapter = new ExpandableListViewmecaa(Mecanicaa.this);
        expandableListView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Mecanicaa.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }

    public class ExpandableListViewmecaa extends BaseExpandableListAdapter {

        String[] gruponombres = {"Energía Cinética y Potencial","Trabajo,Energía y Potencia","Movimiento Parabólico",
                "Fuerza Centripeta","Caida Libre","Movimiento de Proyectiles en Ángulo","Movimiento Horizontal de Proyectiles",
                "Movimiento Vertical de Proyectiles","Movimiento Rectilíneo Uniforme","Movimiento Circular Uniforme",
                "Ley de la Gravitación Universal"};

        int[][] childNames = {{R.drawable.potencial_cinetica},{R.drawable.trabajo_energia_y_potencia},{R.drawable.mov_parabolico},
                {R.drawable.fuerza_centripeta},{R.drawable.cailda_libre},{R.drawable.movimientoproyectil_angulo},
                {R.drawable.mov_horizontal},{R.drawable.mov_vertical_proyectiles},{R.drawable.mov_rec_uni},{R.drawable.mov_circular_uniforme},
                {R.drawable.gravitacion_universal}};
        Context context;

        public ExpandableListViewmecaa(Context context) { //aqui colocar el int [] imagenes
            this.context = context;
        }

        @Override
        public int getGroupCount() {
            return gruponombres.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return childNames[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return gruponombres[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return childNames[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView txtview = new TextView(context);
            txtview.setText(gruponombres[i]);
            txtview.setPadding(100, 25, 0, 25);
            txtview.setTextSize(20);

            return txtview;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ImageView imag = new ImageView(context);
            imag.setImageResource(childNames[i][i1]);
            imag.setScaleType(ImageView.ScaleType.FIT_START);
            imag.setPadding(0, 75, 0, 0);

            return imag;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }
}

