package com.example.troyecomputersolutions;

public class ColleaguesClass {

    public String firstName;
    private String lastName;


    private String Key;
    public ColleaguesClass(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

}


/*package com.example.troyecomputersolutions;


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


*//**
 * A simple {@link Fragment} subclass.
 *//*
public class ColleaguesFragment extends Fragment {

    public ListView players;

    public ColleaguesFragment() {
        // Required empty public constructor
    }

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    public List<String> edmtDev = new ArrayList<>();
    public List<String> androidStudio = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colleagues, container, false);
        listView = (ExpandableListView) view.findViewById(R.id.ColleaguesExpandableList);

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        initData();
        String firstname = "";
        System.out.println("HELOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        ColleaguesClass user = new ColleaguesClass();

        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = mFirebaseDatabase.getReference("Employees");

        *//*final ListView listView = (ListView) view.findViewById(R.id.ColleaguesList);*//*
        final ArrayList<String> friends = new ArrayList<String>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot player : dataSnapshot.getChildren()) {
                    Log.i("Employee ID ", player.getKey());
                    Log.i("First Name", player.getFirst);

                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,
                        friends);


                *//*  listView.setAdapter(arrayAdapter);*//*
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        listAdapter = new ExpandableListAdapter(this.getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        return view;
    }


    private void initData() {
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
        listHash.put(listDataHeader.get(1), androidStudio);
    }
}*/
