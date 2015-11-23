package com.example.pulkit.gamewatcher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {

    CheckBox RPG, ADVENTURE, FPS, RTS, PUZZLE;

    public static final String ARG_ITEM_ID = "Product List";


    View view;
    ArrayList<Product> favorites;
    ArrayList<Product> products;
    ListView productListView;

    SharedPreferenceFavorite sharedPreferenceFavorite;
    SharedPreferenceGeneric sharedPreferencePopular;
    SharedPreferenceProduct sharedPreferenceProduct;

    Activity activity;
    ProductListAdapter productListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        sharedPreferenceProduct = new SharedPreferenceProduct();
        sharedPreferenceFavorite = new SharedPreferenceFavorite();
        sharedPreferencePopular = new SharedPreferenceGeneric();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_product_list, container, false);

        RPG = (CheckBox) view.findViewById(R.id.checkRPG);
        RPG.setChecked(false);
        ADVENTURE = (CheckBox) view.findViewById(R.id.checkADVENTURE);
        ADVENTURE.setChecked(false);
        FPS = (CheckBox) view.findViewById(R.id.checkFPS);
        FPS.setChecked(false);
        RTS = (CheckBox) view.findViewById(R.id.checkRTS);
        RTS.setChecked(false);
        PUZZLE = (CheckBox) view.findViewById(R.id.checkPUZZLE);
        PUZZLE.setChecked(false);


        products = new ArrayList<Product>();


        ADVENTURE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (ADVENTURE.isChecked()) {

                    RPG.setChecked(false);
                    RTS.setChecked(false);
                    FPS.setChecked(false);
                    PUZZLE.setChecked(false);

                    products.clear();

                    showAlert(
                            getResources().getString(R.string.filtergames),
                            getResources().getString(R.string.ok));

                    products.add(new Product(2, "Kingdom Hearts III", "10/28/2015", "PS4/XBox 1", 0, "Adventure"));
                    products.add(new Product(4, "The Legend Of Zelda", "04/15/2016", "WII U", 0, "Adventure"));
                    products.add(new Product(10, "No Man's Sky", "11/04/2015", "PS4", 0, "Adventure"));
                    products.add(new Product(15, "Life is Strange", "11/07/2015", "PC", 0, "Adventure"));
                    products.add(new Product(24, "Mirror's Edge Catalyst", "02/23/2016", "PS4", 0, "Adventure"));
                    products.add(new Product(29, "Chariot", "11/03/2015", "WII U", 0, "Adventure"));

                    productListAdapter.notifyDataSetChanged();

                }
            }

        });

        FPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (FPS.isChecked()) {

                    RPG.setChecked(false);
                    RTS.setChecked(false);
                    ADVENTURE.setChecked(false);
                    PUZZLE.setChecked(false);

                    products.clear();

                    showAlert(
                            getResources().getString(R.string.filtergames),
                            getResources().getString(R.string.ok));

                    products.add(new Product(9, "Mass Effect: Andromeda", "11/04/2015", "PS4/XBO", 0, "FPS"));
                    products.add(new Product(11, "Evolve", "11/04/2015", "PC", 0, "FPS"));
                    products.add(new Product(18, "Duke Nukem 3D", "11/21/2015", "PS Vita", 0, "FPS"));
                    products.add(new Product(20, "Call of Duty: Black Ops III", "10/31/2015", "PS4/XBO", 0, "FPS"));
                    products.add(new Product(21, "Metal Gear Solid V", "10/29/2015", "PS4", 0, "FPS"));
                    products.add(new Product(25, "Tom Clancy's The Division", "03/08/2016", "XBox/PS4/XBO", 0, "FPS"));
                    products.add(new Product(26, "Call of Duty: Black Ops III", "10/31/2015", "PS4/XBO", 0, "FPS"));
                    products.add(new Product(27, "Resident Evil Zero", "04/05/2016", "PC/XBO/X360/PS4/PS3", 0, "FPS"));

                    productListAdapter.notifyDataSetChanged();

                }
            }
        });

        RTS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (RTS.isChecked()) {

                    RPG.setChecked(false);
                    ADVENTURE.setChecked(false);
                    FPS.setChecked(false);
                    PUZZLE.setChecked(false);

                    products.clear();

                    showAlert(
                            getResources().getString(R.string.filtergames),
                            getResources().getString(R.string.ok));

                    products.add(new Product(1, "Star Citizen", "03/25/2016", "PC", 0, "RTS"));
                    products.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
                    products.add(new Product(14, "Heroes of Might & Magic III", "11/07/2015", "PS4", 0, "RTS"));
                    products.add(new Product(16, "Grey Goo", "11/08/2015", "PC", 0, "RTS"));
                    products.add(new Product(22, "Age Of Mythology", "11/31/2015", "PC", 0, "RTS"));

                    productListAdapter.notifyDataSetChanged();

                }
            }
        });

        RPG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (RPG.isChecked()) {

                    ADVENTURE.setChecked(false);
                    RTS.setChecked(false);
                    FPS.setChecked(false);
                    PUZZLE.setChecked(false);

                    products.clear();

                    showAlert(
                            getResources().getString(R.string.filtergames),
                            getResources().getString(R.string.ok));

                    products.add(new Product(0, "Bloodborne: The Old Hunters", "11/03/2015", "PS4", 0, "RPG"));
                    products.add(new Product(3, "Final Fantasy XV", "10/28/2015", "PS4", 0, "RPG"));
                    products.add(new Product(6, "Pokemon Rainbow", "10/30/2015", "3DS", 0, "RPG"));
                    products.add(new Product(7, "Destiny: The Taken King", "11/01/2015", "PS4/PC", 0, "RPG"));
                    products.add(new Product(8, "Fallout 4", "11/02/2015", "PS4/XBO/PC", 0, "RPG"));
                    products.add(new Product(12, "Citizens of Earth", "11/05/2015", "PS4/XBox 1", 0, "RPG"));
                    products.add(new Product(13, "Dying Light", "11/06/2015", "PS4", 0, "RPG"));
                    products.add(new Product(19, "Saints Row IV", "11/20/2015", "XBox/PS4", 0, "RPG"));

                    productListAdapter.notifyDataSetChanged();

                }
            }
        });

        PUZZLE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (PUZZLE.isChecked()) {

                    ADVENTURE.setChecked(false);
                    RTS.setChecked(false);
                    FPS.setChecked(false);
                    RPG.setChecked(false);

                    products.clear();

                    showAlert(
                            getResources().getString(R.string.filtergames),
                            getResources().getString(R.string.ok));

                    products.add(new Product(17, "Pix the Cat", "11/22/2015", "PC", 0, "Puzzle"));
                    products.add(new Product(23, "Fruit Ninja", "11/31/2015", "PC", 0, "Puzzle"));
                    products.add(new Product(28, "Tetris Ultimate", "11/11/2014", "PS4", 0, "Puzzle"));

                    productListAdapter.notifyDataSetChanged();

                }
            }
        });


        findViewsById(view);

        setProducts();

        return view;
    }



    public void setProducts() {

        products.add(new Product(0, "Bloodborne: The Old Hunters", "11/03/2015", "PS4", 0, "RPG"));
        products.add(new Product(1, "Star Citizen", "03/25/2016", "PC", 0, "RTS"));
        products.add(new Product(2, "Kingdom Hearts III", "10/28/2015", "PS4/XBox 1", 0, "Adventure"));
        products.add(new Product(3, "Final Fantasy XV", "10/28/2015", "PS4", 0, "RPG"));
        products.add(new Product(4, "The Legend Of Zelda", "04/15/2016", "WII U", 0, "Adventure"));
        products.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
        products.add(new Product(6, "Pokemon Rainbow", "10/30/2015", "3DS", 0, "RPG"));
        products.add(new Product(7, "Destiny: The Taken King", "11/01/2015", "PS4/PC", 0, "RPG"));
        products.add(new Product(8, "Fallout 4", "11/02/2015", "PS4/XBO/PC", 0, "RPG"));
        products.add(new Product(9, "Mass Effect: Andromeda", "11/04/2015", "PS4/XBO", 0, "FPS"));
        products.add(new Product(10, "No Man's Sky", "11/04/2015", "PS4", 0, "Adventure"));
        products.add(new Product(11, "Evolve", "11/04/2015", "PC", 0, "FPS"));
        products.add(new Product(12, "Citizens of Earth", "11/05/2015", "PS4/XBox 1", 0, "RPG"));
        products.add(new Product(13, "Dying Light", "11/06/2015", "PS4", 0, "RPG"));
        products.add(new Product(14, "Heroes of Might & Magic III", "11/07/2015", "PS4", 0, "RTS"));
        products.add(new Product(15, "Life is Strange", "11/07/2015", "PC", 0, "Adventure"));
        products.add(new Product(16, "Grey Goo", "11/08/2015", "PC", 0, "RTS"));
        products.add(new Product(17, "Pix the Cat", "11/22/2015", "PC", 0, "Puzzle"));
        products.add(new Product(18, "Duke Nukem 3D", "11/21/2015", "PS Vita", 0, "FPS"));
        products.add(new Product(19, "Saints Row IV", "11/20/2015", "XBox/PS4", 0, "RPG"));
        products.add(new Product(20, "Call of Duty: Black Ops III", "10/31/2015", "PS4/XBO", 0, "FPS"));
        products.add(new Product(21, "Metal Gear Solid V", "10/29/2015", "PS4", 0, "FPS"));
        products.add(new Product(22, "Age Of Mythology", "11/31/2015", "PC", 0, "RTS"));
        products.add(new Product(23, "Fruit Ninja", "11/31/2015", "PC", 0, "Puzzle"));
        products.add(new Product(24, "Mirror's Edge Catalyst", "02/23/2016", "PS4", 0, "Adventure"));
        products.add(new Product(25, "Tom Clancy's The Division", "03/08/2016", "XBox/PS4/XBO", 0, "FPS"));
        products.add(new Product(26, "Call of Duty: Black Ops III", "10/31/2015", "PS4/XBO", 0, "FPS"));
        products.add(new Product(27, "Resident Evil Zero", "04/05/2016", "PC/XBO/X360/PS4/PS3", 0, "FPS"));
        products.add(new Product(28, "Tetris Ultimate", "11/11/2014", "PS4", 0, "Puzzle"));
        products.add(new Product(29, "Chariot", "11/03/2015", "WII U", 0, "Adventure"));

    }

    public void findViewsById(View view) {
        productListView = (ListView) view.findViewById(R.id.list_product);


        if (products != null) {

            productListAdapter = new ProductListAdapter(activity, products);
            productListView.setAdapter(productListAdapter);

            productListView.setOnItemClickListener(new OnItemClickListener() {

                                                       public void onItemClick(AdapterView<?> parent, View arg1,
                                                                               int position, long arg3) {

                                                           Product product = (Product) parent.getItemAtPosition(position);
                                                           Toast.makeText(activity, product.toString(), Toast.LENGTH_LONG).show();

                                                       }
                                                   }
            );


            productListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view,
                                               int position, long id) {

                    ImageView button = (ImageView) view
                            .findViewById(R.id.imgbtn_favorite);

                    String tag = button.getTag().toString();
                    if (tag.equalsIgnoreCase("grey")) {
                        sharedPreferenceFavorite.addFavorite(activity, products.get(position));
                        Toast.makeText(activity, activity.getResources().getString(R.string.add_favr),
                                Toast.LENGTH_SHORT).show();
                        button.setTag("red");
                        button.setImageResource(R.mipmap.heart_red);
                    } else {
                        sharedPreferenceFavorite.removeFavorite(activity, products.get(position));
                        sharedPreferencePopular.removeGeneric(activity, products.get(position));
                        button.setTag("grey");
                        button.setImageResource(R.mipmap.grey_heart);
                        Toast.makeText(activity, activity.getResources().getString(R.string.remove_favr),
                                Toast.LENGTH_SHORT).show();

                    }

                    productListAdapter.notifyDataSetChanged();
                    return true;
                }
            });

        }
    }

    public void showAlert(String title, String message) {
        if (activity != null && !activity.isFinishing()) {
            AlertDialog alertDialog = new AlertDialog.Builder(activity)
                    .create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setCancelable(false);

            // setting OK Button
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            getFragmentManager().popBackStackImmediate();
                        }
                    });
            alertDialog.show();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onResume() {
        getActivity().setTitle(R.string.names);
        getActivity().getActionBar().setTitle(R.string.names);
        super.onResume();
    }
}



