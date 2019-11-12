package com.example.troyecomputersolutions;


import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColleaguesFragment extends Fragment {

    public ListView players;

    public ColleaguesFragment() {
        // Required empty public constructor
    }

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private List<String> listDataHeaders;
    private HashMap<String, List<String>> listHash;
    public static ArrayList<String> FirstName = new ArrayList<String>();
    public static ArrayList<String> LastName = new ArrayList<String>();
    public static ArrayList<String> Email = new ArrayList<String>();
    public static ArrayList<String> Skill = new ArrayList<String>();
    public static ArrayList<String> CellNumber = new ArrayList<String>();
    public List<String> edmtDev = new ArrayList<>();
    public List<String> androidStudio = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colleagues, container, false);
        listView = (ExpandableListView) view.findViewById(R.id.ColleaguesExpandableList);

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        final String firstname = "";
        System.out.println("HELOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        ColleaguesClass user = new ColleaguesClass();

        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = mFirebaseDatabase.getReference("Employees");

        /*final ListView listView = (ListView) view.findViewById(R.id.ColleaguesList);*/
        final ArrayList<String> friends = new ArrayList<String>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot player : dataSnapshot.getChildren()) {
                    Log.v(TAG,""+ player.getKey()); //displays the key for the node
                    Log.v(TAG,""+ player.child("FirstName").getValue());
                    Log.v(TAG,""+ player.child("LastName").getValue());
                    Log.v(TAG,""+ player.child("Email").getValue());
                    Log.v(TAG,""+ player.child("Skill").getValue());
                    Log.v(TAG,""+ player.child("CellNumber").getValue());
                    FirstName.add(player.child("FirstName").getValue().toString());
                    LastName.add(player.child("LastName").getValue().toString());
                    Email.add(player.child("Email").getValue().toString());
                    Skill.add(player.child("Skill").getValue().toString());
                    CellNumber.add(player.child("CellNumber").getValue().toString());

                }



                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,
                        friends);

                initData(FirstName, LastName, Email, Skill, CellNumber);
                listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
                listView.setAdapter(listAdapter);

                /*  listView.setAdapter(arrayAdapter);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



        return view;
    }


    private void initData(ArrayList<String> FirstName, ArrayList<String> LastName, ArrayList<String> Email, ArrayList<String> Skill, ArrayList<String> CellNumber) {
    /*  System.out.println("ssssssssssssssssssssssssssss " + ff.get(0));
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add("Topheader");
        listDataHeader.add("Topheader");
        listDataHeader.add("Topheader");


        List<String> edmtDev = new ArrayList<>();
        edmtDev.add("this is e list");

        List<String> androidStudio = new ArrayList<>();
        androidStudio.add("hello");


        listHash.put(listDataHeader.get(0), edmtDev);
        listHash.put(listDataHeader.get(1), androidStudio);*/








        listDataHeaders = new ArrayList<>();
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        for(int i = 0;i < FirstName.size();i++)
        {
            System.out.println("gffffffffffffffffffffffffffffffff " + i);

            listDataHeader.add(FirstName.get(i));
            List<String> email = new ArrayList<>();
            List<String> lastname = new ArrayList<>();
            List<String> skill = new ArrayList<>();
            List<String> cellnumber = new ArrayList<>();
            lastname.add("Last Name: " + LastName.get(i) + "\n" + "Email: " + Email.get(i) +"\n" + "Skill: " + Skill.get(i) + "\n" + "Cell Number: " + CellNumber.get(i) );



                listHash.put(listDataHeader.get(i),lastname);



        }




       // List<String> androidStudio = new ArrayList<>();
       // androidStudio.add("hello");





    }
}
