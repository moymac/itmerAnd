package com.moymac.meritapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private TextView testTV;
    private ApiInterface apiInterface;
    private FragmentTabHost mTabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createApiInterface();
        apiInterface.getTemplates().enqueue(templatesCallback);
        apiInterface.getProjects().enqueue(projectsCallback);
        apiInterface.postInputs(1, "AndroidTestingPOST").enqueue(inputsCallback);



    }


    private void createApiInterface() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {


//            case android.R.btn_post:
//                stepNum =
//                textInput =
//                apiInterface.postInputs(stepNum, textInput).enqueue(inputsCallback);
//                break;

        }
    }

    Callback<List<Templates>> templatesCallback = new Callback<List<Templates>>() {
        @Override
        public void onResponse(Call<List<Templates>> call, Response<List<Templates>> response) {
            if (response.isSuccessful()){
//
//                for (int i=0; i<response.body().size(); i++) {
//                    if (response.body().get(i).getParent()){
//                        ////SETUP AS GRANDPARENTS
//                        ///BUILD THE PARENT TABS!!!!!
//
//
//
//                    }
//                }
//

           //     Log.e("ID", String.valueOf(response.body().get(0).getId()));
           //     Log.e("Parent", response.body().get(0).getParent());
                Log.e("Name", response.body().get(0).getName());

                Log.e("Desc", response.body().get(0).getDesc());
                Log.e("Owner", String.valueOf(response.body().get(0).getOwner()));


//
//
//                tabHost = (TabHost) findViewById(R.id.tab_host);
//
//                for (int i=0; i<response.body().size(); i++) {
//                    Log.e("Name", response.body().get(i).getName());
//
//                    tabHost.setup();
//
//                    TabSpec tab1 = tabHost.newTabSpec("Tab_Name");
//                    View view = getLayoutInflater().inflate(R.layout.tab_layout,
//                            tabLayout, false);
//                    tab1.setIndicator(view);
//                    Intent j = new Intent(getApplicationContext(), MainActivity.class);
//                    tab1.setContent(j);
//
//                    tabHost.addTab(tab1);
//                }
//
//
//                List respBody = response.body();
//
//
//                Log.e("Name", response.body().get(0).getDesc());
//                Log.e("Name", String.valueOf(response.body().get(0).getOwner()));






//
//
//
//                TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
//                tabHost.setup();
//
//                TabSpec tab1 = tabHost.newTabSpec("Tab_Name");
//                tab1.setIndicator("Tab 1");
//
//                tab1.setContent(new MyTabContentFactory());
//
//                tabHost.addTab(tab1);

            }
        }

        @Override
        public void onFailure(Call<List<Templates>> call, Throwable t) {

        }
    };


    Callback<List<Projects>> projectsCallback = new Callback<List<Projects>>() {
        @Override
        public void onResponse(Call<List<Projects>> call, Response<List<Projects>> response) {
            if (response.isSuccessful()){

                mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
                mTabHost.setup(MainActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);

                mTabHost.addTab(
                        mTabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                        FragmentTab.class, null);
                mTabHost.addTab(
                        mTabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                        FragmentTab.class, null);
                mTabHost.addTab(
                        mTabHost.newTabSpec("tab3").setIndicator("Tab 3", null),
                        FragmentTab.class, null);
                mTabHost.addTab(
                        mTabHost.newTabSpec("tab4").setIndicator("Tab 4", null),
                        FragmentTab.class, null);
                mTabHost.addTab(
                        mTabHost.newTabSpec("tab5").setIndicator("Tab 5", null),
                        FragmentTab.class, null);
                mTabHost.addTab(
                        mTabHost.newTabSpec("tab6").setIndicator("Tab 6", null),
                        FragmentTab.class, null);


                Log.e("projDesc", response.body().get(0).getDesc());

            }
        }

        @Override
        public void onFailure(Call<List<Projects>> call, Throwable t) {

        }
    };

    Callback<Inputs> inputsCallback = new Callback<Inputs>() {
        @Override
        public void onResponse(Call<Inputs> call, Response<Inputs> response) {
            if (response.isSuccessful()) {
                Toast.makeText(MainActivity.this, "Input successful", Toast.LENGTH_LONG).show();
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                Toast.makeText(MainActivity.this, "You already upvoted this answer", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<Inputs> call, Throwable t) {
            t.printStackTrace();
        }
    };

}
//
//private class MyTabContentFactory implements TabContentFactory {
//    public View CreateTabContent(String tag) {
//
//        View view = this.getLayoutInflater()
//                .inflate(R.layout.tab_layout, (ViewGroup)this.FindViewById(R.id.tab_host), false);
//
//        ((TextView)view.findViewById(R.id.kablamTextView))
//                .setText("Some sentence which can be generated dynamically");
//        return view;
//    }
//}
