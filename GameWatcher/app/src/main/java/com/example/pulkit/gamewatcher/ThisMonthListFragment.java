package com.example.pulkit.gamewatcher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class ThisMonthListFragment extends Fragment {

    public static final String ARG_ITEM_ID = "thismonth_list";

    SharedPreferenceMonth sharedPreferenceMonth;
    SharedPreferenceFavorite sharedPreferenceFavorite;
    SharedPreferenceGeneric sharedPreferencePopular;

    List<Product> months;
    ArrayList<Product> favorites;
    String spinnervalue = "";
    private String[] arraySpinner;
    boolean monther = false;
    ListView monthsList;
    Activity activity;
    ThisMonthAdapter thisMonthAdapter;
    ProductListAdapter productListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        activity = getActivity();
        sharedPreferenceMonth = new SharedPreferenceMonth();
        sharedPreferenceFavorite = new SharedPreferenceFavorite();
        sharedPreferencePopular = new SharedPreferenceGeneric();
        months = sharedPreferenceMonth.getMonths(activity);
        thisMonthAdapter = new ThisMonthAdapter(activity, months);

        if (sharedPreferenceMonth.getMonths(activity) == null){
            months = new ArrayList<Product>();
            months.add(new Product(0, "Bloodborne: The Old Hunters", "02/03/2015", "PS4", 0, "RPG"));
            months.add(new Product(1, "Star Citizen", "08/23/2015", "PC", 0, "RTS"));
            months.add(new Product(2, "Kingdom Hearts III", "05/28/2015", "PS4/XBox 1", 0, "Adventure"));
            months.add(new Product(3, "Final Fantasy XV", "04/28/2015", "PS4", 0, "RPG"));
            months.add(new Product(4, "The Legend Of Zelda", "02/15/2016", "WII U", 0, "Adventure"));
            months.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
            months.add(new Product(6, "Pokemon Rainbow", "10/30/2015", "3DS", 0, "RPG"));
            months.add(new Product(7, "Destiny: The Taken King", "03/01/2015", "PS4/PC", 0, "RPG"));
            months.add(new Product(8, "Fallout 4", "05/02/2015", "PS4/XBO/PC", 0, "RPG"));
            months.add(new Product(9, "Mass Effect: Andromeda", "06/04/2015", "PS4/XBO", 0, "Shooter"));
            months.add(new Product(10, "No Man's Sky", "08/04/2015", "PS4", 0, "Adventure"));
            months.add(new Product(11, "Evolve", "07/04/2015", "PC", 0, "Shooter"));
            months.add(new Product(12, "Citizens of Earth", "09/05/2015", "PS4/XBox 1", 0, "RPG"));
            months.add(new Product(13, "Dying Light", "10/06/2015", "PS4", 0, "RPG"));
            months.add(new Product(14, "Heroes of Might & Magic III", "12/07/2015", "PS4", 0, "RTS"));
            months.add(new Product(15, "Life is Strange", "07/07/2015", "PC", 0, "Adventure"));
            months.add(new Product(16, "Grey Goo", "04/08/2015", "PC", 0, "RTS"));
            months.add(new Product(17, "Pix the Cat", "07/22/2015", "PC", 0, "Puzzle"));
            months.add(new Product(18, "Duke Nukem 3D", "04/21/2015", "PS Vita", 0, "Shooter"));
            months.add(new Product(19, "Saints Row IV", "02/20/2015", "XBox/PS4", 0, "RPG"));
            months.add(new Product(20, "Call of Duty: Black Ops III", "01/31/2015", "PS4/XBO", 0, "Shooter"));
            months.add(new Product(21, "Metal Gear Solid V", "10/29/2015", "PS4", 0, "Shooter"));
            months.add(new Product(22, "Age Of Mythology", "11/24/2015", "PC", 0, "RTS"));
            months.add(new Product(23, "Fruit Ninja", "11/30/2015", "PC", 0, "Puzzle"));
            months.add(new Product(24, "Mirror's Edge Catalyst", "03/23/2016", "PS4", 0, "Adventure"));
            months.add(new Product(25, "Tom Clancy's The Division", "04/08/2016", "XBox/PS4/XBO", 0, "Shooter"));
            months.add(new Product(26, "Call of Duty: Black Ops III", "07/31/2015", "PS4/XBO", 0, "Shooter"));
            months.add(new Product(27, "Resident Evil Zero", "02/05/2016", "PC/XBO/X360/PS4/PS3", 0, "Shooter"));
            months.add(new Product(28, "Tetris Ultimate", "01/11/2014", "PS4", 0, "Puzzle"));
            months.add(new Product(29, "Chariot", "12/03/2015", "WII U", 0, "Adventure"));
        }

        this.arraySpinner = new String[] {
                "Select Month","January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"
        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thismonth_list, container,
                false);

        thisMonthAdapter = new ThisMonthAdapter(activity, months);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);

        spinnervalue = spinner.getSelectedItem().toString();
        monthsList = (ListView) view.findViewById(R.id.list_thismonth);

        Typeface newtypeface = Typeface.createFromAsset(activity.getAssets(), "newtext.ttf");
        TextView suggText = (TextView) view.findViewById(R.id.releasedthismonth);
        suggText.setText(" Released During: ");
        suggText.setTypeface(newtypeface);

        AlertDialog.Builder monthalert = new AlertDialog.Builder(activity);
        monthalert.setMessage("Select a month?");
        monthalert.setCancelable(true);
        monthalert.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        monther = true;
                    }
                });
        monthalert.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        monther = false;
                        showAlert(getResources().getString(R.string.nothing_coming),
                                getResources().getString(R.string.comeback));

                    }
                });

        AlertDialog alert11 = monthalert.create();
        alert11.show();



        if (months != null){
            thisMonthAdapter = new ThisMonthAdapter(activity, months);
            monthsList.setAdapter(thisMonthAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                    Object spinner = parent.getItemAtPosition(pos);
                    spinnervalue = spinner.toString();

                    if (spinnervalue != null) {
                        if (spinnervalue.equals("January")) {
                            months.clear();
                            months.add(new Product(7, "Destiny: The Taken King", "03/01/2015", "PS4/PC", 0, "RPG"));
                            months.add(new Product(20, "Call of Duty: Black Ops III", "01/31/2015", "PS4/XBO", 0, "Shooter"));
                            months.add(new Product(28, "Tetris Ultimate", "01/11/2014", "PS4", 0, "Puzzle"));
                            thisMonthAdapter.notifyDataSetChanged();

                        }
                        if (spinnervalue.equals("February")) {
                            months.clear();
                            months.add(new Product(0, "Bloodborne: The Old Hunters", "02/03/2015", "PS4", 0, "RPG"));
                            months.add(new Product(4, "The Legend Of Zelda", "02/15/2016", "WII U", 0, "Adventure"));
                            months.add(new Product(8, "Fallout 4", "05/02/2015", "PS4/XBO/PC", 0, "RPG"));
                            months.add(new Product(19, "Saints Row IV", "02/20/2015", "XBox/PS4", 0, "RPG"));
                            months.add(new Product(27, "Resident Evil Zero", "02/05/2016", "PC/XBO/X360/PS4/PS3", 0, "Shooter"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("March")) {
                            months.clear();
                            months.add(new Product(7, "Destiny: The Taken King", "03/01/2015", "PS4/PC", 0, "RPG"));
                            months.add(new Product(24, "Mirror's Edge Catalyst", "03/23/2016", "PS4", 0, "Adventure"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("April")) {
                            months.clear();
                            months.add(new Product(3, "Final Fantasy XV", "04/28/2015", "PS4", 0, "RPG"));
                            months.add(new Product(16, "Grey Goo", "04/08/2015", "PC", 0, "RTS"));
                            months.add(new Product(18, "Duke Nukem 3D", "04/21/2015", "PS Vita", 0, "Shooter"));
                            months.add(new Product(25, "Tom Clancy's The Division", "04/08/2016", "XBox/PS4/XBO", 0, "Shooter"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("May")) {
                            months.clear();
                            months.add(new Product(2, "Kingdom Hearts III", "05/28/2015", "PS4/XBox 1", 0, "Adventure"));
                            months.add(new Product(8, "Fallout 4", "05/02/2015", "PS4/XBO/PC", 0, "RPG"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("June")) {
                            months.clear();
                            months.add(new Product(9, "Mass Effect: Andromeda", "06/04/2015", "PS4/XBO", 0, "Shooter"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("July")) {
                            months.clear();
                            months.add(new Product(11, "Evolve", "07/04/2015", "PC", 0, "Shooter"));
                            months.add(new Product(15, "Life is Strange", "07/07/2015", "PC", 0, "Adventure"));
                            months.add(new Product(16, "Grey Goo", "04/08/2015", "PC", 0, "RTS"));
                            months.add(new Product(17, "Pix the Cat", "07/22/2015", "PC", 0, "Puzzle"));
                            months.add(new Product(26, "Call of Duty: Black Ops III", "07/31/2015", "PS4/XBO", 0, "Shooter"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("August")) {
                            months.clear();
                            months.add(new Product(1, "Star Citizen", "08/23/2015", "PC", 0, "RTS"));
                            months.add(new Product(10, "No Man's Sky", "08/04/2015", "PS4", 0, "Adventure"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("September")) {
                            months.clear();
                            months.add(new Product(12, "Citizens of Earth", "09/05/2015", "PS4/XBox 1", 0, "RPG"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("October")) {
                            months.clear();
                            months.add(new Product(6, "Pokemon Rainbow", "10/30/2015", "3DS", 0, "RPG"));
                            months.add(new Product(13, "Dying Light", "10/06/2015", "PS4", 0, "RPG"));
                            months.add(new Product(21, "Metal Gear Solid V", "10/29/2015", "PS4", 0, "Shooter"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("November")) {
                            months.clear();
                            months.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
                            months.add(new Product(22, "Age Of Mythology", "11/24/2015", "PC", 0, "RTS"));
                            months.add(new Product(23, "Fruit Ninja", "11/30/2015", "PC", 0, "Puzzle"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                        if (spinnervalue.equals("December")) {
                            months.clear();
                            months.add(new Product(14, "Heroes of Might & Magic III", "12/07/2015", "PS4", 0, "RTS"));
                            months.add(new Product(29, "Chariot", "12/03/2015", "WII U", 0, "Adventure"));
                            thisMonthAdapter.notifyDataSetChanged();
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> parent) {

                }


            });

            monthsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                                  public void onItemClick(AdapterView<?> parent, View arg1,
                                                                          int position, long arg3) {

                                                      Product product = (Product) parent.getItemAtPosition(position);
                                                      Toast.makeText(activity, product.toString(), Toast.LENGTH_SHORT).show();

                                                  }
                                              }
            );

            monthsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view,
                                               int position, long id) {

                    Product product = (Product) parent.getItemAtPosition(position);
                    ImageView button = (ImageView) view
                            .findViewById(R.id.imgbtn_favorite);

                    String tag = button.getTag().toString();
                    if (tag.equalsIgnoreCase("grey")) {
                        sharedPreferenceFavorite.addFavorite(activity, months.get(position));
                        Toast.makeText(activity, activity.getResources().getString(R.string.add_favr),
                                Toast.LENGTH_SHORT).show();
                        button.setTag("red");
                        button.setImageResource(R.mipmap.heart_red);
                    } else {
                        sharedPreferenceFavorite.removeFavorite(activity, months.get(position));
                        sharedPreferencePopular.removeGeneric(activity, months.get(position));
                        button.setTag("grey");
                        button.setImageResource(R.mipmap.heart_grey);
                        Toast.makeText(activity, activity.getResources().getString(R.string.remove_favr),
                                Toast.LENGTH_SHORT).show();

                    }

                    thisMonthAdapter.notifyDataSetChanged();
                    return true;
                }
            });
        }
        return view;
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
        getActivity().setTitle(R.string.thismonth);
        getActivity().getActionBar().setTitle(R.string.thismonth);
        super.onResume();
    }
}
